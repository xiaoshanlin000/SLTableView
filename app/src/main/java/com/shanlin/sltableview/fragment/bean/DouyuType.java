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
    int cellType;
    String desc;

    DouyuType(int cellType, String desc) {
        this.cellType = cellType;
        this.desc = desc;
    }

    public int getCellType() {
        return cellType;
    }

    public DouyuType setCellType(int cellType) {
        this.cellType = cellType;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public DouyuType setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public static DouyuType typeOfCellType(int cellType){
        DouyuType type = null;
        DouyuType[] types = values();
        for (DouyuType douyuType : types) {
            if (douyuType.getCellType() == cellType){
                type = douyuType;
                break;
            }
        }
        return type;
    }
}
