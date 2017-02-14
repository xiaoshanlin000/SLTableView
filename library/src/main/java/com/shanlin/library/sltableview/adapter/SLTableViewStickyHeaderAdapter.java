package com.shanlin.library.sltableview.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;

import com.shanlin.library.sltableview.SLTableViewCell;

public interface SLTableViewStickyHeaderAdapter{
    public int stickyHeaderType();
    public boolean stickyHeader(int position);
    public boolean showStickyHeader(int position);
    public int getHeaderPosition(int position);
    public SLTableViewCell onCreateHeaderCell(RecyclerView parent, int position);
    public void onBindHeaderCell(SLTableViewCell cell,int position);
    public void getItemOffsets(Rect outRect, int position);
}