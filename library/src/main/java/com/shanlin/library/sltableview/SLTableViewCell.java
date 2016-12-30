package com.shanlin.library.sltableview;

import android.view.View;

/**
 * Created by Shanlin on 2016/12/27.
 */
public class SLTableViewCell extends SLTableView.ViewHolder implements View.OnClickListener{

    private SLIndexPath indexPath;
    private SLCellViewClickListener clickListener;
    private Object userData;

    public SLTableViewCell(View itemView) {
        super(itemView);
    }

    /**
     *
     * @param view 需要设置点击监听的view
     * @param clickListener 回调接口
     */
    public void bindCellViewClick(View view,SLCellViewClickListener clickListener){
        bindCellViewClick(view,clickListener,null);
    }

    /**
     *
     * @param view 需要设置点击监听的view
     * @param clickListener 回调接口
     * @param userData 用户数据
     */
    public void bindCellViewClick(View view,SLCellViewClickListener clickListener,Object userData){
        view.setOnClickListener(this);
        this.clickListener = clickListener;
        this.userData = userData;
    }

    public SLTableViewCell setIndexPath(SLIndexPath indexPath) {
        this.indexPath = indexPath;
        return this;
    }

    @Override
    public void onClick(View v) {
        if (clickListener != null){
            clickListener.onCellViewClick(v,indexPath,userData);
        }
    }

    public interface SLCellViewClickListener{
        public void onCellViewClick(View view, SLIndexPath indexPath, Object userData);
    }

}
