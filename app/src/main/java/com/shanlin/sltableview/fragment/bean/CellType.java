package com.shanlin.sltableview.fragment.bean;

/**
 * Created by Shanlin on 2017/1/1.
 */

public enum CellType {
    CELL_TYPE_DOUYU_HEAD(0,"头类型"),
    CELL_TYPE_DOUYU_ROOM(1,"一般房间类型"),
    CELL_TYPE_DOUYU_HOT_AUTHOR(2,"热门作者类型"),
    CELL_TYPE_DOUYU_ROOM_YANZHI(3,"颜值类型"),

    CELL_TYPE_TEXT(1000,"单纯文本类型"),
    CELL_TYPE_GENDER_SELECTOR(1001,"性别选择"),
    CELL_TYPE_EDIT_TEXT(1002,"输入文本类型"),
    CELL_TYPE_CHECK_BOX(1003,"右侧单选类型"),
    CELL_TYPE_EDIT_TEXT_UNIT(1004,"右侧带单位的输入框"),
    CELL_TYPE_DATE_SELECTOR(1005,"时间选择类型"),
    CELL_TYPE_BUTTON(1006,"按钮"),
    CELL_TYPE_LINE(1007,"分割线"),
    ;
    int cellType;
    String desc;

    CellType(int cellType, String desc) {
        this.cellType = cellType;
        this.desc = desc;
    }

    public int getCellType() {
        return cellType;
    }

    public CellType setCellType(int cellType) {
        this.cellType = cellType;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public CellType setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public static CellType typeOfCellType(int cellType){
        CellType type = null;
        CellType[] types = values();
        for (CellType douyuType : types) {
            if (douyuType.getCellType() == cellType){
                type = douyuType;
                break;
            }
        }
        return type;
    }
}
