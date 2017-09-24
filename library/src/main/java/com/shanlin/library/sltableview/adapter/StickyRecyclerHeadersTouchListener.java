package com.shanlin.library.sltableview.adapter;

import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewGroup;

public class StickyRecyclerHeadersTouchListener implements RecyclerView.OnItemTouchListener {
    private final GestureDetector mTapDetector;
    private final RecyclerView mRecyclerView;
    private final SLStickyHeaderDecoration mDecor;

    public StickyRecyclerHeadersTouchListener(final RecyclerView recyclerView,
                                              final SLStickyHeaderDecoration decor) {
        mTapDetector = new GestureDetector(recyclerView.getContext(), new SingleTapDetector());
        mRecyclerView = recyclerView;
        mDecor = decor;
    }

    public SLTableViewStickyAdapter getAdapter() {
        if (mRecyclerView.getAdapter() instanceof SLTableViewStickyAdapter) {
            return (SLTableViewStickyAdapter) mRecyclerView.getAdapter();
        } else {
            throw new IllegalStateException("A RecyclerView with " +
                    StickyRecyclerHeadersTouchListener.class.getSimpleName() +
                    " requires a " + SLTableViewStickyAdapter.class.getSimpleName());
        }
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        boolean tapDetectorResponse = this.mTapDetector.onTouchEvent(e);
        if (tapDetectorResponse) {
            // Don't return false if a single tap is detected
            return true;
        }
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            int position = mDecor.findHeaderPositionUnder((int) e.getX(), (int) e.getY());
            return position != -1;
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent e) { /* do nothing? */ }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        // do nothing
    }


    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    private class SingleTapDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            int position = mDecor.findHeaderPositionUnder((int) e.getX(), (int) e.getY());
            if (position != -1) {
                ViewGroup headerView = (ViewGroup) mDecor.getHeaderCell(mRecyclerView, position).itemView;
                mRecyclerView.playSoundEffect(SoundEffectConstants.CLICK);
                headerView.onTouchEvent(e);
                if (headerView.getVisibility() == View.VISIBLE) {
                    viewClick(headerView, e);
                    return true;
                }
            }
            return false;
        }

        private void viewClick(ViewGroup view, MotionEvent e ) {
            if (inViewInBounds(view, (int) e.getX(), (int) e.getY()) && view.hasOnClickListeners()) {
                view.callOnClick();
            }
            View child;
            for (int i = 0; i < view.getChildCount(); i++) {
                child = view.getChildAt(i);
                if (child instanceof ViewGroup) {
                    viewClick((ViewGroup) child, e);
                } else {
                    if (inViewInBounds(child, (int) e.getX(), (int) e.getY()) && child.hasOnClickListeners()) {
                        child.callOnClick();
                    }
                }
            }
        }

        private boolean inViewInBounds(View view, int x, int y) {
            final float translationX = ViewCompat.getTranslationX(view);
            final float translationY = ViewCompat.getTranslationY(view);
            if (x >= view.getLeft() + translationX &&
                    x <= view.getRight() + translationX &&
                    y >= view.getTop() + translationY &&
                    y <= view.getBottom() + translationY) {
                return true;
            }
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            return true;
        }
    }
}