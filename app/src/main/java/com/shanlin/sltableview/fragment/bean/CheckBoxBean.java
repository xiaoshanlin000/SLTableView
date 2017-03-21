package com.shanlin.sltableview.fragment.bean;

/**
 * Created by Shanlin on 2017/3/15.
 */

public class CheckBoxBean extends CellBaseBean {

    private int icon;
    private String content;
    private String select;//除了 null 和 "0" 都是选择

    public CheckBoxBean() {
        super(CellType.CELL_TYPE_CHECK_BOX);
    }

    public int getIcon() {
        return icon;
    }

    public CheckBoxBean setIcon(int icon) {
        this.icon = icon;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CheckBoxBean setContent(String content) {
        this.content = content;
        return this;
    }

    public String getSelect() {
        return select;
    }

    public CheckBoxBean setSelect(String select) {
        this.select = select;
        return this;
    }
}
