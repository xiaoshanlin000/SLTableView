package com.shanlin.sltableview.fragment.bean;

/**
 * Created by Shanlin on 2017/3/15.
 */

public class TextBean extends CellBaseBean {
    private int icon;
    private String content;
    public TextBean() {
        super(CellType.CELL_TYPE_TEXT);
    }

    public int getIcon() {
        return icon;
    }

    public TextBean setIcon(int icon) {
        this.icon = icon;
        return this;
    }

    public String getContent() {
        return content;
    }

    public TextBean setContent(String content) {
        this.content = content;
        return this;
    }
}
