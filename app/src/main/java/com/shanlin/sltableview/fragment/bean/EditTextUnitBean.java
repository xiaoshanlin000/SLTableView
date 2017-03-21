package com.shanlin.sltableview.fragment.bean;

import android.view.inputmethod.EditorInfo;

/**
 * Created by Shanlin on 2017/3/15.
 */

public class EditTextUnitBean extends CellBaseBean {

    private int icon;
    private String hint;
    private String content;
    private String unit;
    private int inputType = EditorInfo.TYPE_CLASS_TEXT; // 默认text

    public EditTextUnitBean() {
        super(CellType.CELL_TYPE_EDIT_TEXT_UNIT);
    }

    public int getIcon() {
        return icon;
    }

    public EditTextUnitBean setIcon(int icon) {
        this.icon = icon;
        return this;
    }

    public String getHint() {
        return hint;
    }

    public EditTextUnitBean setHint(String hint) {
        this.hint = hint;
        return this;
    }

    public String getContent() {
        return content;
    }

    public EditTextUnitBean setContent(String content) {
        this.content = content;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public EditTextUnitBean setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public int getInputType() {
        return inputType;
    }

    public EditTextUnitBean setInputType(int inputType) {
        this.inputType = inputType;
        return this;
    }
}
