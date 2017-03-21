package com.shanlin.sltableview.fragment.base;

import com.shanlin.sltableview.R;

/**
 *
 * 上下两个fragment中间层,切换父类的时候,不用动子类.
 * Created by Shanlin on 2017/1/1.
 */

public abstract class CellBaseFragment extends CellAbstractFragment {
    @Override
    public int layoutId() {
        return R.layout.fragment_cell_root;
    }

}
