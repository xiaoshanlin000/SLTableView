package com.shanlin.sltableview.fragment;

import android.view.ViewGroup;

import com.shanlin.library.sltableview.SLIndexPath;
import com.shanlin.library.sltableview.SLTableView;
import com.shanlin.library.sltableview.SLTableViewCell;
import com.shanlin.library.sltableview.SLTableViewDataSource;
import com.shanlin.library.sltableview.SLTableViewDataSourcePlus;
import com.shanlin.library.sltableview.SLTableViewSpanSizeLookup;
import com.shanlin.sltableview.R;
import com.shanlin.sltableview.fragment.base.BaseFragment;

/**
 * 斗鱼demo
 */
public class DouyuFragment extends BaseFragment  implements SLTableViewDataSource,SLTableViewDataSourcePlus,SLTableViewSpanSizeLookup {



    @Override
    public int layoutId() {
        return R.layout.fragment_douyu;
    }


    @Override
    public void initView(ViewGroup view) {

    }

    @Override
    public void initData() {

    }

    //SLTableViewDataSource
    @Override
    public int numberOfSections(SLTableView tableView) {
        return 0;
    }

    @Override
    public int numberOfRowsInSection(SLTableView tableView, int section) {
        return 0;
    }

    @Override
    public int typeOfIndexPath(SLTableView tableView, SLIndexPath indexPath) {
        return 0;
    }

    @Override
    public SLTableViewCell cellForType(SLTableView tableView, ViewGroup parent, int type) {
        return null;
    }

    @Override
    public void onBindCell(SLTableView tableView, SLTableViewCell cell, SLIndexPath indexPath, int type) {

    }
    //SLTableViewDataSourcePlus
    @Override
    public String titleForHeaderInSection(SLTableView tableView, int section) {
        return null;
    }

    @Override
    public String titleForFooterInSection(SLTableView tableView, int section) {
        return null;
    }

    @Override
    public boolean hiddenHeaderInSection(SLTableView tableView, int section) {
        return false;
    }

    @Override
    public boolean hiddenFooterInSection(SLTableView tableView, int section) {
        return false;
    }

    //SLTableViewSpanSizeLookup
    @Override
    public int spanSizeOfIndexPath(SLIndexPath indexPath) {
        return 0;
    }
}
