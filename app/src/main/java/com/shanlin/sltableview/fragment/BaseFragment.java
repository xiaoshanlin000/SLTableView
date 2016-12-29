package com.shanlin.sltableview.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shanlin.library.sltableview.SLIndexPath;
import com.shanlin.library.sltableview.SLTableView;
import com.shanlin.library.sltableview.SLTableViewCell;
import com.shanlin.library.sltableview.SLTableViewDataSource;
import com.shanlin.library.sltableview.SLTableViewDataSourcePlus;
import com.shanlin.sltableview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shanlin on 2016/12/29.
 */

public abstract class BaseFragment extends Fragment  implements SLTableViewDataSource,SLTableViewDataSourcePlus {

    protected Activity context;

    protected ArrayList<List<String>> dataLists = new ArrayList<>();
    protected LayoutInflater inflater ;
    protected View rootView;
    protected LinearLayout tableRootLayout;
    protected SLTableView tableView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        inflater = LayoutInflater.from(context);

    }

    protected View createView(@LayoutRes int layoutId, LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState){
        if (rootView == null){
            rootView = inflater.inflate(layoutId,container,false);
            tableRootLayout = (LinearLayout) rootView.findViewById(R.id.tableRootLayout);
            initView(tableRootLayout);
            initData();
        }
        return rootView;
    }

    public abstract void initView(ViewGroup view);
    public abstract void initData();

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
            typeCell.cell_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,String.format("点击,%02d组,%02d行.",(section+1),(row+1)),Toast.LENGTH_SHORT).show();
                }
            });
        }else if (type == 1){
            TypeTwoCell typeCell = (TypeTwoCell) cell;
            typeCell.cell_textView.setText(dataLists.get(section).get(row));
            typeCell.cell_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,String.format("点击,%02d组,%02d行.",(section+1),(row+1)),Toast.LENGTH_SHORT).show();
                }
            });
        }else if (type == 2){
            final TypeThreeCell typeCell = (TypeThreeCell) cell;
            typeCell.cell_textView.setText(dataLists.get(section).get(row));
            typeCell.cell_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,String.format("点击,%s.",typeCell.cell_textView.getText().toString()),Toast.LENGTH_SHORT).show();
                }
            });
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

    private static class TypeOneCell extends SLTableViewCell{

        public TextView cell_textView;
        public LinearLayout cell_layout;

        public TypeOneCell(View itemView) {
            super(itemView);
            cell_textView = (TextView) itemView.findViewById(R.id.cell_textView);
            cell_layout = (LinearLayout) itemView.findViewById(R.id.cell_layout);
        }
    }
    private static class TypeTwoCell extends SLTableViewCell{

        public TextView cell_textView;
        public LinearLayout cell_layout;

        public TypeTwoCell(View itemView) {
            super(itemView);
            cell_textView = (TextView) itemView.findViewById(R.id.cell_textView);
            cell_layout = (LinearLayout) itemView.findViewById(R.id.cell_layout);
        }
    }
    private static class TypeThreeCell extends SLTableViewCell{

        public TextView cell_textView;
        public LinearLayout cell_layout;

        public TypeThreeCell(View itemView) {
            super(itemView);
            cell_textView = (TextView) itemView.findViewById(R.id.cell_textView);
            cell_layout = (LinearLayout) itemView.findViewById(R.id.cell_layout);
        }
    }
}
