package com.shanlin.library.sltableview.adapter;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.shanlin.library.sltableview.SLTableViewCell;

import java.util.HashMap;

/**
 * Created by Shanlin on 2016/12/29.
 */

public class SLStickyHeaderDecoration extends RecyclerView.ItemDecoration {

    private SLTableViewStickyHeaderAdapter headerAdapter;
    private HashMap<Long, SLTableViewCell> headerCache;
    private final SparseArray<Rect> mHeaderRects = new SparseArray<>();

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
                ) {
            View header = getHeaderCell(parent, position).itemView;
            headerHeight =  header.getHeight();
        }
        outRect.set(0, headerHeight, 0, 0);
        if (!headerAdapter.isHeader(position)){
            headerAdapter.getItemOffsets(outRect, position);
        }

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
                    ) {
                int headerId = headerAdapter.getHeaderSectionByPosition(adapterPos);

                if (headerId != previousHeaderId) {
                    Rect headerOffset = mHeaderRects.get(adapterPos);
                    if (headerOffset == null) {
                        headerOffset = new Rect();
                        mHeaderRects.put(adapterPos, headerOffset);
                    }
                    previousHeaderId = headerId;
                    View header = getHeaderCell(parent, adapterPos).itemView;
                    canvas.save();
                    final int left = child.getLeft();
                    final int top = getHeaderTop(parent, child, header, adapterPos, layoutPos);
                    canvas.translate(left, top);
                    header.setTranslationX(left);
                    header.setTranslationY(top);
                    header.draw(canvas);
                    canvas.restore();
                    headerOffset.set(left, top, left + child.getWidth(), top + child.getHeight());
                    if (top < 0 && Math.abs(top) >= header.getHeight()) {
                        header.setVisibility(View.GONE);
                    } else {
                        header.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }

    public SLTableViewCell getHeaderCell(RecyclerView parent, int position) {
        final long key = headerAdapter.getHeaderSectionByPosition(position);
        if (headerCache.containsKey(key)) {
            return headerCache.get(key);
        } else {
            final SLTableViewCell cell = headerAdapter.onCreateHeaderCell(parent, headerAdapter.stickyHeaderType());
            headerAdapter.onBindHeaderCell(cell, position);
            final View header = cell.itemView;


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
        int top = ((int) child.getY()) - headerHeight;
        if (layoutPos == 0) {
            final int count = parent.getChildCount();
            final long currentId = headerAdapter.getHeaderSectionByPosition(adapterPos);
            // find next view with header and compute the offscreen push if needed
            for (int i = 1; i < count; i++) {
                int adapterPosHere = parent.getChildAdapterPosition(parent.getChildAt(i));
                if (adapterPosHere != RecyclerView.NO_POSITION) {
                    long nextId = headerAdapter.getHeaderSectionByPosition(adapterPosHere);
                    if (nextId != currentId) {
                        final View next = parent.getChildAt(i);
                        final int offset = ((int) next.getY()) - (headerHeight + getHeaderCell(parent, adapterPosHere).itemView.getHeight());
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

    /**
     * Gets the position of the header under the specified (x, y) coordinates.
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @return position of header, or -1 if not found
     */
    public int findHeaderPositionUnder(int x, int y) {
        for (int i = 0; i < mHeaderRects.size(); i++) {
            Rect rect = mHeaderRects.get(mHeaderRects.keyAt(i));
            if (rect.contains(x, y)) {
                int position = mHeaderRects.keyAt(i);
                return position;
            }
        }
        return -1;
    }
}
