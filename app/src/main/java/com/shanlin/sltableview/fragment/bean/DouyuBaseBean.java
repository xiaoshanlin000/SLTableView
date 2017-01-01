package com.shanlin.sltableview.fragment.bean;

/**
 * Created by Shanlin on 2017/1/1.
 */

public class DouyuBaseBean {
    private DouyuType type;

    public DouyuBaseBean(DouyuType type) {
        this.type = type;
    }

    public DouyuType getType() {
        return type;
    }

    public DouyuBaseBean setType(DouyuType type) {
        this.type = type;
        return this;
    }
}
