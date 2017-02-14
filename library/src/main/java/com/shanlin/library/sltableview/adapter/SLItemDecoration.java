package com.shanlin.library.sltableview.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Shanlin on 2016/12/31.
 */

public class SLItemDecoration extends RecyclerView.ItemDecoration {
    private SLTableViewAdapter adapter;

    public SLItemDecoration(SLTableViewAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        adapter.getItemOffsets(outRect,position);
    }
}
