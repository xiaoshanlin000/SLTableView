package com.shanlin.sltableview.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePopupWindow;
import com.shanlin.library.sltableview.SLIndexPath;
import com.shanlin.library.sltableview.SLTableView;
import com.shanlin.library.sltableview.ValueFilter;
import com.shanlin.sltableview.R;
import com.shanlin.sltableview.fragment.base.CellBaseFragment;
import com.shanlin.sltableview.fragment.bean.ButtonBean;
import com.shanlin.sltableview.fragment.bean.CellBaseBean;
import com.shanlin.sltableview.fragment.bean.CheckBoxBean;
import com.shanlin.sltableview.fragment.bean.DateSelectorBean;
import com.shanlin.sltableview.fragment.bean.EditTextBean;
import com.shanlin.sltableview.fragment.bean.EditTextUnitBean;
import com.shanlin.sltableview.fragment.bean.GenderSelectorBean;
import com.shanlin.sltableview.fragment.bean.LineBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Shanlin on 2017/3/15.
 */

public class UserInfoFragment extends CellBaseFragment implements TimePopupWindow.OnTimeSelectListener {


    private static final int NICK_NAME_LENGTH = 3;

    @Override
    public void initView(ViewGroup view) {
        tableView = new SLTableView.Builder(context)
                .setTableViewDataSource(this)
                .setTableViewDelegate(this)
                .setTableViewLayoutManagerExpand(this)
                .showStickyHeader(false)
                .setBgColor(context.getResources().getColor(R.color.color_background))
                .setLayoutManager(new GridLayoutManager(context,1))
                .build();
        view.addView(tableView);
    }

    @Override
    public void initData() {
        dataLists.clear();
        ArrayList<CellBaseBean> arrayList = new ArrayList<>();
        arrayList.add(new EditTextBean().setIcon(R.drawable.img_person_black)
                .setHint("请输入昵称").setKey("nickname").setRequiredValue(true)
                .setValueFilter(new ValueFilter() {
                    @Override
                    public boolean valueFilter(Object value) {
                        if (null != value && value instanceof String){
                            return ((String)value).length() >= NICK_NAME_LENGTH;
                        }
                        return false;
                    }
                }));
        arrayList.add(new LineBean());
        arrayList.add(new DateSelectorBean().setIcon(R.drawable.img_person_black)
                .setContent("生日").setKey("birthday").setRequiredValue(true));
        arrayList.add(new LineBean());
        arrayList.add(new GenderSelectorBean().setIcon(R.drawable.img_person_black)
                .setFemaleStr("女").setMaleStr("男")
                .setGender("1").setKey("gender").setRequiredValue(true));
        dataLists.add(arrayList);

        arrayList = new ArrayList<>();
        arrayList.add(new EditTextUnitBean().setIcon(R.drawable.img_person_black)
                .setHint("请输入身高").setUnit("cm")
                .setInputType(EditorInfo.TYPE_CLASS_NUMBER).setKey("height").setRequiredValue(true));
        arrayList.add(new LineBean());
        arrayList.add(new EditTextUnitBean().setIcon(R.drawable.img_person_black)
                .setHint("请输入体重").setUnit("kg")
                .setInputType(EditorInfo.TYPE_CLASS_NUMBER).setKey("weight").setRequiredValue(true));
        dataLists.add(arrayList);

        arrayList = new ArrayList<>();
        arrayList.add(new CheckBoxBean().setIcon(R.drawable.img_person_black)
                .setContent("喜欢唱歌").setKey("sing"));
        arrayList.add(new LineBean());
        arrayList.add(new CheckBoxBean().setIcon(R.drawable.img_person_black)
                .setContent("喜欢跳舞").setKey("dance"));
        dataLists.add(arrayList);

        arrayList = new ArrayList<>();
        arrayList.add(new ButtonBean().setText("保存"));
        dataLists.add(arrayList);

        tableView.notifyDataSetChanged();
    }


    @Override
    public boolean hiddenHeaderInSection(SLTableView tableView, int section) {
        if (section == dataLists.size() - 1){
            return true;
        }
        return false;
    }

    @Override
    public View viewForHeaderInSection(SLTableView tableView, int section) {
        View view = new View(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(context.getResources().getDisplayMetrics().widthPixels,
                context.getResources().getDimensionPixelSize(R.dimen.cell_padding_x2)));
        return view;
    }

    @Override
    public void onCellViewClick(View view, SLIndexPath indexPath, Object userData) {
        int section = indexPath.getSection();
        int row = indexPath.getRow();
        CellBaseBean bean = dataLists.get(section).get(row);
        switch (bean.getType()){
            case CELL_TYPE_BUTTON:
            {
                HashMap<String,Object> values = new HashMap<>();
                if (tableView.keyValues(values)) {//获取每个cell 的key value
                    Toast.makeText(context,values.toString(),Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case CELL_TYPE_DATE_SELECTOR:
            {
                showDataPicker();
                break;
            }
        }
    }

    @Override
    public void onCellValueError(SLTableView tableView, SLIndexPath indexPath, Object value) {
        int section = indexPath.getSection();
        int row = indexPath.getRow();
        if (section == 0 && row == 0){ //nickname 长度大于3
            Toast.makeText(context,"昵称长度大于"+NICK_NAME_LENGTH,Toast.LENGTH_SHORT).show();
        }
    }

    public void showDataPicker() {
        Calendar d = Calendar.getInstance(Locale.CHINA);
        //创建一个日历引用d，通过静态方法getInstance() 从指定时区 Locale.CHINA 获得一个日期实例
        Date myDate = new Date();
        //创建一个Date实例
        d.setTime(myDate);
        //设置日历的时间，把一个新建Date实例myDate传入
        int year = d.get(Calendar.YEAR);
        TimePopupWindow timePopupWindow = new TimePopupWindow(context, TimePopupWindow.Type.YEAR_MONTH_DAY);
        timePopupWindow.setTime(new Date(System.currentTimeMillis()));
        timePopupWindow.setCyclic(true);
        timePopupWindow.setOnTimeSelectListener(this);
        timePopupWindow.setRange(1900, year);
        timePopupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);
    }

    @Override
    public void onTimeSelect(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String selectDay = dateFormat.format(date);
        DateSelectorBean bean = (DateSelectorBean) dataLists.get(0).get(2);
        bean.setDate(selectDay);
        tableView.notifyDataSetChanged();
    }
}
