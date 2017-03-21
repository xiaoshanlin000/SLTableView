package com.shanlin.sltableview.fragment.cell;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.shanlin.library.sltableview.SLTableViewCell;
import com.shanlin.sltableview.R;

/**
 * Created by Shanlin on 2017/3/15.
 */

public class CheckBoxCell extends SLTableViewCell {

    public final ImageView iv_icon;
    public final TextView tv_content;
    public final CheckBox cb_check;

    public CheckBoxCell(View itemView) {
        super(itemView);
        iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
        tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        cb_check = (CheckBox) itemView.findViewById(R.id.cb_check);
    }

    @Override
    public Object value() {
        return cb_check.isChecked() ? "1" : "0";
    }
}
