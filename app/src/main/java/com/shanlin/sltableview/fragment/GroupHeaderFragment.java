package com.shanlin.sltableview.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.ViewGroup;

import com.shanlin.library.sltableview.SLIndexPath;
import com.shanlin.library.sltableview.SLTableView;
import com.shanlin.library.sltableview.SLTableViewLayoutManagerExpand;
import com.shanlin.sltableview.R;
import com.shanlin.sltableview.fragment.base.DemoBaseFragment;

import java.util.Arrays;


public class GroupHeaderFragment extends DemoBaseFragment implements SLTableViewLayoutManagerExpand {


    public GroupHeaderFragment(){

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
        return R.layout.fragment_default;
    }

    @Override
    public void initView(ViewGroup view) {
        tableView = new SLTableView.Builder(context)
                .setTableViewDataSource(this)
                .setTableViewDataSourcePlus(this)
                .setSpanSizeLookup(this)
                .showStickyHeader(false)
                .setHeaderBgColor(context.getResources().getColor(R.color.color_red))
                .setHeaderTextColor(context.getResources().getColor(R.color.color_white))
                .setLayoutManager(new GridLayoutManager(context,2))
                .build();
        view.addView(tableView);
    }
    @Override
    public void initData() {
        dataLists.clear();
        dataLists.add(Arrays.asList("类型1","类型1","类型1","类型1","类型1"));
        dataLists.add(Arrays.asList("类型2","类型2","类型2","类型2","类型2"));
        dataLists.add(Arrays.asList("类型1","类型1","类型1","类型1","类型1"));
        dataLists.add(Arrays.asList("类型2","类型2","类型2","类型2","类型2"));
        dataLists.add(Arrays.asList("类型:按钮"));
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

    @Override
    public int gridSpanSizeOfIndexPath(SLIndexPath indexPath) {
        int row = indexPath.getRow();
        int section = indexPath.getSection();
        if (section == dataLists.size() - 1 && row == 0){ // 按钮夸两行
            return 2;
        }
        if (row == 2){
            return 2;
        }
        return 0;
    }

    @Override
    public void getItemOffsets(Rect outRect, SLIndexPath indexPath) {

    }
}
