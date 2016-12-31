package com.shanlin.sltableview.fragment.cell;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shanlin.library.sltableview.SLTableViewCell;
import com.shanlin.sltableview.R;

/**
 * Created by Shanlin on 2016/12/31.
 */

public class DouyuYanzhiCell extends SLTableViewCell {

    public TextView room_number_text;
    public TextView room_owner_text;
    public TextView room_location;
    public LinearLayout room_layout;
    public DouyuYanzhiCell(View itemView) {
        super(itemView);
        room_number_text = (TextView) itemView.findViewById(R.id.room_number_text);
        room_owner_text = (TextView) itemView.findViewById(R.id.room_owner_text);
        room_location = (TextView) itemView.findViewById(R.id.room_location);
        room_layout = (LinearLayout) itemView.findViewById(R.id.room_layout);
    }
}
