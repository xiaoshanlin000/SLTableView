package com.shanlin.sltableview.fragment.base;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import static com.shanlin.sltableview.fragment.bean.DouyuType.TYPE_HOT_AUTHOR;

/**
 *
 * 根据数据显示UI.
 * Created by Shanlin on 2017/1/1.
 */

public abstract  class DouyuAbstractFragment extends BaseFragment  implements SLTableViewDataSource,
        SLTableViewDataSourcePlus,
        SLTableViewLayoutManagerExpand,
        SLTableViewCell.SLCellViewClickListener
{

    protected   int table_padding ;
    protected   int table_padding_s2 ;


    protected ArrayList<ArrayList<DouyuBaseBean>> dataLists = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        table_padding = context.getResources().getDimensionPixelSize(R.dimen.cell_padding);
        table_padding_s2 = context.getResources().getDimensionPixelSize(R.dimen.cell_padding_s2);
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
        DouyuBaseBean baseBean =  dataLists.get(section).get(row);
        return baseBean.getType().getCellType();
    }

    @Override
    public SLTableViewCell cellForType(SLTableView tableView, ViewGroup parent, int type) {
        SLTableViewCell cell = null;
        View rootView;
        DouyuType douyuType = DouyuType.typeOfCellType(type);
        switch (douyuType){
            case TYPE_HEAD:
                rootView = inflater.inflate(R.layout.cell_douyu_head,parent,false);
                cell = new DouyuHeadCell(rootView);
                break;
            case TYPE_ROOM:
                rootView = inflater.inflate(R.layout.cell_douyu_room,parent,false);
                cell = new DouyuRoomCell(rootView);
                break;
            case TYPE_HOT_AUTHOR:
                rootView = inflater.inflate(R.layout.cell_douyu_hot_author,parent,false);
                cell = new DouyuHotAuthorCell(rootView);
                break;
            case TYPE_ROOM_YANZHI:
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
        DouyuBaseBean baseBean =  dataLists.get(section).get(row); 
        switch (baseBean.getType()){
            case TYPE_HEAD: {
                DouyuHeadCell douyuHeadCell = (DouyuHeadCell) cell;
                DouyuHeadBean douyuHead = (DouyuHeadBean) baseBean;
                douyuHeadCell.cell_head_title_text.setText(douyuHead.getTitle());
                if (douyuHead.getType() == TYPE_HOT_AUTHOR) {//热门作者 没有更多选项
                    douyuHeadCell.cell_head_more_layout.setVisibility(View.GONE);
                } else {
                    douyuHeadCell.cell_head_more_layout.setVisibility(View.VISIBLE);
                    douyuHeadCell.bindCellViewClick(douyuHeadCell.cell_head_more_layout, this);
                }
                break;
            }
            case TYPE_ROOM: {
                DouyuRoomCell roomCell = (DouyuRoomCell) cell;
                DouyuRoomBean roomBean = (DouyuRoomBean) baseBean;
                roomCell.room_number_text.setText(roomBean.getRoomNumber());
                roomCell.room_owner_text.setText(roomBean.getRoomOwner());
                roomCell.room_title_text.setText(roomBean.getRoomTitle());
                roomCell.bindCellViewClick(roomCell.room_layout, this);
                break;
            }
            case TYPE_HOT_AUTHOR: {
                DouyuHotAuthorCell authorCell = (DouyuHotAuthorCell) cell;
                DouyuHotAuthorBean authorBean = (DouyuHotAuthorBean) baseBean;
                authorCell.hot_author_name_text.setText(authorBean.getAuthorName());
                authorCell.hot_author_subscribe_number_text.setText(String.format("订阅数:%s", authorBean.getSubscribeNumber()));
                authorCell.hot_author_video_number_text.setText(String.format("视屏数:%s", authorBean.getVideoNumber()));
                authorCell.bindCellViewClick(authorCell.room_layout, this);
                break;
            }
            case TYPE_ROOM_YANZHI: {
                DouyuYanzhiCell yanzhiCell = (DouyuYanzhiCell) cell;
                DouyuYanzhiBean yanzhiBean = (DouyuYanzhiBean) baseBean;
                yanzhiCell.bindCellViewClick(yanzhiCell.room_layout, this);
                yanzhiCell.room_owner_text.setText(yanzhiBean.getRoomOwner());
                yanzhiCell.room_number_text.setText(yanzhiBean.getRoomNumber());
                yanzhiCell.room_location.setText(yanzhiBean.getLocation());
                break;
            }

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

    @Override
    public void getItemOffsets(Rect outRect, SLIndexPath indexPath) {

    }

    @Override
    public View viewForHeaderInSection(SLTableView tableView, int section) {
        return null;
    }

    @Override
    public View viewForFooterInSection(SLTableView tableView, int section) {
        return null;
    }

    @Override
    public void onBindHeaderInSection(SLTableView tableView, View view, int section) {

    }

    @Override
    public void onBindFooterInSection(SLTableView tableView, View view, int section) {

    }

    @Override
    public int gridSpanSizeOfIndexPath(SLIndexPath indexPath) {
        int section = indexPath.getSection();
        int row = indexPath.getRow();
        DouyuBaseBean baseBean =  dataLists.get(section).get(row);
        return baseBean.getSpanSize();
    }

    //SLCellViewClickListener
    @Override
    public void onCellViewClick(View view, SLIndexPath indexPath, Object userData) {
        int section = indexPath.getSection();
        int row = indexPath.getRow();
        String message = "";
        DouyuBaseBean baseBean = dataLists.get(section).get(row);
        switch (baseBean.getType()){
            case TYPE_HEAD:
                DouyuHeadBean douyuHead = (DouyuHeadBean) baseBean;
                message = String.format("点击<%s>更多,类型:<%s>",douyuHead.getTitle(),baseBean.getType());
                break;
            case TYPE_ROOM:
                DouyuRoomBean roomBean = (DouyuRoomBean) baseBean;
                message = String.format("点击<%s>的房间,类型:<%s>",roomBean.getRoomOwner(),baseBean.getType());
                break;
            case TYPE_HOT_AUTHOR:
                DouyuHotAuthorBean authorBean = (DouyuHotAuthorBean)baseBean;
                message = String.format("点击<%s>的房间,类型:<%s>",authorBean.getAuthorName(),baseBean.getType());
                break;
            case TYPE_ROOM_YANZHI:
                DouyuYanzhiBean yanzhiBean = (DouyuYanzhiBean)baseBean;
                message = String.format("点击<%s>的房间,类型:<%s>",yanzhiBean.getRoomOwner(),baseBean.getType());
                break;

        }
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
