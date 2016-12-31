package com.shanlin.sltableview.fragment.bean;

import android.graphics.drawable.Drawable;

/**
 * Created by Shanlin on 2016/12/31.
 */

public class DouyuRoomBean {

    private String roomId;
    private String roomOwner;
    private String roomTitle;
    private String roomNumber;
    private Drawable roomImage;


    public DouyuRoomBean() {
    }

    public DouyuRoomBean(String roomOwner, String roomTitle, String roomNumber) {
        this.roomOwner = roomOwner;
        this.roomTitle = roomTitle;
        this.roomNumber = roomNumber;
    }

    public DouyuRoomBean(String roomId, String roomOwner, String roomTitle, String roomNumber) {
        this.roomId = roomId;
        this.roomOwner = roomOwner;
        this.roomTitle = roomTitle;
        this.roomNumber = roomNumber;
    }

    public DouyuRoomBean(String roomId, String roomOwner, String roomTitle, String roomNumber, Drawable roomImage) {
        this.roomId = roomId;
        this.roomOwner = roomOwner;
        this.roomTitle = roomTitle;
        this.roomNumber = roomNumber;
        this.roomImage = roomImage;
    }

    public String getRoomId() {
        return roomId;
    }

    public DouyuRoomBean setRoomId(String roomId) {
        this.roomId = roomId;
        return this;
    }

    public String getRoomOwner() {
        return roomOwner;
    }

    public DouyuRoomBean setRoomOwner(String roomOwner) {
        this.roomOwner = roomOwner;
        return this;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public DouyuRoomBean setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
        return this;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public DouyuRoomBean setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
        return this;
    }

    public Drawable getRoomImage() {
        return roomImage;
    }

    public DouyuRoomBean setRoomImage(Drawable roomImage) {
        this.roomImage = roomImage;
        return this;
    }
}
