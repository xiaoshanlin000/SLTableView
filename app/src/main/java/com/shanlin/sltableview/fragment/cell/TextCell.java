package com.shanlin.sltableview.fragment.cell;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shanlin.library.sltableview.SLTableViewCell;
import com.shanlin.sltableview.R;

/**
 * Created by Shanlin on 2017/3/15.
 */

public class TextCell extends SLTableViewCell {

    public final ImageView iv_icon;
    public final TextView tv_content;
    public final LinearLayout ll_cell_root;
    public TextCell(View itemView) {
        super(itemView);
        iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
        tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        ll_cell_root = (LinearLayout) itemView.findViewById(R.id.ll_cell_root);
    }
}
