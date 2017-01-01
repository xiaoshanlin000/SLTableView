package com.shanlin.sltableview.fragment.bean;

import android.graphics.drawable.Drawable;

/**
 * Created by Shanlin on 2016/12/31.
 */

public class DouyuHeadBean extends DouyuBaseBean{

    private Drawable headIcon;
    private String title;
    private String more;

    public DouyuHeadBean() {
        super(DouyuType.TYPE_HEAD);
    }

    public DouyuHeadBean(String title) {
        super(DouyuType.TYPE_HEAD);
        this.title = title;
    }

    public Drawable getHeadIcon() {
        return headIcon;
    }

    public DouyuHeadBean setHeadIcon(Drawable headIcon) {
        this.headIcon = headIcon;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public DouyuHeadBean setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getMore() {
        return more;
    }

    public DouyuHeadBean setMore(String more) {
        this.more = more;
        return this;
    }
}
