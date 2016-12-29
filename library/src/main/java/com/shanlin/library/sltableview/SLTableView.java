package com.shanlin.library.sltableview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewGroup;


/**
 * Created by Shanlin on 2016/12/27.
 */

public class SLTableView extends RecyclerView {

    private SLTableViewDataSource tableViewDataSource;
    private SLTableViewDataSourcePlus tableViewDataSourcePlus;
    private SLTableViewAdapter tableViewAdapter;

    private int bgColor;

    public SLTableView(Context context) {
        super(context);
    }

    public SLTableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SLTableView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setTableViewDataSource(SLTableViewDataSource tableViewDataSource) {
        this.tableViewDataSource = tableViewDataSource;
    }

    public void setTableViewDataSourcePlus(SLTableViewDataSourcePlus tableViewDataSourcePlus) {
        this.tableViewDataSourcePlus = tableViewDataSourcePlus;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public void notifyDataSetChanged() {
        this.getAdapter().notifyDataSetChanged();
    }

    public SLTableViewAdapter getTableViewAdapter() {
        return tableViewAdapter;
    }

    public void setTableViewAdapter(SLTableViewAdapter tableViewAdapter) {
        this.tableViewAdapter = tableViewAdapter;
        this.setAdapter(tableViewAdapter);
    }

    public void scrollToRowAtIndexPath(SLIndexPath indexPath){
        this.tableViewAdapter.scrollToRowAtIndexPath(indexPath);
    }

    public static class Builder{

        private Context context;
        private SLTableView tableView;
        private LayoutParams layoutParams;

        private SLTableViewDataSource tableViewDataSource;
        private SLTableViewDataSourcePlus tableViewDataSourcePlus;
        private LayoutManager layoutManager;

        private boolean stickyHeader;

        private int bgColor = 0;

        private int headerBgColor;
        private int headerTextColor;
        private float headerTextSize;

        private int floorBgColor;
        private int floorTextColor;
        private float floorTextSize;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTableViewDataSource(SLTableViewDataSource tableViewDataSource) {
            this.tableViewDataSource = tableViewDataSource;
            return this;
        }

        public Builder setTableViewDataSourcePlus(SLTableViewDataSourcePlus tableViewDataSourcePlus) {
            this.tableViewDataSourcePlus = tableViewDataSourcePlus;
            return this;
        }

        public Builder setLayoutParams(LayoutParams layoutParams) {
            this.layoutParams = layoutParams;
            return this;
        }

        public Builder setBgColor(int bgColor) {
            this.bgColor = bgColor;
            return this;
        }

        public Builder showStickyHeader(boolean stickyHeader) {
            this.stickyHeader = stickyHeader;
            return this;
        }

        public Builder setHeaderBgColor(int headerBgColor) {
            this.headerBgColor = headerBgColor;
            return this;
        }

        public Builder setHeaderTextColor(int headerTextColor) {
            this.headerTextColor = headerTextColor;
            return this;
        }

        public Builder setHeaderTextSize(float headerTextSize) {
            this.headerTextSize = headerTextSize;
            return this;
        }

        public Builder setFloorBgColor(int floorBgColor) {
            this.floorBgColor = floorBgColor;
            return this;
        }

        public Builder setFloorTextColor(int floorTextColor) {
            this.floorTextColor = floorTextColor;
            return this;
        }

        public Builder setFloorTextSize(float floorTextSize) {
            this.floorTextSize = floorTextSize;
            return this;
        }

        public Builder setLayoutManager(LayoutManager layoutManager) {
            this.layoutManager = layoutManager;
            return this;
        }

        public SLTableView build(){
            if (tableView == null){
                tableView = new SLTableView(context);
            }
            if (layoutParams != null){
                tableView.setLayoutParams(layoutParams);
            }else{
                tableView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            }
            if (bgColor != 0){
                tableView.setBgColor(bgColor);
            }else{
                tableView.setBgColor(context.getResources().getColor(R.color.color_title_floor_background));
            }
            tableView.setBackgroundColor(context.getResources().getColor(R.color.color_background));
            tableView.setTableViewDataSource(tableViewDataSource);
            tableView.setTableViewDataSourcePlus(tableViewDataSourcePlus);
            if (layoutManager != null){
                tableView.setLayoutManager(layoutManager);
            }else {
                tableView.setLayoutManager(new LinearLayoutManager(context));
            }
            SLTableViewAdapter adapter = null;
            if (!stickyHeader){
                adapter = new SLTableViewAdapter(context,tableView,tableViewDataSource,tableViewDataSourcePlus);
                tableView.setTableViewAdapter(adapter);
            }else{
                adapter = new SLTableViewStickyAdapter(context,tableView,tableViewDataSource,tableViewDataSourcePlus);
                SLStickyHeaderDecoration decoration = new SLStickyHeaderDecoration((SLTableViewStickyAdapter)adapter);
                tableView.setTableViewAdapter(adapter);
                tableView.addItemDecoration(decoration);

            }
            if (layoutManager instanceof GridLayoutManager
                    && ((GridLayoutManager) layoutManager).getSpanSizeLookup() instanceof GridLayoutManager.DefaultSpanSizeLookup){
                ((GridLayoutManager) layoutManager).setSpanSizeLookup(new SLSpanSizeLookup(adapter, (GridLayoutManager) layoutManager));
            }
            int bgcolor = context.getResources().getColor(R.color.color_background);
            int textcolor = context.getResources().getColor(R.color.color_text_grey);
            float textsize = context.getResources().getDimension(R.dimen.dimen_cell_header_floor);
            adapter.setHeaderBgColor(headerBgColor != 0 ? headerBgColor : bgcolor);
            adapter.setHeaderTextColor(headerTextColor != 0 ? headerTextColor : textcolor);
            adapter.setHeaderTextSize(headerTextSize != 0 ? headerTextSize : textsize);

            adapter.setFloorBgColor(floorBgColor != 0 ? floorBgColor : bgcolor);
            adapter.setFloorTextColor(floorTextColor != 0 ? floorTextColor : textcolor);
            adapter.setFloorTextSize(floorTextSize != 0 ? floorTextSize : textsize);

            return tableView;
        }
    }

    private static class SLSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
        private SLTableViewHeaderFloor headerFloor;
        private GridLayoutManager layoutManager;

        public SLSpanSizeLookup(SLTableViewHeaderFloor headerFloor, GridLayoutManager layoutManager) {
            this.headerFloor = headerFloor;
            this.layoutManager = layoutManager;
        }

        @Override
        public int getSpanSize(int position) {
            if (headerFloor.headerFloorOfPosition(position)){
                return layoutManager.getSpanCount();
            }
            return 1;
        }
    }

}
