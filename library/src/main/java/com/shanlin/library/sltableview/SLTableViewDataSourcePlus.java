package com.shanlin.library.sltableview;

/**
 * Created by Shanlin on 2016/12/27.
 */

public interface SLTableViewDataSourcePlus {

    /**
     * section组的title 描述
     * @param tableView
     * @param section
     * @return
     */
    public String titleForHeaderInSection(SLTableView tableView, int section);

    /**
     * section组的floor 描述
     * @param tableView
     * @param section
     * @return
     */
    public String titleForFooterInSection(SLTableView tableView, int section);

    /**
     * section组title是否隐藏
     * @param tableView
     * @param section
     * @return true 隐藏,false不隐藏
     */
    public boolean hiddenHeaderInSection(SLTableView tableView, int section);

    /**
     * section组的floor是否隐藏
     * @param tableView
     * @param section
     * @return true 隐藏,false不隐藏
     */
    public boolean hiddenFooterInSection(SLTableView tableView, int section);

//    public boolean canEditRowAtIndexPath(SLTableView tableView, SLIndexPath indexPath);
//
//    public boolean canMoveRowAtIndexPath(SLTableView tableView, SLIndexPath indexPath);
//
//    public void moveRow(SLTableView tableView, SLIndexPath fromIndexPath, SLIndexPath toIndexPath);
}
