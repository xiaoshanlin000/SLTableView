package com.shanlin.sltableview.fragment.cell;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shanlin.library.sltableview.SLTableViewCell;
import com.shanlin.sltableview.R;

public class TypeTwoCell extends SLTableViewCell {

    public TextView cell_textView;
    public LinearLayout cell_layout;

    public TypeTwoCell(View itemView) {
        super(itemView);
        cell_textView = (TextView) itemView.findViewById(R.id.cell_textView);
        cell_layout = (LinearLayout) itemView.findViewById(R.id.cell_layout);
    }
}