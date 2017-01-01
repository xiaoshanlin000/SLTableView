package com.shanlin.sltableview.fragment.bean;

/**
 * Created by Shanlin on 2017/1/1.
 */

public class DouyuBaseBean {
    private DouyuType type;
    private int spanSize;

    public DouyuBaseBean(DouyuType type) {
        this(type,1);
    }

    /**
     *
     * @param type 显示的类型
     * @param spanSize grid 中一行跨越的大小
     */
    public DouyuBaseBean(DouyuType type, int spanSize) {
        this.type = type;
        this.spanSize = spanSize;
    }

    public DouyuType getType() {
        return type;
    }

    public DouyuBaseBean setType(DouyuType type) {
        this.type = type;
        return this;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public DouyuBaseBean setSpanSize(int spanSize) {
        this.spanSize = spanSize;
        return this;
    }
}
