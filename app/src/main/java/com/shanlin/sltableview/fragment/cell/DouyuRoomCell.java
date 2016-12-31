package com.shanlin.sltableview.fragment.cell;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shanlin.library.sltableview.SLTableViewCell;
import com.shanlin.sltableview.R;

/**
 * Created by Shanlin on 2016/12/31.
 */

public class DouyuRoomCell extends SLTableViewCell {

    public TextView room_number_text;
    public TextView room_owner_text;
    public TextView room_title_text;
    public LinearLayout room_layout;
    public DouyuRoomCell(View itemView) {
        super(itemView);
        room_number_text = (TextView) itemView.findViewById(R.id.room_number_text);
        room_owner_text = (TextView) itemView.findViewById(R.id.room_owner_text);
        room_title_text = (TextView) itemView.findViewById(R.id.room_title_text);
        room_layout = (LinearLayout) itemView.findViewById(R.id.room_layout);
    }
}
