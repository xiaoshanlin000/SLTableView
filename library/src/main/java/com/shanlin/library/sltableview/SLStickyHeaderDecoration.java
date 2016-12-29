package com.shanlin.library.sltableview;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.nineoldandroids.view.ViewHelper;

import java.util.HashMap;

/**
 * Created by Shanlin on 2016/12/29.
 */

public class SLStickyHeaderDecoration extends RecyclerView.ItemDecoration {
    private SLTableViewStickyHeaderAdapter headerAdapter;
    private HashMap<Long,SLTableViewCell> headerCache;

    public SLStickyHeaderDecoration(SLTableViewStickyHeaderAdapter headerAdapter) {
        this.headerAdapter = headerAdapter;
        this.headerCache = new HashMap<>();
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int headerHeight = 0;
        if (position != RecyclerView.NO_POSITION
                && headerAdapter.stickyHeader(position)
                )
        {
            View header = getHeaderCell(parent, position).itemView;
            headerHeight = header.getHeight();
        }
        outRect.set(0,headerHeight,0,0);
    }

    @Override
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        //super.onDrawOver(c, parent, state);
        final int count = parent.getChildCount();
        int previousHeaderId = -1;
        for (int layoutPos = 0; layoutPos < count; layoutPos++) {
            final View child = parent.getChildAt(layoutPos);
            final int adapterPos = parent.getChildAdapterPosition(child);

            if (adapterPos != RecyclerView.NO_POSITION
                    && (headerAdapter.stickyHeader(adapterPos)
                    || headerAdapter.showStickyHeader(adapterPos))
                    )
            {
                int headerId = headerAdapter.getHeaderPosition(adapterPos);

                if (headerId != previousHeaderId) {
                    previousHeaderId = headerId;
                    View header = getHeaderCell(parent, adapterPos).itemView;
                    canvas.save();

                    final int left = child.getLeft();
                    final int top = getHeaderTop(parent, child, header, adapterPos, layoutPos);
                    canvas.translate(left, top);
                    ViewHelper.setTranslationX(header,left);
                    ViewHelper.setTranslationY(header,top);
                    header.draw(canvas);
                    canvas.restore();
                }
            }
        }
    }

    private SLTableViewCell getHeaderCell(RecyclerView parent, int position) {
        final long key = headerAdapter.getHeaderPosition(position);
        if (headerCache.containsKey(key)) {
            return headerCache.get(key);
        } else {
            final SLTableViewCell cell = headerAdapter.onCreateHeaderCell(parent,headerAdapter.stickyHeaderType());
            final View header = cell.itemView;

            headerAdapter.onBindHeaderCell(cell, position);

            int widthSpec = View.MeasureSpec.makeMeasureSpec(parent.getMeasuredWidth(), View.MeasureSpec.EXACTLY);
            int heightSpec = View.MeasureSpec.makeMeasureSpec(parent.getMeasuredHeight(), View.MeasureSpec.UNSPECIFIED);

            int childWidth = ViewGroup.getChildMeasureSpec(widthSpec,
                    parent.getPaddingLeft() + parent.getPaddingRight(), header.getLayoutParams().width);
            int childHeight = ViewGroup.getChildMeasureSpec(heightSpec,
                    parent.getPaddingTop() + parent.getPaddingBottom(), header.getLayoutParams().height);

            header.measure(childWidth, childHeight);
            header.layout(0, 0, header.getMeasuredWidth(), header.getMeasuredHeight());
            headerCache.put(key, cell);

            return cell;
        }
    }

    private int getHeaderTop(RecyclerView parent, View child, View header, int adapterPos, int layoutPos) {
        int headerHeight = header.getHeight();
        int top = ((int) ViewHelper.getY(child)) - headerHeight;
        if (layoutPos == 0) {
            final int count = parent.getChildCount();
            final long currentId = headerAdapter.getHeaderPosition(adapterPos);
            // find next view with header and compute the offscreen push if needed
            for (int i = 1; i < count; i++) {
                int adapterPosHere = parent.getChildAdapterPosition(parent.getChildAt(i));
                if (adapterPosHere != RecyclerView.NO_POSITION) {
                    long nextId = headerAdapter.getHeaderPosition(adapterPosHere);
                    if (nextId != currentId) {
                        final View next = parent.getChildAt(i);
                        final int offset = ((int) ViewHelper.getY(next)) - (headerHeight + getHeaderCell(parent, adapterPosHere).itemView.getHeight());
                        if (offset < 0) {
                            return offset;
                        } else {
                            break;
                        }
                    }
                }
            }

            top = Math.max(0, top);
        }

        return top;
    }
}
