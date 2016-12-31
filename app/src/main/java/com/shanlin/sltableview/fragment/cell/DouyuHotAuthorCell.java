package com.shanlin.sltableview.fragment.cell;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shanlin.library.sltableview.SLTableViewCell;
import com.shanlin.sltableview.R;

/**
 * Created by Shanlin on 2016/12/31.
 */

public class DouyuHotAuthorCell extends SLTableViewCell {

    public TextView hot_author_name_text;
    public TextView hot_author_video_number_text;
    public TextView hot_author_subscribe_number_text;
    public LinearLayout room_layout;
    public DouyuHotAuthorCell(View itemView) {
        super(itemView);
        hot_author_name_text = (TextView) itemView.findViewById(R.id.hot_author_name_text);
        hot_author_video_number_text = (TextView) itemView.findViewById(R.id.hot_author_video_number_text);
        hot_author_subscribe_number_text = (TextView) itemView.findViewById(R.id.hot_author_subscribe_number_text);
        room_layout = (LinearLayout) itemView.findViewById(R.id.room_layout);
    }
}
