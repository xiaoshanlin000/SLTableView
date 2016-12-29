package com.shanlin.sltableview.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shanlin.library.sltableview.SLTableView;
import com.shanlin.sltableview.R;

import java.util.Arrays;

public class DefaultFragment extends BaseFragment {

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
            tableView.notifyDataSetChanged();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return createView(R.layout.fragment_default,inflater,container,savedInstanceState);
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
