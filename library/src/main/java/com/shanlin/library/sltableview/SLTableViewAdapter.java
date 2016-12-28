package com.shanlin.library.sltableview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class SLTableViewAdapter extends SLTableView.Adapter<SLTableViewCell>{
    private static final int HEAD = -1;
    private static final int CONTENT = -2;
    private static final int FLOOR = -3;

    private Context context;
    private SLTableView tableView;
    private SLTableViewDataSource dataSource;
    private SLTableViewDataSourcePlus dataSourcePlus;
    private LayoutInflater inflater;

    private ArrayList<SLTypeIndexPath> typeIndexPaths = new ArrayList<>();

    public SLTableViewAdapter(Context context,
                              SLTableView tableView,
                              SLTableViewDataSource dataSource,
                              SLTableViewDataSourcePlus dataSourcePlus) {
        this.context = context;
        this.tableView = tableView;
        this.dataSource = dataSource;
        this.dataSourcePlus = dataSourcePlus;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        SLTypeIndexPath typeIndexPath = typeIndexPaths.get(position);
        int type = typeIndexPath.getType();
        SLIndexPath indexPath = typeIndexPath.getIndexPath();
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
            SLTableViewCell viewCell = new DefaultTitleCell(rootView);
            cell = viewCell;
        }else if (type == FLOOR){
            View rootView = inflater.inflate(R.layout.title_floor_cell,parent,false);
            rootView.setBackgroundColor(tableView.getBgColor());
            SLTableViewCell viewCell = new DefaultTitleCell(rootView);
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
        SLIndexPath indexPath = typeIndexPath.getIndexPath();
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
                dataSource.onBindCell(tableView,cell,indexPath,type);
            }
        }

    }

    @Override
    public int getItemCount() {
        typeIndexPaths.clear();
        if (dataSource == null) return  0;
        int section = dataSource.numberOfSections(tableView);
        int hiddenCount = 0;
        int count = 0;
        int row=0;
        for (int i = 0; i < section; i++) {
            boolean hidden = dataSourcePlus == null ? false : dataSourcePlus.hiddenForHeaderInSection(tableView,i);
            if (!hidden){
                typeIndexPaths.add(new SLTypeIndexPath(HEAD,new SLIndexPath(0,i)));
            }else{
                hiddenCount++;
            }
            row = dataSource.numberOfRowsInSection(tableView,i);
            for (int j = 0; j < row; j++) {
                typeIndexPaths.add(new SLTypeIndexPath(CONTENT,new SLIndexPath(j,i)));
            }
            hidden = dataSourcePlus == null ? true : dataSourcePlus.hiddenForFooterInSection(tableView,i);
            if (!hidden) {
                typeIndexPaths.add(new SLTypeIndexPath(FLOOR,new SLIndexPath(0,i)));
            }else{
                hiddenCount++;
            }
            count = count + row;
        }
        if (count == 0) return  0;
        return count + section + section - hiddenCount;// 内容个数 + cell头尾 - 隐藏个数
    }


    private static class SLTypeIndexPath {
        private  int type;
        private SLIndexPath indexPath;

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
    }

    private static class DefaultTitleCell extends SLTableViewCell{
        public LinearLayout title_floor_root_layout;
        public TextView title_floor_text;
        public DefaultTitleCell(View itemView) {
            super(itemView);
            title_floor_root_layout = (LinearLayout) itemView.findViewById(R.id.title_floor_root_layout);
            title_floor_text = (TextView) itemView.findViewById(R.id.title_floor_text);
        }
    }

}