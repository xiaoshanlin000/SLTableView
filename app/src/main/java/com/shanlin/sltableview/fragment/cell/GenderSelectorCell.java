package com.shanlin.sltableview.fragment.cell;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.shanlin.library.sltableview.SLTableViewCell;
import com.shanlin.sltableview.R;

/**
 * Created by Shanlin on 2017/3/15.
 */

public class GenderSelectorCell extends SLTableViewCell {
    public final ImageView iv_icon;
    public final RadioButton rb_female;
    public final RadioButton rb_male;
    public GenderSelectorCell(View itemView) {
        super(itemView);
        iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
        rb_female = (RadioButton) itemView.findViewById(R.id.rb_female);
        rb_male = (RadioButton) itemView.findViewById(R.id.rb_male);
    }

    @Override
    public Object value() {
        return rb_female.isChecked() ? "0":"1";
    }
}
