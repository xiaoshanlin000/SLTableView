package com.shanlin.library.sltableview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Shanlin on 2016/12/29.
 */

public class SLTableViewStickyAdapter extends SLTableViewAdapter implements SLTableViewStickyHeaderAdapter {

    public SLTableViewStickyAdapter(Context context, SLTableView tableView, SLTableViewDataSource dataSource, SLTableViewDataSourcePlus dataSourcePlus) {
        super(context, tableView, dataSource, dataSourcePlus);
    }

    @Override
    public int getItemCount() {
        typeIndexPaths.clear();
        if (dataSource == null) return  0;
        int section = dataSource.numberOfSections(tableView);
        int headerCount=0;
        int floorCount=0;
        int count = 0;
        int row=0;
        for (int i = 0; i < section; i++) {
            SLSectionInfo sectionInfo = new SLSectionInfo(i);
            sectionInfo.setStartPosition(count+headerCount+floorCount);
            row = dataSource.numberOfRowsInSection(tableView,i);
            int j;
            for (j = 0; j < row; j++) {
                SLTypeIndexPath typeIndexPath = new SLTypeIndexPath(CONTENT, new SLIndexPath(i,j));
                typeIndexPath.setStickyIndex(j);
                typeIndexPaths.add(typeIndexPath);
                sectionInfo.addRow();
            }
           boolean hidden = dataSourcePlus == null ? true : dataSourcePlus.hiddenFooterInSection(tableView,i);
            if (!hidden) {
                SLTypeIndexPath typeIndexPath = new SLTypeIndexPath(FLOOR,new SLIndexPath(i,0));
                typeIndexPath.setStickyIndex(j);
                typeIndexPaths.add(typeIndexPath);
                floorCount++;
                sectionInfo.addFloor();
            }
            count = count + row;
            sectionInfos.add(sectionInfo);
        }
        if (count == 0) return  0;
        return count + headerCount + floorCount;// 内容个数 + cell头尾个数
    }

    //SLTableViewStickyHeaderAdapter
    @Override
    public int stickyHeaderType() {
        return HEAD;
    }

    @Override
    public boolean stickyHeader(int position) {
        SLTypeIndexPath typeIndexPath = typeIndexPaths.get(position);
        boolean hidden = dataSourcePlus == null ? false : dataSourcePlus.hiddenHeaderInSection(tableView,typeIndexPath.getIndexPath().getSection());
        if (hidden)return false;
        return typeIndexPath.getStickyIndex()==0;
    }

    @Override
    public boolean showStickyHeader(int position) {
        SLTypeIndexPath typeIndexPath = typeIndexPaths.get(position);
        boolean hidden = dataSourcePlus == null ? false : dataSourcePlus.hiddenHeaderInSection(tableView,typeIndexPath.getIndexPath().getSection());
        if (hidden)return false;
        return  typeIndexPath.getStickyIndex() < dataSource.numberOfRowsInSection(tableView,typeIndexPath.getIndexPath().getSection());
    }

    @Override
    public int getHeaderPosition(int position) {
        SLTypeIndexPath typeIndexPath = typeIndexPaths.get(position);
        return typeIndexPath.getIndexPath().getSection();
    }

    @Override
    public SLTableViewCell onCreateHeaderCell(RecyclerView parent, int position) {
        View rootView = inflater.inflate(R.layout.title_floor_cell,parent,false);
        rootView.setBackgroundColor(tableView.getBgColor());
        SLTableViewCell viewCell = new DefaultTitleCell(rootView,headerBgColor,headerTextColor,headerTextSize);
        return viewCell;
    }

    @Override
    public void onBindHeaderCell(SLTableViewCell cell, int position) {
        SLTypeIndexPath typeIndexPath = typeIndexPaths.get(position);
        SLIndexPath indexPath = typeIndexPath.getIndexPath();
        DefaultTitleCell titleCell = (DefaultTitleCell) cell;
        if (dataSourcePlus != null){
            String title = dataSourcePlus.titleForHeaderInSection(tableView, indexPath.getSection());
            titleCell.title_floor_text.setText(title);
        }else{
            titleCell.title_floor_text.setText("");
        }
    }
}
