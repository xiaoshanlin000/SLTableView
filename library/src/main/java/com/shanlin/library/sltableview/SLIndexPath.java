package com.shanlin.library.sltableview;

/**
 * Created by Shanlin on 2016/12/27.
 */

public class SLIndexPath {
    private int row;
    private int section;

    public SLIndexPath() {
    }

    public SLIndexPath(int section,int row) {
        if (row < 0) row = 0;
        if (section < 0) section = 0;
        this.row = row;
        this.section = section;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        if (row < 0) row = 0;
        this.row = row;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        if (section < 0) section = 0;
        this.section = section;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)return false;
        SLIndexPath indexPath = (SLIndexPath) obj;
        return this.getRow() == indexPath.getRow() && this
                .getSection() == indexPath.getSection();
    }

    @Override
    protected SLIndexPath clone() {
        return new SLIndexPath(getSection(),getRow());
    }

    @Override
    public String toString() {
        return "SLIndexPath[section:"+section+" row:"+row+"]";
    }
}
