package com.shanlin.sltableview.fragment;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.view.ViewGroup;

import com.shanlin.library.sltableview.SLIndexPath;
import com.shanlin.library.sltableview.SLTableView;
import com.shanlin.sltableview.R;
import com.shanlin.sltableview.fragment.base.DouyuBaseFragment;
import com.shanlin.sltableview.fragment.bean.DouyuBaseBean;
import com.shanlin.sltableview.fragment.bean.DouyuRoomBean;

import java.util.ArrayList;

/**
 * 斗鱼关注
 * Created by Shanlin on 2017/1/1.
 */

public class DouyuFollowFragment extends DouyuBaseFragment {

    @Override
    public int layoutId() {
        return R.layout.fragment_douyu;
    }

    @Override
    public void initView(ViewGroup view) {
        tableView = new SLTableView.Builder(context)
                .setTableViewDataSource(this)
                .setTableViewDataSourcePlus(this)
                .setTableViewLayoutManagerExpand(this)
                .showStickyHeader(false)
                .setBgColor(context.getResources().getColor(R.color.color_white))
                .setLayoutManager(new GridLayoutManager(context,2))
                .build();
        view.addView(tableView);
    }
    @Override
    public void initData() {
        dataLists.clear();
        ArrayList<DouyuBaseBean> list = new ArrayList<>();
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("凉风有兴","斗鱼第一亚索","8万"));
        list.add(new DouyuRoomBean("凉风有兴","斗鱼第一亚索","8万"));
        list.add(new DouyuRoomBean("凉风有兴","斗鱼第一亚索","8万"));
        list.add(new DouyuRoomBean("凉风有兴","斗鱼第一亚索","8万"));
        list.add(new DouyuRoomBean("文艺冉","七煌|文艺冉 M勇气试炼","2113"));
        list.add(new DouyuRoomBean("文艺冉","七煌|文艺冉 M勇气试炼","2113"));
        list.add(new DouyuRoomBean("文艺冉","七煌|文艺冉 M勇气试炼","2113"));
        list.add(new DouyuRoomBean("文艺冉","七煌|文艺冉 M勇气试炼","2113"));
        list.add(new DouyuRoomBean("战术大师rubick","[战术大师] CDEC大师","4550"));
        list.add(new DouyuRoomBean("战术大师rubick","[战术大师] CDEC大师","4550"));
        list.add(new DouyuRoomBean("战术大师rubick","[战术大师] CDEC大师","4550"));
        list.add(new DouyuRoomBean("战术大师rubick","[战术大师] CDEC大师","4550"));
        dataLists.add(list);
        tableView.getAdapter().notifyDataSetChanged();
    }


    //SLTableViewLayoutManagerExpand
    @Override
    public int gridSpanSizeOfIndexPath(SLIndexPath indexPath) {

        return 1;
    }

    @Override
    public void getItemOffsets(Rect outRect, SLIndexPath indexPath) {
        int section = indexPath.getSection();
        int row = indexPath.getRow();

        if (row % 2 == 0){
            outRect.left = table_padding;
            outRect.right = table_padding_s2;
            outRect.top = row == 0 ? table_padding : table_padding_s2;
            outRect.bottom = table_padding_s2;

        }else if(row % 2 == 1){
            outRect.right = table_padding;
            outRect.left = table_padding_s2;
            outRect.top = row == 1 ? table_padding : table_padding_s2;
            outRect.bottom = table_padding_s2;
        }
    }
}
