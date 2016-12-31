package com.shanlin.sltableview.fragment.bean;

import android.graphics.drawable.Drawable;

/**
 * Created by Shanlin on 2016/12/31.
 */

public class DouyuHeadBean {

    private Drawable headIcon;
    private String title;
    private String more;
    private int type;

    public DouyuHeadBean() {
    }

    public DouyuHeadBean(String title, int type) {
        this.title = title;
        this.type = type;
    }

    public DouyuHeadBean(String title, String more, int type) {
        this.title = title;
        this.more = more;
        this.type = type;
    }

    public DouyuHeadBean(Drawable headIcon, String title, String more, int type) {
        this.headIcon = headIcon;
        this.title = title;
        this.more = more;
        this.type = type;
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

    public int getType() {
        return type;
    }

    public DouyuHeadBean setType(int type) {
        this.type = type;
        return this;
    }
}
