package com.shanlin.sltableview.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;

import com.shanlin.library.sltableview.SLTableView;
import com.shanlin.sltableview.R;
import com.shanlin.sltableview.fragment.base.DemoBaseFragment;

import java.util.Arrays;


public class StickyHeaderFragment extends DemoBaseFragment {


    public StickyHeaderFragment(){

    }
    // TODO: Rename and change types and number of parameters
    public static DefaultFragment newInstance( ) {
        DefaultFragment fragment = new DefaultFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int layoutId() {
        return R.layout.fragment_sticky_header;
    }

    @Override
    public void initView(ViewGroup view) {
        tableView = new SLTableView.Builder(context)
                .setTableViewDataSource(this)
                .setTableViewDataSourcePlus(this)
                .showStickyHeader(true)
                .setHeaderBgColor(context.getResources().getColor(R.color.color_red))
                .setHeaderTextColor(context.getResources().getColor(R.color.color_white))
                .build();
        view.addView(tableView);
    }
    @Override
    public void initData() {
        dataLists.clear();
        dataLists.add(Arrays.asList("类型1","类型1","类型1","类型1"));
        dataLists.add(Arrays.asList("类型2","类型2","类型2","类型2"));
        dataLists.add(Arrays.asList("类型1","类型1","类型1","类型1"));
        dataLists.add(Arrays.asList("类型2","类型2","类型2","类型2"));
        dataLists.add(Arrays.asList("按钮"));
        if (tableView != null) {
            tableView.getAdapter().notifyDataSetChanged();
        }
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
