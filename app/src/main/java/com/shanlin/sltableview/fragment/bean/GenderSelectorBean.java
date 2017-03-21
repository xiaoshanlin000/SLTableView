package com.shanlin.sltableview.fragment.bean;

/**
 * Created by Shanlin on 2017/3/15.
 */

public class GenderSelectorBean extends CellBaseBean {
    private int icon;
    private String gender;
    private String maleStr;
    private String femaleStr;

    public GenderSelectorBean() {
        super(CellType.CELL_TYPE_GENDER_SELECTOR);
    }

    public int getIcon() {
        return icon;
    }

    public GenderSelectorBean setIcon(int icon) {
        this.icon = icon;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public GenderSelectorBean setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getMaleStr() {
        return maleStr;
    }

    public GenderSelectorBean setMaleStr(String maleStr) {
        this.maleStr = maleStr;
        return this;
    }

    public String getFemaleStr() {
        return femaleStr;
    }

    public GenderSelectorBean setFemaleStr(String femaleStr) {
        this.femaleStr = femaleStr;
        return this;
    }
}
