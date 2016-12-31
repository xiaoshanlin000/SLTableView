package com.shanlin.sltableview.fragment.cell;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shanlin.library.sltableview.SLTableViewCell;
import com.shanlin.sltableview.R;

/**
 * Created by Shanlin on 2016/12/31.
 */

public class DouyuHeadCell extends SLTableViewCell {
    public TextView cell_head_title_text;
    public LinearLayout cell_head_more_layout;
    public TextView cell_head_more_text;
    public DouyuHeadCell(View itemView) {
        super(itemView);
        cell_head_title_text = (TextView) itemView.findViewById(R.id.cell_head_title_text);
        cell_head_more_layout = (LinearLayout) itemView.findViewById(R.id.cell_head_more_layout);
        cell_head_more_text = (TextView) itemView.findViewById(R.id.cell_head_more_text);
    }
}
