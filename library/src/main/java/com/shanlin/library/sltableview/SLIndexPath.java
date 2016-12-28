package com.shanlin.library.sltableview;

/**
 * Created by Shanlin on 2016/12/27.
 */

public class SLIndexPath {
    private int row;
    private int section;

    public SLIndexPath() {
    }

    public SLIndexPath(int row, int section) {
        this.row = row;
        this.section = section;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)return false;
        SLIndexPath indexPath = (SLIndexPath) obj;
        return this.getRow() == indexPath.getRow() && this
                .getSection() == indexPath.getSection();
    }
}
