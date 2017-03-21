package com.shanlin.sltableview.fragment.cell;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.shanlin.library.sltableview.SLTableViewCell;
import com.shanlin.sltableview.R;

/**
 * Created by Shanlin on 2017/3/15.
 */

public class TextCell extends SLTableViewCell {

    public final ImageView iv_icon;
    public final EditText tv_content;
    public final LinearLayout ll_cell_root;
    public TextCell(View itemView) {
        super(itemView);
        iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
        tv_content = (EditText) itemView.findViewById(R.id.tv_content);
        ll_cell_root = (LinearLayout) itemView.findViewById(R.id.ll_cell_root);
    }
}
