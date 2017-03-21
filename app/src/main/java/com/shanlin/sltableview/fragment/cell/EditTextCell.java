package com.shanlin.sltableview.fragment.cell;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;

import com.shanlin.library.sltableview.SLTableViewCell;
import com.shanlin.sltableview.R;

/**
 * Created by Shanlin on 2017/3/15.
 */

public class EditTextCell extends SLTableViewCell {

    public final ImageView iv_icon;
    public final EditText et_content;
    public EditTextCell(View itemView) {
        super(itemView);
        iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
        et_content = (EditText) itemView.findViewById(R.id.et_content);
        et_content.setInputType(EditorInfo.TYPE_CLASS_TEXT);//默认 文字键盘
    }

    @Override
    public Object value() {
        return et_content.getText().toString();
    }

}
