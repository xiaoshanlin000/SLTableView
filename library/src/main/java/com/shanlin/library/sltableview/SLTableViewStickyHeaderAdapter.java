package com.shanlin.library.sltableview;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Shanlin on 2016/12/29.
 */

public interface SLTableViewStickyHeaderAdapter{
    public int stickyHeaderType();
    public boolean stickyHeader(int position);
    public boolean showStickyHeader(int position);
    public int getHeaderPosition(int position);
    public SLTableViewCell onCreateHeaderCell(RecyclerView parent, int position);
    public void onBindHeaderCell(SLTableViewCell cell,int position);
}
