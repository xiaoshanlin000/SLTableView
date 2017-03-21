package com.shanlin.sltableview.fragment.base;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shanlin.library.sltableview.SLIndexPath;
import com.shanlin.library.sltableview.SLTableView;
import com.shanlin.library.sltableview.SLTableViewCell;
import com.shanlin.library.sltableview.SLTableViewDataSource;
import com.shanlin.library.sltableview.SLTableViewDelegate;
import com.shanlin.library.sltableview.SLTableViewLayoutManagerExpand;
import com.shanlin.sltableview.R;
import com.shanlin.sltableview.fragment.bean.ButtonBean;
import com.shanlin.sltableview.fragment.bean.CellBaseBean;
import com.shanlin.sltableview.fragment.bean.CellType;
import com.shanlin.sltableview.fragment.bean.CheckBoxBean;
import com.shanlin.sltableview.fragment.bean.DateSelectorBean;
import com.shanlin.sltableview.fragment.bean.DouyuHeadBean;
import com.shanlin.sltableview.fragment.bean.DouyuHotAuthorBean;
import com.shanlin.sltableview.fragment.bean.DouyuRoomBean;
import com.shanlin.sltableview.fragment.bean.DouyuYanzhiBean;
import com.shanlin.sltableview.fragment.bean.EditTextBean;
import com.shanlin.sltableview.fragment.bean.EditTextUnitBean;
import com.shanlin.sltableview.fragment.bean.GenderSelectorBean;
import com.shanlin.sltableview.fragment.bean.TextBean;
import com.shanlin.sltableview.fragment.cell.ButtonCell;
import com.shanlin.sltableview.fragment.cell.CheckBoxCell;
import com.shanlin.sltableview.fragment.cell.DateSelectorCell;
import com.shanlin.sltableview.fragment.cell.DouyuHeadCell;
import com.shanlin.sltableview.fragment.cell.DouyuHotAuthorCell;
import com.shanlin.sltableview.fragment.cell.DouyuRoomCell;
import com.shanlin.sltableview.fragment.cell.DouyuYanzhiCell;
import com.shanlin.sltableview.fragment.cell.EditTextCell;
import com.shanlin.sltableview.fragment.cell.EditTextUnitCell;
import com.shanlin.sltableview.fragment.cell.GenderSelectorCell;
import com.shanlin.sltableview.fragment.cell.LineCell;
import com.shanlin.sltableview.fragment.cell.TextCell;

import java.util.ArrayList;

import static com.shanlin.sltableview.fragment.bean.CellType.CELL_TYPE_DOUYU_HOT_AUTHOR;

/**
 *
 * 根据数据显示UI.
 * Created by Shanlin on 2017/1/1.
 */

public abstract  class CellAbstractFragment extends BaseFragment  implements SLTableViewDataSource,
        SLTableViewDelegate,
        SLTableViewLayoutManagerExpand,
        SLTableViewCell.SLCellViewClickListener
{

    protected   int table_padding ;
    protected   int table_padding_s2 ;


    protected ArrayList<ArrayList<CellBaseBean>> dataLists = new ArrayList<>();

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
        CellBaseBean baseBean =  dataLists.get(section).get(row);
        return baseBean.getType().getCellType();
    }

    @Override
    public SLTableViewCell cellForType(SLTableView tableView, ViewGroup parent, int type) {
        SLTableViewCell cell = null;
        View rootView;
        CellType cellType = CellType.typeOfCellType(type);
        switch (cellType){
            case CELL_TYPE_DOUYU_HEAD:
                rootView = inflater.inflate(R.layout.cell_douyu_head,parent,false);
                cell = new DouyuHeadCell(rootView);
                break;
            case CELL_TYPE_DOUYU_ROOM:
                rootView = inflater.inflate(R.layout.cell_douyu_room,parent,false);
                cell = new DouyuRoomCell(rootView);
                break;
            case CELL_TYPE_DOUYU_HOT_AUTHOR:
                rootView = inflater.inflate(R.layout.cell_douyu_hot_author,parent,false);
                cell = new DouyuHotAuthorCell(rootView);
                break;
            case CELL_TYPE_DOUYU_ROOM_YANZHI:
                rootView = inflater.inflate(R.layout.cell_douyu_yanzhi,parent,false);
                cell = new DouyuYanzhiCell(rootView);
                break;
            case CELL_TYPE_CHECK_BOX:
                rootView = inflater.inflate(R.layout.cell_check_box,parent,false);
                cell = new CheckBoxCell(rootView);
                break;
            case CELL_TYPE_DATE_SELECTOR:
                rootView = inflater.inflate(R.layout.cell_date_selector,parent,false);
                cell = new DateSelectorCell(rootView);
                break;
            case CELL_TYPE_EDIT_TEXT:
                rootView = inflater.inflate(R.layout.cell_edit_text,parent,false);
                cell = new EditTextCell(rootView);
                break;
            case CELL_TYPE_EDIT_TEXT_UNIT:
                rootView = inflater.inflate(R.layout.cell_edit_text_unit,parent,false);
                cell = new EditTextUnitCell(rootView);
                break;
            case CELL_TYPE_GENDER_SELECTOR:
                rootView = inflater.inflate(R.layout.cell_gender_selector,parent,false);
                cell = new GenderSelectorCell(rootView);
                break;
            case CELL_TYPE_TEXT:
                rootView = inflater.inflate(R.layout.cell_text,parent,false);
                cell = new TextCell(rootView);
                break;
            case CELL_TYPE_BUTTON:
                rootView = inflater.inflate(R.layout.cell_button,parent,false);
                cell = new ButtonCell(rootView);
                break;
            case CELL_TYPE_LINE:
                rootView = inflater.inflate(R.layout.cell_line,parent,false);
                cell = new LineCell(rootView);

        }
        return cell;
    }

    @Override
    public void onBindCell(SLTableView tableView, SLTableViewCell cell, SLIndexPath indexPath, int type) {
        int section = indexPath.getSection();
        int row = indexPath.getRow();
        CellBaseBean baseBean =  dataLists.get(section).get(row);
        cell.setKey(baseBean.getKey());// 设置当前cell需要获取数据的key
        cell.setRequiredValue(baseBean.isRequiredValue());// 设置cell值是否是必须的
        cell.setValueFilter(baseBean.getValueFilter());
        switch (baseBean.getType()){
            case CELL_TYPE_DOUYU_HEAD: {
                DouyuHeadCell douyuHeadCell = (DouyuHeadCell) cell;
                DouyuHeadBean douyuHead = (DouyuHeadBean) baseBean;
                douyuHeadCell.cell_head_title_text.setText(douyuHead.getTitle());
                if (douyuHead.getType() == CELL_TYPE_DOUYU_HOT_AUTHOR) {//热门作者 没有更多选项
                    douyuHeadCell.cell_head_more_layout.setVisibility(View.GONE);
                } else {
                    douyuHeadCell.cell_head_more_layout.setVisibility(View.VISIBLE);
                    douyuHeadCell.bindCellViewClick(douyuHeadCell.cell_head_more_layout, this);
                }
                break;
            }
            case CELL_TYPE_DOUYU_ROOM: {
                DouyuRoomCell roomCell = (DouyuRoomCell) cell;
                DouyuRoomBean roomBean = (DouyuRoomBean) baseBean;
                roomCell.room_number_text.setText(roomBean.getRoomNumber());
                roomCell.room_owner_text.setText(roomBean.getRoomOwner());
                roomCell.room_title_text.setText(roomBean.getRoomTitle());
                roomCell.bindCellViewClick(roomCell.room_layout, this);
                break;
            }
            case CELL_TYPE_DOUYU_HOT_AUTHOR: {
                DouyuHotAuthorCell authorCell = (DouyuHotAuthorCell) cell;
                DouyuHotAuthorBean authorBean = (DouyuHotAuthorBean) baseBean;
                authorCell.hot_author_name_text.setText(authorBean.getAuthorName());
                authorCell.hot_author_subscribe_number_text.setText(String.format("订阅数:%s", authorBean.getSubscribeNumber()));
                authorCell.hot_author_video_number_text.setText(String.format("视屏数:%s", authorBean.getVideoNumber()));
                authorCell.bindCellViewClick(authorCell.room_layout, this);
                break;
            }
            case CELL_TYPE_DOUYU_ROOM_YANZHI: {
                DouyuYanzhiCell yanzhiCell = (DouyuYanzhiCell) cell;
                DouyuYanzhiBean yanzhiBean = (DouyuYanzhiBean) baseBean;
                yanzhiCell.bindCellViewClick(yanzhiCell.room_layout, this);
                yanzhiCell.room_owner_text.setText(yanzhiBean.getRoomOwner());
                yanzhiCell.room_number_text.setText(yanzhiBean.getRoomNumber());
                yanzhiCell.room_location.setText(yanzhiBean.getLocation());
                break;
            }
            case CELL_TYPE_CHECK_BOX:
            {
                CheckBoxCell checkBoxCell = (CheckBoxCell) cell;
                CheckBoxBean checkBoxBean = (CheckBoxBean) baseBean;
                checkBoxCell.iv_icon.setBackgroundDrawable(context.getResources()
                        .getDrawable(checkBoxBean.getIcon()));
                checkBoxCell.cb_check.setSelected(!TextUtils.isEmpty(checkBoxBean.getSelect()) ||
                        !"0".equals(checkBoxBean.getSelect()));
                checkBoxCell.tv_content.setText(checkBoxBean.getContent());
                break;
            }
            case CELL_TYPE_DATE_SELECTOR:
            {
                DateSelectorCell dateSelectorCell = (DateSelectorCell) cell;
                DateSelectorBean dateSelectorBean = (DateSelectorBean) baseBean;
                dateSelectorCell.iv_icon.setBackgroundDrawable(context.getResources()
                        .getDrawable(dateSelectorBean.getIcon()));
                dateSelectorCell.tv_content.setText(dateSelectorBean.getContent());
                dateSelectorCell.tv_date.setText(dateSelectorBean.getDate());
                dateSelectorCell.bindCellViewClick(dateSelectorCell.ll_cell_root,this);
                break;
            }
            case CELL_TYPE_EDIT_TEXT:
            {
                EditTextCell editTextCell = (EditTextCell) cell;
                final  EditTextBean editTextBean = (EditTextBean) baseBean;
                editTextCell.iv_icon.setBackgroundDrawable(context.getResources()
                        .getDrawable(editTextBean.getIcon()));
                editTextCell.et_content.setText(editTextBean.getContent());
                editTextCell.et_content.setHint(editTextBean.getHint());
                editTextCell.et_content.setInputType(editTextBean.getInputType());
                Selection.setSelection(editTextCell.et_content.getText(),
                        getLength(editTextBean.getContent()));
                editTextCell.et_content.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        editTextBean.setContent(s.toString());
                    }
                });
                break;
            }
            case CELL_TYPE_EDIT_TEXT_UNIT:
            {
                EditTextUnitCell editTextUnitCell = (EditTextUnitCell) cell;
                final EditTextUnitBean editTextUnitBean = (EditTextUnitBean) baseBean;
                editTextUnitCell.iv_icon.setBackgroundDrawable(context.getResources()
                        .getDrawable(editTextUnitBean.getIcon()));
                editTextUnitCell.et_content.setText(editTextUnitBean.getContent());
                editTextUnitCell.et_content.setHint(editTextUnitBean.getHint());
                editTextUnitCell.tv_unit.setText(editTextUnitBean.getUnit());
                editTextUnitCell.et_content.setInputType(editTextUnitBean.getInputType());
                Selection.setSelection(editTextUnitCell.et_content.getText(),
                        getLength(editTextUnitBean.getContent()));
                editTextUnitCell.et_content.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        editTextUnitBean.setContent(s.toString());
                    }
                });
                break;
            }
            case CELL_TYPE_GENDER_SELECTOR:
            {
                GenderSelectorCell genderSelectorCell = (GenderSelectorCell) cell;
                GenderSelectorBean genderSelectorBean = (GenderSelectorBean) baseBean;
                genderSelectorCell.iv_icon.setBackgroundDrawable(context.getResources()
                        .getDrawable(genderSelectorBean.getIcon()));
                genderSelectorCell.rb_female.setText(genderSelectorBean.getFemaleStr());
                genderSelectorCell.rb_male.setText(genderSelectorBean.getMaleStr());
                boolean female = false;
                if (!TextUtils.isEmpty(genderSelectorBean.getGender()) &&
                        "0".equals(genderSelectorBean.getGender())) {
                    female = true;
                }
                if (female){
                    genderSelectorCell.rb_female.setChecked(true);
                }else{
                    genderSelectorCell.rb_male.setChecked(true);
                }
                break;
            }
            case CELL_TYPE_TEXT:
            {
                TextCell textCell = (TextCell) cell;
                TextBean textBean = (TextBean) baseBean;
                textCell.iv_icon.setBackgroundDrawable(context.getResources()
                        .getDrawable(textBean.getIcon()));
                textCell.tv_content.setText(textBean.getContent());
                textCell.bindCellViewClick(textCell.ll_cell_root,this);
                break;
            }
            case CELL_TYPE_BUTTON:
            {
                ButtonCell buttonCell = (ButtonCell) cell;
                ButtonBean buttonBean = (ButtonBean) baseBean;
                buttonCell.tv_text.setText(buttonBean.getText());
                buttonCell.bindCellViewClick(buttonCell.ll_root,this);
                break;

            }
            case CELL_TYPE_LINE:
            {

            }

        }
    }



    //SLTableViewDelegate
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
        CellBaseBean baseBean =  dataLists.get(section).get(row);
        return baseBean.getSpanSize();
    }

    //SLCellViewClickListener
    @Override
    public void onCellViewClick(View view, SLIndexPath indexPath, Object userData) {
        int section = indexPath.getSection();
        int row = indexPath.getRow();
        String message = "";
        CellBaseBean baseBean = dataLists.get(section).get(row);
        switch (baseBean.getType()){
            case CELL_TYPE_DOUYU_HEAD:
                DouyuHeadBean douyuHead = (DouyuHeadBean) baseBean;
                message = String.format("点击<%s>更多,类型:<%s>",douyuHead.getTitle(),baseBean.getType());
                break;
            case CELL_TYPE_DOUYU_ROOM:
                DouyuRoomBean roomBean = (DouyuRoomBean) baseBean;
                message = String.format("点击<%s>的房间,类型:<%s>",roomBean.getRoomOwner(),baseBean.getType());
                break;
            case CELL_TYPE_DOUYU_HOT_AUTHOR:
                DouyuHotAuthorBean authorBean = (DouyuHotAuthorBean)baseBean;
                message = String.format("点击<%s>的房间,类型:<%s>",authorBean.getAuthorName(),baseBean.getType());
                break;
            case CELL_TYPE_DOUYU_ROOM_YANZHI:
                DouyuYanzhiBean yanzhiBean = (DouyuYanzhiBean)baseBean;
                message = String.format("点击<%s>的房间,类型:<%s>",yanzhiBean.getRoomOwner(),baseBean.getType());
                break;

        }
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCellValueError(SLTableView tableView, SLIndexPath indexPath, Object value) {

    }

    private int getLength(String str){
        return null == str ? 0 : str.length();
    }
}
