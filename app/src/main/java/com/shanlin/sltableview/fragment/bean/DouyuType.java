package com.shanlin.sltableview.fragment.bean;

/**
 * Created by Shanlin on 2017/1/1.
 */

public enum DouyuType {
    TYPE_HEAD(0,"头类型"),
    TYPE_ROOM(1,"一般房间类型"),
    TYPE_HOT_AUTHOR(2,"热门作者类型"),
    TYPE_ROOM_YANZHI(3,"颜值类型")
    ;
    int type;
    String desc;

    DouyuType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public DouyuType setType(int type) {
        this.type = type;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public DouyuType setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
