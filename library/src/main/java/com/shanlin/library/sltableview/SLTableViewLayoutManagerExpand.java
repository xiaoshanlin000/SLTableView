package com.shanlin.library.sltableview;

import android.graphics.Rect;

/**
 * Created by Shanlin on 2016/12/30.
 */

public interface SLTableViewLayoutManagerExpand {
    /**
     *
     * 使用GridLayoutManager时,设置某一行跨度
     *
     * @param indexPath {@link SLIndexPath} 位置
     * @return default 0
     */
    public int gridSpanSizeOfIndexPath(SLIndexPath indexPath);

    /**
     * 设置grid间距
     * @param outRect rect
     * @param indexPath 位置
     */
    void getItemOffsets(Rect outRect, SLIndexPath indexPath);
}
