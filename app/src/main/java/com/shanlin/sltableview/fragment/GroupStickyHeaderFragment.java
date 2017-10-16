package com.shanlin.sltableview.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shanlin.library.sltableview.SLIndexPath;
import com.shanlin.library.sltableview.SLTableView;
import com.shanlin.sltableview.R;
import com.shanlin.sltableview.fragment.base.DemoBaseFragment;

import java.util.Arrays;


public class GroupStickyHeaderFragment extends DemoBaseFragment {


    public GroupStickyHeaderFragment() {

    }

    // TODO: Rename and change types and number of parameters
    public static DefaultFragment newInstance() {
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
                .setTableViewDelegate(this)
                .showStickyHeader(true)
                .setHeaderBgColor(context.getResources().getColor(R.color.color_red))
                .setHeaderTextColor(context.getResources().getColor(R.color.color_white))
                .setLayoutManager(new GridLayoutManager(context, 2))
                .build();
        view.addView(tableView);
    }

    @Override
    public void initData() {
        dataLists.clear();
        dataLists.add(Arrays.asList("类型1", "类型1", "类型1", "类型1", "类型1", "类型1", "类型1", "类型1", "类型1"));
        dataLists.add(Arrays.asList("类型2", "类型2", "类型2", "类型2", "类型2", "类型2", "类型2", "类型2"));
        dataLists.add(Arrays.asList("类型1", "类型1", "类型1", "类型1", "类型1", "类型1", "类型1", "类型1"));
        dataLists.add(Arrays.asList("类型2", "类型2", "类型2", "类型2", "类型2", "类型2", "类型2", "类型2"));
        dataLists.add(Arrays.asList("类型1", "类型1", "类型1", "类型1", "类型1", "类型1", "类型1", "类型1"));
        dataLists.add(Arrays.asList("类型2", "类型2", "类型2", "类型2", "类型2", "类型2", "类型2", "类型2"));
        dataLists.add(Arrays.asList("类型1", "类型1", "类型1", "类型1", "类型1", "类型1", "类型1", "类型1"));
        dataLists.add(Arrays.asList("类型2", "类型2", "类型2", "类型2", "类型2", "类型2", "类型2", "类型2"));
        if (tableView != null) {
            tableView.getAdapter().notifyDataSetChanged();
        }
    }


    @Override
    public View viewForHeaderInSection(SLTableView tableView, int section) {
        View view = LayoutInflater.from(context).inflate(R.layout.cell_head, null);
        view.setLayoutParams(new ViewGroup.LayoutParams(context.getResources().getDimensionPixelOffset(R.dimen.dimen_80dp), context.getResources().getDimensionPixelOffset(R.dimen.dimen_40dp)));
        return view;
    }

    @Override
    public void onBindHeaderInSection(SLTableView tableView, View view, int section) {
        super.onBindHeaderInSection(tableView, view, section);
        TextView textView = view.findViewById(R.id.tv_text);
        textView.setText("第"+section+"组");
    }

    @Override
    public int typeOfIndexPath(SLTableView tableView, SLIndexPath indexPath) {
        int section = indexPath.getSection();
        return indexPath.getSection() % 2;
    }

    @Override
    public boolean hiddenHeaderInSection(SLTableView tableView, int section) {
        return false;
    }

    @Override
    public boolean hiddenFooterInSection(SLTableView tableView, int section) {
        return false;
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
