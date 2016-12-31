package com.shanlin.sltableview.fragment.bean;

import android.graphics.drawable.Drawable;

/**
 * Created by Shanlin on 2016/12/31.
 */

public class DouyuHotAuthorBean {
    private Drawable headIcon;
    private String authorName;
    private String videoNumber;
    private String subscribeNumber;

    public DouyuHotAuthorBean() {
    }

    public DouyuHotAuthorBean(String authorName, String videoNumber, String subscribeNumber) {
        this.authorName = authorName;
        this.videoNumber = videoNumber;
        this.subscribeNumber = subscribeNumber;
    }

    public DouyuHotAuthorBean(Drawable headIcon, String authorName, String videoNumber, String subscribeNumber) {
        this.headIcon = headIcon;
        this.authorName = authorName;
        this.videoNumber = videoNumber;
        this.subscribeNumber = subscribeNumber;
    }

    public Drawable getHeadIcon() {
        return headIcon;
    }

    public DouyuHotAuthorBean setHeadIcon(Drawable headIcon) {
        this.headIcon = headIcon;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public DouyuHotAuthorBean setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public String getVideoNumber() {
        return videoNumber;
    }

    public DouyuHotAuthorBean setVideoNumber(String videoNumber) {
        this.videoNumber = videoNumber;
        return this;
    }

    public String getSubscribeNumber() {
        return subscribeNumber;
    }

    public DouyuHotAuthorBean setSubscribeNumber(String subscribeNumber) {
        this.subscribeNumber = subscribeNumber;
        return this;
    }
}
