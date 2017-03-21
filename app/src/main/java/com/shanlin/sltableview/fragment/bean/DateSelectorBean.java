package com.shanlin.sltableview.fragment.bean;

/**
 * Created by Shanlin on 2017/3/15.
 */

public class DateSelectorBean extends CellBaseBean {
    private int icon;
    private String content;
    private String date;

    public DateSelectorBean() {
        super(CellType.CELL_TYPE_DATE_SELECTOR);
    }

    public int getIcon() {
        return icon;
    }

    public DateSelectorBean setIcon(int icon) {
        this.icon = icon;
        return this;
    }

    public String getContent() {
        return content;
    }

    public DateSelectorBean setContent(String content) {
        this.content = content;
        return this;
    }

    public String getDate() {
        return date;
    }

    public DateSelectorBean setDate(String date) {
        this.date = date;
        return this;
    }
}
