package com.shanlin.sltableview.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shanlin.library.sltableview.SLIndexPath;
import com.shanlin.library.sltableview.SLTableView;
import com.shanlin.library.sltableview.SLTableViewCell;
import com.shanlin.library.sltableview.SLTableViewDataSource;
import com.shanlin.library.sltableview.SLTableViewDataSourcePlus;
import com.shanlin.library.sltableview.SLTableViewLayoutManagerExpand;
import com.shanlin.sltableview.R;
import com.shanlin.sltableview.fragment.base.BaseFragment;
import com.shanlin.sltableview.fragment.bean.DouyuBaseBean;
import com.shanlin.sltableview.fragment.bean.DouyuHeadBean;
import com.shanlin.sltableview.fragment.bean.DouyuHotAuthorBean;
import com.shanlin.sltableview.fragment.bean.DouyuRoomBean;
import com.shanlin.sltableview.fragment.bean.DouyuType;
import com.shanlin.sltableview.fragment.bean.DouyuYanzhiBean;
import com.shanlin.sltableview.fragment.cell.DouyuHeadCell;
import com.shanlin.sltableview.fragment.cell.DouyuHotAuthorCell;
import com.shanlin.sltableview.fragment.cell.DouyuRoomCell;
import com.shanlin.sltableview.fragment.cell.DouyuYanzhiCell;

import java.util.ArrayList;

/**
 * 斗鱼demo
 */
public class DouyuFragment extends BaseFragment  implements SLTableViewDataSource,
        SLTableViewDataSourcePlus,SLTableViewLayoutManagerExpand,SLTableViewCell.SLCellViewClickListener
{
    private static final int CELL_TYPE_HEAD = 0;
    private static final int CELL_TYPE_ROOM = 1;
    private static final int CELL_TYPE_HOT_AUTHOR = 2;
    private static final int CELL_TYPE_ROOM_YANZHI = 3;
    private  int table_padding ;
    private  int table_padding_s2 ;


    private ArrayList<ArrayList<Object>> dataLists = new ArrayList<>();


    @Override
    public int layoutId() {
        return R.layout.fragment_douyu;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        table_padding = context.getResources().getDimensionPixelSize(R.dimen.cell_padding);
        table_padding_s2 = context.getResources().getDimensionPixelSize(R.dimen.cell_padding_s2);
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
        ArrayList<Object> list = new ArrayList<>();
        list.add(new DouyuHeadBean("最热"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        dataLists.add(list);
        list = new ArrayList<>();
        list.add(new DouyuHeadBean("颜值"));
        list.add(new DouyuYanzhiBean("Cherry宛夕","4.1万","北京市"));
        list.add(new DouyuYanzhiBean("Cherry宛夕","4.1万","北京市"));
        list.add(new DouyuYanzhiBean("Cherry宛夕","4.1万","北京市"));
        list.add(new DouyuYanzhiBean("Cherry宛夕","4.1万","北京市"));
        dataLists.add(list);
        list = new ArrayList<>();
        list.add(new DouyuHeadBean("英雄联盟"));
        list.add(new DouyuRoomBean("凉风有兴","斗鱼第一亚索","8万"));
        list.add(new DouyuRoomBean("凉风有兴","斗鱼第一亚索","8万"));
        list.add(new DouyuRoomBean("凉风有兴","斗鱼第一亚索","8万"));
        list.add(new DouyuRoomBean("凉风有兴","斗鱼第一亚索","8万"));
        dataLists.add(list);
        list = new ArrayList<>();
        list.add(new DouyuHeadBean("魔兽世界"));
        list.add(new DouyuRoomBean("文艺冉","七煌|文艺冉 M勇气试炼","2113"));
        list.add(new DouyuRoomBean("文艺冉","七煌|文艺冉 M勇气试炼","2113"));
        list.add(new DouyuRoomBean("文艺冉","七煌|文艺冉 M勇气试炼","2113"));
        list.add(new DouyuRoomBean("文艺冉","七煌|文艺冉 M勇气试炼","2113"));
        dataLists.add(list);
        list = new ArrayList<>();
        list.add(new DouyuHeadBean("DOTA2"));
        list.add(new DouyuRoomBean("战术大师rubick","[战术大师] CDEC大师","4550"));
        list.add(new DouyuRoomBean("战术大师rubick","[战术大师] CDEC大师","4550"));
        list.add(new DouyuRoomBean("战术大师rubick","[战术大师] CDEC大师","4550"));
        list.add(new DouyuRoomBean("战术大师rubick","[战术大师] CDEC大师","4550"));
        dataLists.add(list);
        list = new ArrayList<>();
        list.add(new DouyuHeadBean("热门作者"));
        list.add(new DouyuHotAuthorBean("萝菽菽_acfun","72","9237"));
        list.add(new DouyuHotAuthorBean("鱼小碗","30","437"));
        dataLists.add(list);
        tableView.getAdapter().notifyDataSetChanged();
    }

    //SLTableViewDataSource
    @Override
    public int numberOfSections(SLTableView tableView) {
        return dataLists.size();
    }

    @Override
    public int numberOfRowsInSection(SLTableView tableView, int section) {
        return dataLists.get(section).size();
    }

    @Override
    public int typeOfIndexPath(SLTableView tableView, SLIndexPath indexPath) {
        int section = indexPath.getSection();
        int row = indexPath.getRow();
        if (row == 0) return CELL_TYPE_HEAD;
        DouyuBaseBean baseBean = (DouyuBaseBean) dataLists.get(section).get(row); // head
        if (baseBean.getType() == DouyuType.TYPE_ROOM) return CELL_TYPE_ROOM;
        if (baseBean.getType() == DouyuType.TYPE_HOT_AUTHOR) return CELL_TYPE_HOT_AUTHOR;
        if (baseBean.getType() == DouyuType.TYPE_ROOM_YANZHI) return CELL_TYPE_ROOM_YANZHI;
        return 0;
    }

    @Override
    public SLTableViewCell cellForType(SLTableView tableView, ViewGroup parent, int type) {
        SLTableViewCell cell = null;
        View rootView;
        switch (type){
            case CELL_TYPE_HEAD:
                rootView = inflater.inflate(R.layout.cell_douyu_head,parent,false);
                cell = new DouyuHeadCell(rootView);
                break;
            case CELL_TYPE_ROOM:
                rootView = inflater.inflate(R.layout.cell_douyu_room,parent,false);
                cell = new DouyuRoomCell(rootView);
                break;
            case CELL_TYPE_HOT_AUTHOR:
                rootView = inflater.inflate(R.layout.cell_douyu_hot_author,parent,false);
                cell = new DouyuHotAuthorCell(rootView);
                break;
            case CELL_TYPE_ROOM_YANZHI:
                rootView = inflater.inflate(R.layout.cell_douyu_yanzhi,parent,false);
                cell = new DouyuYanzhiCell(rootView);
                break;

        }
        return cell;
    }

    @Override
    public void onBindCell(SLTableView tableView, SLTableViewCell cell, SLIndexPath indexPath, int type) {
        int section = indexPath.getSection();
        int row = indexPath.getRow();
        DouyuBaseBean baseBean = (DouyuBaseBean) dataLists.get(section).get(row); // head
        switch (baseBean.getType()){
            case TYPE_HEAD:
                DouyuHeadCell douyuHeadCell = (DouyuHeadCell) cell;
                DouyuHeadBean douyuHead = (DouyuHeadBean) baseBean;
                douyuHeadCell.cell_head_title_text.setText(douyuHead.getTitle());
                if (douyuHead.getType() == DouyuType.TYPE_HOT_AUTHOR){//热门作者 没有更多选项
                    douyuHeadCell.cell_head_more_layout.setVisibility(View.GONE);
                }else{
                    douyuHeadCell.cell_head_more_layout.setVisibility(View.VISIBLE);
                    douyuHeadCell.bindCellViewClick(douyuHeadCell.cell_head_more_layout,this,type);
                }
                break;
            case TYPE_ROOM:
                DouyuRoomCell roomCell = (DouyuRoomCell) cell;
                DouyuRoomBean roomBean = (DouyuRoomBean) baseBean;
                roomCell.room_number_text.setText(roomBean.getRoomNumber());
                roomCell.room_owner_text.setText(roomBean.getRoomOwner());
                roomCell.room_title_text.setText(roomBean.getRoomTitle());
                roomCell.bindCellViewClick(roomCell.room_layout,this,(Integer)type);
                break;
            case TYPE_HOT_AUTHOR:
                DouyuHotAuthorCell authorCell = (DouyuHotAuthorCell) cell;
                DouyuHotAuthorBean authorBean = (DouyuHotAuthorBean) dataLists.get(section).get(row);
                authorCell.hot_author_name_text.setText(authorBean.getAuthorName());
                authorCell.hot_author_subscribe_number_text.setText(String.format("订阅数:%s",authorBean.getSubscribeNumber()));
                authorCell.hot_author_video_number_text.setText(String.format("视屏数:%s",authorBean.getVideoNumber()));

                authorCell.bindCellViewClick(authorCell.room_layout,this,(Integer)type);
                break;
            case TYPE_ROOM_YANZHI:
                DouyuYanzhiCell yanzhiCell = (DouyuYanzhiCell) cell;
                DouyuYanzhiBean yanzhiBean = (DouyuYanzhiBean) baseBean;
                yanzhiCell.bindCellViewClick(yanzhiCell.room_layout,this,(Integer)type);
                yanzhiCell.room_owner_text.setText(yanzhiBean.getRoomOwner());
                yanzhiCell.room_number_text.setText(yanzhiBean.getRoomNumber());
                yanzhiCell.room_location.setText(yanzhiBean.getLocation());
                break;

        }
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
        return true;
    }

    @Override
    public boolean hiddenFooterInSection(SLTableView tableView, int section) {
        return true;
    }

    //SLTableViewLayoutManagerExpand
    @Override
    public int gridSpanSizeOfIndexPath(SLIndexPath indexPath) {
        int section = indexPath.getSection();
        int row = indexPath.getRow();
        if (row == 0) return  2;
        DouyuBaseBean baseBean = (DouyuBaseBean) dataLists.get(section).get(row); // head
        if (baseBean.getType() == DouyuType.TYPE_HOT_AUTHOR){
            return 2;
        }
        return 1;
    }

    @Override
    public void getItemOffsets(Rect outRect, SLIndexPath indexPath) {
        int section = indexPath.getSection();
        int row = indexPath.getRow();
        DouyuBaseBean baseBean = (DouyuBaseBean) dataLists.get(section).get(row); // head
        if (baseBean.getType() == DouyuType.TYPE_HOT_AUTHOR){
            return;
        }
        if (baseBean.getType() == DouyuType.TYPE_HEAD){
            return;
        }
        if (row >0 && row % 2 == 1){
            outRect.left = table_padding;
            outRect.right = table_padding_s2;
            outRect.top = table_padding_s2;
            outRect.bottom = table_padding_s2;

        }else if(row > 0 && row %2 == 0){
            outRect.right = table_padding;
            outRect.left = table_padding_s2;
            outRect.top = table_padding_s2;
            outRect.bottom = table_padding_s2;
        }
    }

    //SLCellViewClickListener
    @Override
    public void onCellViewClick(View view, SLIndexPath indexPath, Object userData) {
        int section = indexPath.getSection();
        int row = indexPath.getRow();
        Integer type = (Integer) userData;
        String message = "";
        DouyuHeadBean douyuHead = (DouyuHeadBean) dataLists.get(section).get(0);
        switch (type){
            case CELL_TYPE_HEAD:
                message = String.format("点击<%s>更多,类型:<%d>",douyuHead.getTitle(),douyuHead.getType());
                break;
            case CELL_TYPE_ROOM:
                DouyuRoomBean roomBean = (DouyuRoomBean) dataLists.get(section).get(row);
                message = String.format("点击<%s>的房间,类型:<%d>",roomBean.getRoomOwner(),douyuHead.getType());
                break;
            case CELL_TYPE_HOT_AUTHOR:
                DouyuHotAuthorBean authorBean = (DouyuHotAuthorBean) dataLists.get(section).get(row);
                message = String.format("点击<%s>的房间,类型:<%d>",authorBean.getAuthorName(),douyuHead.getType());
                break;
            case CELL_TYPE_ROOM_YANZHI:
                DouyuYanzhiBean yanzhiBean = (DouyuYanzhiBean) dataLists.get(section).get(row);
                message = String.format("点击<%s>的房间,类型:<%d>",yanzhiBean.getRoomOwner(),douyuHead.getType());
                break;

        }
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }


}
