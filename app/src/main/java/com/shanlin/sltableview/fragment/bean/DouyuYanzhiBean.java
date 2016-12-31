package com.shanlin.sltableview.fragment.bean;

import android.graphics.drawable.Drawable;

/**
 * Created by Shanlin on 2016/12/31.
 */

public class DouyuYanzhiBean {

    private String roomId;
    private String roomOwner;
    private String roomName;
    private String roomNumber;
    private String location;
    private Drawable roomImage;

    public DouyuYanzhiBean() {
    }

    public DouyuYanzhiBean(String roomOwner, String roomNumber, String location) {
        this.roomOwner = roomOwner;
        this.roomNumber = roomNumber;
        this.location = location;
    }

    public DouyuYanzhiBean(String roomId, String roomOwner, String roomName, String roomNumber, String location) {
        this.roomId = roomId;
        this.roomOwner = roomOwner;
        this.roomName = roomName;
        this.roomNumber = roomNumber;
        this.location = location;
    }

    public DouyuYanzhiBean(String roomId, String roomOwner, String roomName, String roomNumber, String location, Drawable roomImage) {
        this.roomId = roomId;
        this.roomOwner = roomOwner;
        this.roomName = roomName;
        this.roomNumber = roomNumber;
        this.location = location;
        this.roomImage = roomImage;
    }

    public String getRoomId() {
        return roomId;
    }

    public DouyuYanzhiBean setRoomId(String roomId) {
        this.roomId = roomId;
        return this;
    }

    public String getRoomOwner() {
        return roomOwner;
    }

    public DouyuYanzhiBean setRoomOwner(String roomOwner) {
        this.roomOwner = roomOwner;
        return this;
    }

    public String getRoomName() {
        return roomName;
    }

    public DouyuYanzhiBean setRoomName(String roomName) {
        this.roomName = roomName;
        return this;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public DouyuYanzhiBean setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public DouyuYanzhiBean setLocation(String location) {
        this.location = location;
        return this;
    }

    public Drawable getRoomImage() {
        return roomImage;
    }

    public DouyuYanzhiBean setRoomImage(Drawable roomImage) {
        this.roomImage = roomImage;
        return this;
    }
}
