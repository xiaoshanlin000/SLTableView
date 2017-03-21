package com.shanlin.sltableview.fragment.bean;

/**
 * Created by Shanlin on 2017/3/15.
 */

public class ButtonBean extends CellBaseBean {

    private String text;

    public ButtonBean() {
        super(CellType.CELL_TYPE_BUTTON);
    }

    public String getText() {
        return text;
    }

    public ButtonBean setText(String text) {
        this.text = text;
        return this;
    }
}
