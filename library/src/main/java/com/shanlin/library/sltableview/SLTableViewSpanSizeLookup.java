package com.shanlin.library.sltableview;

/**
 * Created by Shanlin on 2016/12/30.
 */

public interface SLTableViewSpanSizeLookup {
    /**
     *
     * 使用GridLayoutManager时,调用
     *
     * @param indexPath {@link SLIndexPath}
     * @return default 0
     */
    public int spanSizeOfIndexPath(SLIndexPath indexPath);
}
