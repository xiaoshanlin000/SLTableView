package com.shanlin.library.sltableview;

import android.view.View;

/**
 * Created by Shanlin on 2016/12/27.
 */

public interface SLTableViewDelegate {

    /**
     * section组的title 描述
     * @param tableView SLTableView
     * @param section 组下标
     * @return header
     */
    public String titleForHeaderInSection(SLTableView tableView, int section);

    /**
     * section组的floor 描述
     * @param tableView {@link SLTableView}
     * @param section 组下标
     * @return header
     */
    public String titleForFooterInSection(SLTableView tableView, int section);

    /**
     * section组title是否隐藏
     * @param tableView {@link SLTableView}
     * @param section 组下标
     * @return true 隐藏,false不隐藏
     */
    public boolean hiddenHeaderInSection(SLTableView tableView, int section);

    /**
     * section组的floor是否隐藏
     * @param tableView {@link SLTableView}
     * @param section 组下标
     * @return true 隐藏,false不隐藏
     */
    public boolean hiddenFooterInSection(SLTableView tableView, int section);


    /**
     * 自定义每组header
     * @param tableView  {@link SLTableView}
     * @param section 组数
     * @return {@link View}
     */
    public View viewForHeaderInSection(SLTableView tableView, int section);

    /**
     * 自定义每组footer
     * @param tableView  {@link SLTableView}
     * @param section 组数
     * @return {@link View}
     */
    public View viewForFooterInSection(SLTableView tableView,int section);



    /**
     * 绑定自定义每组header的数据
     * @param tableView  {@link SLTableView}
     * @param view {@link View}
     * @param section 组数
     */
    public void onBindHeaderInSection(SLTableView tableView, View view, int section);

    /**
     * 自定义每组footer
     * @param tableView  {@link SLTableView}
     * @param view {@link View}
     * @param section 组数
     */
    public void onBindFooterInSection(SLTableView tableView, View view,int section);


    /**
     * cell中某个值错误
     * @param tableView {@link SLTableView}
     * @param indexPath 位置
     * @param value 某个值
     */
    public void onCellValueError(SLTableView tableView, SLIndexPath indexPath, Object value);

//    public boolean canEditRowAtIndexPath(SLTableView tableView, SLIndexPath indexPath);
//
//    public boolean canMoveRowAtIndexPath(SLTableView tableView, SLIndexPath indexPath);
//
//    public void moveRow(SLTableView tableView, SLIndexPath fromIndexPath, SLIndexPath toIndexPath);
}
