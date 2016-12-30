package com.shanlin.sltableview.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;

import com.shanlin.library.sltableview.SLTableView;
import com.shanlin.sltableview.R;
import com.shanlin.sltableview.fragment.base.DemoBaseFragment;

import java.util.Arrays;

public class DefaultFragment extends DemoBaseFragment {

    public DefaultFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DefaultFragment.
     */
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
        return R.layout.fragment_default;
    }

    @Override
    public void initView(ViewGroup view) {
        tableView = new SLTableView.Builder(context)
                .setTableViewDataSource(this)
                .setTableViewDataSourcePlus(this)
                .showStickyHeader(false)
                .build();
        view.addView(tableView);
    }

    @Override
    public void initData() {
        dataLists.clear();
        dataLists.add(Arrays.asList("类型1","类型1"));
        dataLists.add(Arrays.asList("类型2","类型2"));
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
