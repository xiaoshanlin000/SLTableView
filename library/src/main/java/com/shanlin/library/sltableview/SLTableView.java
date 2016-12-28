package com.shanlin.library.sltableview;

import android.content.Context;
import android.support.annotation.Nullable;
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

    public static class Builder{

        private Context context;
        private SLTableView tableView;
        private LayoutParams layoutParams;

        private SLTableViewDataSource tableViewDataSource;
        private SLTableViewDataSourcePlus tableViewDataSourcePlus;

        private int bgColor = 0;

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
            tableView.setLayoutManager(new LinearLayoutManager(context));
            tableView.setAdapter(new SLTableViewAdapter(context,tableView,tableViewDataSource,tableViewDataSourcePlus));
            return tableView;
        }
    }

}
