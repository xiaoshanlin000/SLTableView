package com.shanlin.sltableview.fragment.bean;

import android.view.inputmethod.EditorInfo;

/**
 * Created by Shanlin on 2017/3/15.
 */

public class EditTextBean extends CellBaseBean {
    private int icon;
    private String hint;
    private String content;
    private int inputType = EditorInfo.TYPE_CLASS_TEXT; // 默认text

    public EditTextBean() {
        super(CellType.CELL_TYPE_EDIT_TEXT);
    }

    public int getIcon() {
        return icon;
    }

    public EditTextBean setIcon(int icon) {
        this.icon = icon;
        return this;
    }

    public String getHint() {
        return hint;
    }

    public EditTextBean setHint(String hint) {
        this.hint = hint;
        return this;
    }

    public String getContent() {
        return content;
    }

    public EditTextBean setContent(String content) {
        this.content = content;
        return this;
    }

    public int getInputType() {
        return inputType;
    }

    public EditTextBean setInputType(int inputType) {
        this.inputType = inputType;
        return this;
    }
}
