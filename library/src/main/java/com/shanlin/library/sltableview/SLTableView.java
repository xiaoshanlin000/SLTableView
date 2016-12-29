package com.shanlin.library.sltableview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
        private SLTableViewSpanSizeLookup spanSizeLookup;
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

        /**
         * 设置{@link SLTableView}的数据源
         *
         * 必须设置,不然不会显示列表.
         * @param tableViewDataSource {@link SLTableViewDataSource}
         * @return {@link Builder}
         */
        public Builder setTableViewDataSource(SLTableViewDataSource tableViewDataSource) {
            this.tableViewDataSource = tableViewDataSource;
            return this;
        }

        /**
         * 设置{@link SLTableView}的扩展项
         *
         * @param tableViewDataSourcePlus {@link SLTableViewDataSourcePlus}
         * @return {@link Builder}
         */
        public Builder setTableViewDataSourcePlus(SLTableViewDataSourcePlus tableViewDataSourcePlus) {
            this.tableViewDataSourcePlus = tableViewDataSourcePlus;
            return this;
        }

        public Builder setLayoutParams(LayoutParams layoutParams) {
            this.layoutParams = layoutParams;
            return this;
        }

        /**
         *设置{@link SLTableView}背景色
         * @param bgColor
         * @return {@link Builder}
         */
        public Builder setBgColor(int bgColor) {
            this.bgColor = bgColor;
            return this;
        }

        /**
         * 设置每组的header是否浮动.
         * @param stickyHeader true 浮动, false 不浮动
         * @return {@link Builder}
         */
        public Builder showStickyHeader(boolean stickyHeader) {
            this.stickyHeader = stickyHeader;
            return this;
        }

        /**
         *设置header背景色
         * @param headerBgColor 颜色值
         * @return {@link Builder}
         */
        public Builder setHeaderBgColor(int headerBgColor) {
            this.headerBgColor = headerBgColor;
            return this;
        }

        /**
         *设置header文字颜色
         * @param headerTextColor 颜色值
         * @return {@link Builder}
         */
        public Builder setHeaderTextColor(int headerTextColor) {
            this.headerTextColor = headerTextColor;
            return this;
        }

        /**
         *设置header文字大小
         * @param headerTextSize 颜色值
         * @return {@link Builder}
         */
        public Builder setHeaderTextSize(float headerTextSize) {
            this.headerTextSize = headerTextSize;
            return this;
        }

        /**
         *设置floor背景色
         * @param floorBgColor 颜色值
         * @return {@link Builder}
         */
        public Builder setFloorBgColor(int floorBgColor) {
            this.floorBgColor = floorBgColor;
            return this;
        }

        /**
         *设置floor文字色
         * @param floorTextColor 颜色值
         * @return {@link Builder}
         */
        public Builder setFloorTextColor(int floorTextColor) {
            this.floorTextColor = floorTextColor;
            return this;
        }

        /**
         *设置floor文字大小
         * @param floorTextSize 颜色值
         * @return {@link Builder}
         */
        public Builder setFloorTextSize(float floorTextSize) {
            this.floorTextSize = floorTextSize;
            return this;
        }

        public Builder setLayoutManager(LayoutManager layoutManager) {
            this.layoutManager = layoutManager;
            return this;
        }

        /**
         *
         * 和 Builder#setLayoutManager(LayoutManager)  GridLayoutManager一起使用
         * @param spanSizeLookup {@link SLTableViewSpanSizeLookup}
         * @return {@link Builder}
         */
        public Builder setSpanSizeLookup(SLTableViewSpanSizeLookup spanSizeLookup) {
            this.spanSizeLookup = spanSizeLookup;
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
                adapter = new SLTableViewAdapter(context,tableView,tableViewDataSource,tableViewDataSourcePlus,spanSizeLookup);
                tableView.setTableViewAdapter(adapter);
            }else{
                adapter = new SLTableViewStickyAdapter(context,tableView,tableViewDataSource,tableViewDataSourcePlus,spanSizeLookup);
                SLStickyHeaderDecoration decoration = new SLStickyHeaderDecoration((SLTableViewStickyAdapter)adapter);
                tableView.setTableViewAdapter(adapter);
                tableView.addItemDecoration(decoration);

            }
            if (layoutManager instanceof GridLayoutManager
                    && ((GridLayoutManager) layoutManager).getSpanSizeLookup() instanceof GridLayoutManager.DefaultSpanSizeLookup){
                ((GridLayoutManager) layoutManager).setSpanSizeLookup(new SLDefaultSpanSizeLookup(adapter, (GridLayoutManager) layoutManager));
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

    private static class SLDefaultSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
        private SLSpanSizeLookup spanSizeLookup;
        private GridLayoutManager layoutManager;

        public SLDefaultSpanSizeLookup(SLSpanSizeLookup spanSizeLookup, GridLayoutManager layoutManager) {
            this.spanSizeLookup = spanSizeLookup;
            this.layoutManager = layoutManager;
        }

        @Override
        public int getSpanSize(int position) {
            if (spanSizeLookup.headerFloorOfPosition(position)){
                return layoutManager.getSpanCount();
            }else {
                int size = spanSizeLookup.getSpanSize(position);
                return size > 0 ? size : 1;
            }
        }
    }

}
