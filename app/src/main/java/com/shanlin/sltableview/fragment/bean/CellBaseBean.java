package com.shanlin.sltableview.fragment.bean;

/**
 * Created by Shanlin on 2017/1/1.
 */

public class CellBaseBean {
    private CellType type;
    private int spanSize;
    private String key;
    private boolean requiredValue;

    public CellBaseBean(CellType type) {
        this(type, 1);
    }

    /**
     * @param type     显示的类型
     * @param spanSize grid 中一行跨越的大小
     */
    public CellBaseBean(CellType type, int spanSize) {
        this.type = type;
        this.spanSize = spanSize;
    }

    public CellType getType() {
        return type;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public CellBaseBean setSpanSize(int spanSize) {
        this.spanSize = spanSize;
        return this;
    }

    public String getKey() {
        return key;
    }

    public CellBaseBean setKey(String key) {
        this.key = key;
        return this;
    }

    public boolean isRequiredValue() {
        return requiredValue;
    }

    public CellBaseBean setRequiredValue(boolean requiredValue) {
        this.requiredValue = requiredValue;
        return this;
    }

}
