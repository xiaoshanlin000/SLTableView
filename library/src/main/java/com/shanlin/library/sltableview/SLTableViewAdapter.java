package com.shanlin.library.sltableview;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class SLTableViewAdapter extends SLTableView.Adapter<SLTableViewCell> implements SLTableViewExpandAdapter {

    protected static final int HEAD = -1;
    protected static final int CONTENT = -2;
    protected static final int FLOOR = -3;

    protected Context context;
    protected SLTableView tableView;
    protected SLTableViewDataSource dataSource;
    protected SLTableViewDataSourcePlus dataSourcePlus;
    protected SLTableViewLayoutManagerExpand spanSizeLookup;
    protected LayoutInflater inflater;

    protected ArrayList<SLTypeIndexPath> typeIndexPaths = new ArrayList<>();
    protected ArrayList<SLSectionInfo> sectionInfos = new ArrayList<>();

    protected int headerBgColor;
    protected int headerTextColor;
    protected float headerTextSize;

    protected int floorBgColor;
    protected int floorTextColor;
    protected float floorTextSize;

    public SLTableViewAdapter(Context context,
                              SLTableView tableView,
                              SLTableViewDataSource dataSource,
                              SLTableViewDataSourcePlus dataSourcePlus,
                              SLTableViewLayoutManagerExpand spanSizeLookup) {
        this.context = context;
        this.tableView = tableView;
        this.dataSource = dataSource;
        this.dataSourcePlus = dataSourcePlus;
        this.spanSizeLookup = spanSizeLookup;
        inflater = LayoutInflater.from(context);
    }

    public void setHeaderBgColor(int headerBgColor) {
        this.headerBgColor = headerBgColor;
    }

    public int getHeaderTextColor() {
        return headerTextColor;
    }

    public void setHeaderTextColor(int headerTextColor) {
        this.headerTextColor = headerTextColor;
    }

    public float getHeaderTextSize() {
        return headerTextSize;
    }

    public void setHeaderTextSize(float headerTextSize) {
        this.headerTextSize = headerTextSize;
    }


    public void setFloorBgColor(int floorBgColor) {
        this.floorBgColor = floorBgColor;
    }


    public void setFloorTextColor(int floorTextColor) {
        this.floorTextColor = floorTextColor;
    }
    public void setFloorTextSize(float floorTextSize) {
        this.floorTextSize = floorTextSize;
    }

    @Override
    public int getItemViewType(int position) {
        SLTypeIndexPath typeIndexPath = typeIndexPaths.get(position);
        int type = typeIndexPath.getType();
        SLIndexPath indexPath = typeIndexPath.getIndexPath().clone();
        if (type == CONTENT){
            type =  dataSource.typeOfIndexPath(tableView,indexPath);
            typeIndexPath.setType(type);
        }
        return type;
    }

    @Override
    public SLTableViewCell onCreateViewHolder(ViewGroup parent, int viewType) {
        int type = viewType;
        SLTableViewCell cell = null;
        if (type == HEAD){
            View rootView = inflater.inflate(R.layout.title_floor_cell,parent,false);
            rootView.setBackgroundColor(tableView.getBgColor());
            SLTableViewCell viewCell = new DefaultTitleCell(rootView,headerBgColor,headerTextColor,headerTextSize);
            cell = viewCell;
        }else if (type == FLOOR){
            View rootView = inflater.inflate(R.layout.title_floor_cell,parent,false);
            rootView.setBackgroundColor(tableView.getBgColor());
            SLTableViewCell viewCell = new DefaultTitleCell(rootView,floorBgColor,floorTextColor,floorTextSize);
            cell = viewCell;
        }else{
            cell =  dataSource.cellForType(tableView,parent,type);
        }
        return cell;
    }

    @Override
    public void onBindViewHolder(SLTableViewCell cell, int position) {
        SLTypeIndexPath typeIndexPath = typeIndexPaths.get(position);
        int type = typeIndexPath.getType();
        SLIndexPath indexPath = typeIndexPath.getIndexPath().clone();
        if (type == HEAD) {
            DefaultTitleCell titleCell = (DefaultTitleCell) cell;
            if (dataSourcePlus != null){
                String title = dataSourcePlus.titleForHeaderInSection(tableView, indexPath.getSection());
                titleCell.title_floor_text.setText(title);
            }else{
                titleCell.title_floor_text.setText("");
            }
        }else if (type == FLOOR){
            DefaultTitleCell titleCell = (DefaultTitleCell) cell;
            if (dataSourcePlus != null) {
                String floor = dataSourcePlus.titleForFooterInSection(tableView,indexPath.getSection());
                titleCell.title_floor_text.setText(floor);
            }else{
                titleCell.title_floor_text.setText("");
            }
        }else{
            if (dataSource != null){
                cell.setIndexPath(indexPath);
                dataSource.onBindCell(tableView,cell,indexPath,type);
            }
        }

    }

    @Override
    public int getItemCount() {
        typeIndexPaths.clear();
        sectionInfos.clear();
        if (dataSource == null) return  0;
        int section = dataSource.numberOfSections(tableView);
        int headerCount=0;
        int floorCount=0;
        int count = 0;
        int row=0;
        for (int i = 0; i < section; i++) {
            boolean hidden = dataSourcePlus == null ? false : dataSourcePlus.hiddenHeaderInSection(tableView,i);
            SLSectionInfo sectionInfo = new SLSectionInfo(i);
            sectionInfo.setStartPosition(count+headerCount+floorCount);
            if (!hidden){
                typeIndexPaths.add(new SLTypeIndexPath(HEAD,new SLIndexPath(i,0)));
                headerCount++;
                sectionInfo.addHeader();
            }
            row = dataSource.numberOfRowsInSection(tableView,i);
            for (int j = 0; j < row; j++) {
                typeIndexPaths.add(new SLTypeIndexPath(CONTENT,new SLIndexPath(i,j)));
                sectionInfo.addRow();
            }
            hidden = dataSourcePlus == null ? true : dataSourcePlus.hiddenFooterInSection(tableView,i);
            if (!hidden) {
                typeIndexPaths.add(new SLTypeIndexPath(FLOOR,new SLIndexPath(i,0)));
                floorCount++;
                sectionInfo.addFloor();
            }
            count = count + row;
            sectionInfos.add(sectionInfo);
        }
        if (count == 0) return  0;
        return count + headerCount + floorCount;// 内容个数 + cell头尾个数
    }

    public void scrollToRowAtIndexPath(SLIndexPath indexPath) {
        int position = indexPathToPosition(indexPath);
        LinearLayoutManager manager = (LinearLayoutManager) tableView.getLayoutManager();
        manager.scrollToPositionWithOffset(position,0);
    }


    private int indexPathToPosition(SLIndexPath indexPath){
        int section = indexPath.getSection();
        int row = indexPath.getRow();
        int size = sectionInfos.size();
        if (section > size -1)return 0;
        SLSectionInfo info = sectionInfos.get(section);
        if (row > info.getRowCount() - 1){
            row = info.getRowCount() -1;
        }
        return info.getStartPosition() + info.getHeader() + row;
    }

    @Override
    public boolean headerFloorOfPosition(int position) {
        SLTypeIndexPath typeIndexPath = typeIndexPaths.get(position);
        int type = typeIndexPath.getType();
        return  type == HEAD || type == FLOOR;
    }

    @Override
    public int getSpanSize(int position) {
        SLTypeIndexPath typeIndexPath = typeIndexPaths.get(position);
        if (spanSizeLookup != null){
            return spanSizeLookup.gridSpanSizeOfIndexPath(typeIndexPath.getIndexPath().clone());
        }
        return 0;
    }

    @Override
    public void getItemOffsets(Rect outRect, int position) {
        if (spanSizeLookup != null){
            SLTypeIndexPath typeIndexPath = typeIndexPaths.get(position);
            int type = typeIndexPath.getType();
            if (type != HEAD && type != FLOOR){
                spanSizeLookup.getItemOffsets(outRect,typeIndexPath.getIndexPath().clone());
            }
        }
    }


    protected static class SLTypeIndexPath {
        private  int type;
        private SLIndexPath indexPath;
        private int stickyIndex = -1;

        public SLTypeIndexPath(int type, SLIndexPath indexPath) {
            this.type = type;
            this.indexPath = indexPath;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public SLIndexPath getIndexPath() {
            return indexPath;
        }

        public void setIndexPath(SLIndexPath indexPath) {
            this.indexPath = indexPath;
        }

        public int getStickyIndex() {
            return stickyIndex;
        }

        public void setStickyIndex(int stickyIndex) {
            this.stickyIndex = stickyIndex;
        }
    }

    protected static class SLSectionInfo{
        private int section;
        private int startPosition;
        private int header = 0;
        private int floor = 0;
        private int rowCount = 0;

        public SLSectionInfo(int section) {
            this.section = section;
        }

        public int getSection() {
            return section;
        }

        public void setSection(int section) {
            this.section = section;
        }

        public int getRowCount() {
            return rowCount;
        }

        public void setRowCount(int rowCount) {
            this.rowCount = rowCount;
        }

        public int getHeader() {
            return header;
        }

        public void setHeader(int header) {
            this.header = header;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public int getStartPosition() {
            return startPosition;
        }

        public void setStartPosition(int startPosition) {
            this.startPosition = startPosition;
        }

        public SLSectionInfo addRow(){
            rowCount++;
            return this;
        }

        public SLSectionInfo addHeader(){
            header++;
            return this;
        }
        public SLSectionInfo addFloor(){
            floor++;
            return this;
        }
    }

    protected static class DefaultTitleCell extends SLTableViewCell{
        public LinearLayout title_floor_root_layout;
        public TextView title_floor_text;
        private int bgColor;
        private int textColor;
        private float textSize;

        public DefaultTitleCell(View itemView, int bgColor, int textColor, float textSize) {
            super(itemView);
            this.bgColor = bgColor;
            this.textColor = textColor;
            this.textSize = textSize;
            title_floor_root_layout = (LinearLayout) itemView.findViewById(R.id.title_floor_root_layout);
            title_floor_text = (TextView) itemView.findViewById(R.id.title_floor_text);
            title_floor_root_layout.setBackgroundColor(bgColor);
            title_floor_text.setTextColor(textColor);
            title_floor_text.setTextSize(textSize);
        }


    }

}