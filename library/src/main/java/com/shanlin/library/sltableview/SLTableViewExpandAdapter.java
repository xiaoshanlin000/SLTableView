package com.shanlin.library.sltableview;

import android.graphics.Rect;

/**
 * Created by Shanlin on 2016/12/29.
 */

interface SLTableViewExpandAdapter {

    public boolean headerFloorOfPosition(int position);

    public int getSpanSize(int position);

    void getItemOffsets(Rect outRect, int position);
}
