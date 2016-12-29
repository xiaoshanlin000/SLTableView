package com.shanlin.library.sltableview;

/**
 * Created by Shanlin on 2016/12/29.
 */

public interface SLSpanSizeLookup {

    public boolean headerFloorOfPosition(int position);

    public int getSpanSize(int position);
}
