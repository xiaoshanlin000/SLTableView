package com.shanlin.sltableview.fragment.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.shanlin.library.sltableview.SLIndexPath;
import com.shanlin.library.sltableview.SLTableView;
import com.shanlin.library.sltableview.SLTableViewCell;
import com.shanlin.library.sltableview.SLTableViewDataSource;
import com.shanlin.library.sltableview.SLTableViewDelegate;
import com.shanlin.sltableview.R;
import com.shanlin.sltableview.fragment.cell.TypeOneCell;
import com.shanlin.sltableview.fragment.cell.TypeThreeCell;
import com.shanlin.sltableview.fragment.cell.TypeTwoCell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shanlin on 2016/12/30.
 */

public abstract class DemoBaseFragment extends BaseFragment implements SLTableViewDataSource,SLTableViewDelegate,SLTableViewCell.SLCellViewClickListener{


    protected ArrayList<List<String>> dataLists = new ArrayList<>();

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
        if (section < dataLists.size() - 1) {
            return indexPath.getSection() % 2;
        }
        return 2;
    }

    @Override
    public SLTableViewCell cellForType(SLTableView tableView, ViewGroup parent, int type) {
        SLTableViewCell cell = null;
        if (type == 0) {
            View rootView = inflater.inflate(R.layout.type_one_cell, parent, false);
            cell = new TypeOneCell(rootView);
        }else if(type == 1){
            View rootView = inflater.inflate(R.layout.type_two_cell, parent, false);
            cell = new TypeTwoCell(rootView);
        }else if(type == 2){
            View rootView = inflater.inflate(R.layout.type_three_cell, parent, false);
            cell = new TypeThreeCell(rootView);
        }
        return cell;
    }

    @Override
    public void onBindCell(SLTableView tableView, SLTableViewCell cell, SLIndexPath indexPath, int type) {

        final int section = indexPath.getSection();
        final int row = indexPath.getRow();
        if (type == 0){
            TypeOneCell typeCell = (TypeOneCell) cell;
            typeCell.cell_textView.setText(dataLists.get(section).get(row));
            typeCell.bindCellViewClick(typeCell.cell_layout,this);
        }else if (type == 1){
            TypeTwoCell typeCell = (TypeTwoCell) cell;
            typeCell.cell_textView.setText(dataLists.get(section).get(row));
            typeCell.bindCellViewClick(typeCell.cell_layout,this);
        }else if (type == 2){
            final TypeThreeCell typeCell = (TypeThreeCell) cell;
            typeCell.cell_textView.setText(dataLists.get(section).get(row));
            typeCell.bindCellViewClick(typeCell.cell_layout,this,typeCell.cell_textView);
        }

    }


    @Override
    public String titleForHeaderInSection(SLTableView tableView, int section) {
        return String.format("第%02d组,标题.",(section+1));
    }

    @Override
    public String titleForFooterInSection(SLTableView tableView, int section) {
        return String.format("第%02d组,结尾.",(section+1));
    }

    @Override
    public boolean hiddenHeaderInSection(SLTableView tableView, int section) {
        if (section == dataLists.size() -1) return true;
        return false;
    }

    @Override
    public boolean hiddenFooterInSection(SLTableView tableView, int section) {
        if (section == dataLists.size() -1) return true;
        return false;
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
    public void onCellViewClick(View view, SLIndexPath indexPath, Object userData) {
        int section = indexPath.getSection();
        int row = indexPath.getRow();
        if (userData != null && section == dataLists.size() - 1) // 按钮
        {
            TextView textView = (TextView) userData;
            Toast.makeText(context, String.format("点击,%s.", textView.getText().toString()), Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, String.format("点击,%02d组,%02d行.", (section + 1), (row + 1)), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int layoutId() {
        return 0;
    }

    @Override
    public void initView(ViewGroup view) {

    }

    @Override
    public void initData() {

    }
}
