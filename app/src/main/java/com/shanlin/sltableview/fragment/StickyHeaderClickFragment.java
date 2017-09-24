package com.shanlin.sltableview.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shanlin.library.sltableview.SLTableView;
import com.shanlin.sltableview.R;
import com.shanlin.sltableview.fragment.base.DemoBaseFragment;

import java.util.Arrays;


public class StickyHeaderClickFragment extends DemoBaseFragment {


    public StickyHeaderClickFragment(){

    }
    // TODO: Rename and change types and number of parameters
    public static DefaultFragment newInstance( ) {
        DefaultFragment fragment = new DefaultFragment();
        return fragment;
    }
    private View headerRoot;
    private LinearLayout ll_header ;
    private TextView tv_header ;
    private LinearLayout ll_header2 ;
    private TextView tv_header2 ;

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
        headerRoot = inflater.inflate(R.layout.view_sticky_header_click,null,false);
        ll_header = headerRoot.findViewById(R.id.ll_header);
        tv_header = headerRoot.findViewById(R.id.tv_header);
        tv_header.setText("clickme");
        ll_header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"header clicked",Toast.LENGTH_SHORT).show();
            }
        });
        ll_header2 = headerRoot.findViewById(R.id.ll_header2);
        tv_header2 = headerRoot.findViewById(R.id.tv_header2);
        tv_header2.setText("clickme2");
        ll_header2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"header 2 clicked",Toast.LENGTH_SHORT).show();
            }
        });
        tableView = new SLTableView.Builder(context)
                .setTableViewDataSource(this)
                .setTableViewDelegate(this)
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
        dataLists.add(Arrays.asList("类型1","类型1","类型1","类型1"));
        dataLists.add(Arrays.asList("类型1","类型1","类型1","类型1"));
        dataLists.add(Arrays.asList("类型1","类型1","类型1","类型1"));
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
    public String titleForHeaderInSection(SLTableView tableView, int section) {
        return null;
    }

    @Override
    public View viewForHeaderInSection(SLTableView tableView, int section) {
        if (section == 0 ) {
            return headerRoot;
        }
        return super.viewForHeaderInSection(tableView, section);
    }

    @Override
    public boolean hiddenHeaderInSection(SLTableView tableView, int section) {
        if (section ==0) {
            return false;
        }
        return true;
    }

    @Override
    public void onBindHeaderInSection(SLTableView tableView, View view, int section) {
        super.onBindHeaderInSection(tableView, view, section);
        if (section == 0 ) {
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
