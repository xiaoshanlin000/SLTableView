package com.shanlin.library.sltableview;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import java.util.HashMap;

public class SLTableViewCell extends RecyclerView.ViewHolder implements View.OnClickListener{

    private SLIndexPath indexPath;
    private SLCellViewClickListener clickListener;
    private Object userData;
    private String key;
    private boolean requiredValue;
    private ValueFilter valueFilter;

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


    public SLIndexPath getIndexPath() {
        return indexPath.clone();
    }

    @Override
    public void onClick(View v) {
        if (clickListener != null){
            clickListener.onCellViewClick(v,indexPath,userData);
        }
    }

    public boolean isRequiredValue() {
        return requiredValue;
    }

    public SLTableViewCell setRequiredValue(boolean requiredValue) {
        this.requiredValue = requiredValue;
        return this;
    }

    public String getKey() {
        return key;
    }

    public SLTableViewCell setKey(String key) {
        this.key = key;
        return this;
    }

    public HashMap<String,Object> keyValues(){
        HashMap<String,Object> result = new HashMap<String,Object>();
        String key = getKey();
        Object value = value();
        if (!TextUtils.isEmpty(key) && null != value){
            result.put(key,value);
        }
        return result;
    }

//    public ValueFilter getValueFilter() {
//        return valueFilter;
//    }
//
//    public SLTableViewCell setValueFilter(ValueFilter valueFilter) {
//        this.valueFilter = valueFilter;
//        return this;
//    }

//    @Override
//    public boolean valueFilter(Object value){
//        if (null != getValueFilter()) {
//            return getValueFilter().valueFilter(value);
//        } else if (null == value) {
//            return false;
//        } else if (value instanceof String) {
//            return ((String)value).length() > 0;
//        }
//        return false;
//    }

    /**
     *
     * @return
     */
    public Object value(){
        return null;
    }

//    /**
//     * 当 requiredValue = true 和 value() 是空或者长度为0时, 显示的动画
//     * @return
//     */
//    public Animation animationWithNullValue(){
//        TranslateAnimation animation = new TranslateAnimation(-20, 20, 0, 0);
//        animation.setInterpolator(new AccelerateInterpolator());
//        animation.setDuration(100);
//        animation.setRepeatCount(3);
//        animation.setRepeatMode(Animation.REVERSE);
//        return animation;
//    }

    public  interface SLCellViewClickListener{
        public void onCellViewClick(View view, SLIndexPath indexPath, Object userData);
    }

}
