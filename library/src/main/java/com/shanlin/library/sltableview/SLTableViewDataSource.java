package com.shanlin.library.sltableview;

import android.view.ViewGroup;

/**
 * Created by Shanlin on 2016/12/27.
 */

public interface SLTableViewDataSource {

    /**
     * 有多少组
     * @param tableView
     * @return 组数
     */
    public int numberOfSections(SLTableView tableView);

    /**
     * 每组多少列
     * @param tableView
     * @param section
     * @return 列数
     */
    public int numberOfRowsInSection(SLTableView tableView, int section);

    /**
     * 返回当前位置的类型(0,n]
     * @param tableView
     * @param indexPath
     * @return 类型
     */
    public int typeOfIndexPath(SLTableView tableView, SLIndexPath indexPath);

    /**
     *
     * 根据类型返回 cell
     *
     * @param tableView
     * @param parent
     * @param type 类型
     * @return 返回
     */
    public SLTableViewCell cellForType(SLTableView tableView, ViewGroup parent, int type);

    /**
     * 绑定数据
     * @param tableView
     * @param cell
     * @param indexPath
     * @param type
     */
    public void onBindCell(SLTableView tableView, SLTableViewCell cell, SLIndexPath indexPath, int type);

}
