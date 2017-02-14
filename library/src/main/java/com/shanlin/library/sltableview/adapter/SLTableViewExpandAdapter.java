package com.shanlin.library.sltableview.adapter;

import android.graphics.Rect;

public interface SLTableViewExpandAdapter {

    public boolean headerFloorOfPosition(int position);

    public int getSpanSize(int position);

    void getItemOffsets(Rect outRect, int position);
}