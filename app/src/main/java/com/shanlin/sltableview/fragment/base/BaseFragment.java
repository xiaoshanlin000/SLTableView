package com.shanlin.sltableview.fragment.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.shanlin.library.sltableview.SLTableView;
import com.shanlin.sltableview.R;

/**
 * Created by Shanlin on 2016/12/29.
 */

public abstract class BaseFragment extends Fragment   {

    protected Activity context;

    protected LayoutInflater inflater ;
    protected View rootView;
    protected LinearLayout tableRootLayout;
    protected SLTableView tableView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        inflater = LayoutInflater.from(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return createView(layoutId(),inflater,container,savedInstanceState);
    }

    protected View createView(@LayoutRes int layoutId, LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        if (rootView == null){
            rootView = inflater.inflate(layoutId,container,false);
            tableRootLayout = (LinearLayout) rootView.findViewById(R.id.tableRootLayout);
            initView(tableRootLayout);
            initData();
        }
        return rootView;
    }

    public abstract @LayoutRes int layoutId();
    public abstract void initView(ViewGroup view);
    public abstract void initData();


}
