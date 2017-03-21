package com.shanlin.sltableview.fragment.cell;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shanlin.library.sltableview.SLTableViewCell;
import com.shanlin.sltableview.R;

/**
 * Created by Shanlin on 2017/3/15.
 */

public class ButtonCell extends SLTableViewCell {
    public final LinearLayout ll_root;
    public final TextView tv_text;
    public ButtonCell(View itemView) {
        super(itemView);
        ll_root = (LinearLayout) itemView.findViewById(R.id.ll_root);
        tv_text = (TextView) itemView.findViewById(R.id.tv_text);
    }
}
