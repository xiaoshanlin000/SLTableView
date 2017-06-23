# SLTableView

SLTableView是一个基于RecyclerView的分组显示库. SLTableView 旨在减少代码量, 增加UI的复用率, 通过简单的配置, 从而实现各种分组效果.

效果图


<img width="384" height="640" src="https://github.com/xiaoshanlin000/SLTableView/raw/master/screen/1.png"/> <img width="384" height="640" src="https://github.com/xiaoshanlin000/SLTableView/raw/master/screen/2.png"/>
<img width="384" height="640" src="https://github.com/xiaoshanlin000/SLTableView/raw/master/screen/3.png"/> <img width="384" height="640" src="https://github.com/xiaoshanlin000/SLTableView/raw/master/screen/4.png"/>

快速开始

导入库
maven
```
<dependency>
  <groupId>com.shanlin.library.sltableview</groupId>
  <artifactId>library</artifactId>
  <version>1.1.2</version>
  <type>pom</type>
</dependency>
```

gradle
```
compile 'com.shanlin.library.sltableview:library:1.1.2'
```

使用介绍

必须实现的接口
```
SLTableViewDataSource (配置数据信息)
```
可选接口
```
SLTableViewDelegate(配置header,floor信息)
SLTableViewLayoutManagerExpand(LayoutManager的扩展接口,设置一列的跨度,设置间距等)
SLTableViewCell.SLCellViewClickListener (cell内某view的点击监听接口)

```
初始化SLTableView
```
    tableView = new SLTableView.Builder(context)
                .setTableViewDataSource(this)
                .setTableViewDataSourcePlus(this)
                .showStickyHeader(false)
                .build();
    view.addView(tableView);
```

详情请运行demo

License
```
Copyright shanlin

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```