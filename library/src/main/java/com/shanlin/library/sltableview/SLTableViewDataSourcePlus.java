package com.shanlin.library.sltableview;

/**
 * Created by Shanlin on 2016/12/27.
 */

public interface SLTableViewDataSourcePlus {

    /**
     * section组的title
     * @param tableView
     * @param section
     * @return
     */
    public String titleForHeaderInSection(SLTableView tableView, int section);

    /**
     * section组的floor
     * @param tableView
     * @param section
     * @return
     */
    public String titleForFooterInSection(SLTableView tableView, int section);

//    public boolean canEditRowAtIndexPath(SLTableView tableView, SLIndexPath indexPath);
//
//    public boolean canMoveRowAtIndexPath(SLTableView tableView, SLIndexPath indexPath);
//
//    public void moveRow(SLTableView tableView, SLIndexPath fromIndexPath, SLIndexPath toIndexPath);
}
