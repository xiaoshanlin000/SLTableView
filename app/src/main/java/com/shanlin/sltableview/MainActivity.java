package com.shanlin.sltableview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SLTableViewDataSource,SLTableViewDataSourcePlus {

    private AppCompatActivity context;
    private SLTableView tableView;
    private LinearLayout tableRootLayout;

    private ArrayList<List<String>> dataLists = new ArrayList<>();
    private LayoutInflater inflater ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        inflater = LayoutInflater.from(context);
        tableRootLayout = (LinearLayout) findViewById(R.id.tableRootLayout);
        tableView = new SLTableView.Builder(context).setTableViewDataSource(this).setTableViewDataSourcePlus(this).build();
        tableRootLayout.addView(tableView);
        initData();
    }
    private void initData(){
        dataLists.clear();
        dataLists.add(Arrays.asList("类型1","类型1"));
        dataLists.add(Arrays.asList("类型2","类型2"));
        dataLists.add(Arrays.asList("按钮"));
        tableView.notifyDataSetChanged();
    }
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
            View rootView = inflater.inflate(R.layout.type_one_cell, null, false);
            cell = new TypeOneCell(rootView);
        }else if(type == 1){
            View rootView = inflater.inflate(R.layout.type_two_cell, null, false);
            cell = new TypeTwoCell(rootView);
        }else if(type == 2){
            View rootView = inflater.inflate(R.layout.type_three_cell, null, false);
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
