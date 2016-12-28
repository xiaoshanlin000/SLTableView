# SLTableView

###使用方式

在项目根目录build.gradle中加入

```Java
allprojects {
    repositories {
        jcenter()
        maven(){
            url 'https://dl.bintray.com/xiaoshanlin000/maven'
        }
    }
}
```
在Module build.gradle中加入
```Java
compile 'com.shanlin.library.sltableview:library:1.0.0'
```

###Demo
```Java
public class MainActivity extends AppCompatActivity implements SLTableViewDataSource,SLTableViewDataSourcePlus {

    private AppCompatActivity context;
    private SLTableView tableView;
    private LinearLayout tableRootLayout;

    private ArrayList<List<String>> dataLists = new ArrayList<>();
    private LayoutInflater inflater ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        inflater = LayoutInflater.from(context);
        tableRootLayout = (LinearLayout) findViewById(R.id.tableRootLayout);
        tableView = new SLTableView.Builder(context).setTableViewDataSource(this).setTableViewDataSourcePlus(this).build();
        tableRootLayout.addView(tableView);
        initData();
    }
    private void initData(){
        dataLists.clear();
        dataLists.add(Arrays.asList("1"));
        dataLists.add(Arrays.asList("1","2"));
        dataLists.add(Arrays.asList("1","2","3"));
        dataLists.add(Arrays.asList("1","2","3","4"));
        dataLists.add(Arrays.asList("1","2","3","4","5"));
        dataLists.add(Arrays.asList("1","2","3","4","5","6"));
        tableView.notifyDataSetChanged();
    }
    @Override
    public int numberOfSections(SLTableView tableView) {
        return dataLists.size();
    }

    @Override
    public int numberOfRowsInSection(SLTableView tableView, int section) {
        return dataLists.get(section).size();
    }

    @Override
    public int typeOfIndexPath(SLTableView tableView, SLIndexPath indexPath) {
        return 0;
    }

    @Override
    public SLTableViewCell cellForType(SLTableView tableView, ViewGroup parent, int type) {
        SLTableViewCell cell = null;
        View rootView = inflater.inflate(R.layout.simple_cell,null,false);
        cell = new HistoryCell(rootView);
        return cell;
    }

    @Override
    public void onBindCell(SLTableView tableView, SLTableViewCell cell, SLIndexPath indexPath, int type) {
        HistoryCell historyCell = (HistoryCell) cell;
        final int section = indexPath.getSection();
        final int row = indexPath.getRow();
        historyCell.history_cell_textView.setText(dataLists.get(section).get(row));
        historyCell.history_cell_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,String.format("点击,%02d组,%02d行.",(section+1),(row+1)),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public String titleForHeaderInSection(SLTableView tableView, int section) {
        return String.format("第%02d组,标题.",(section+1));
    }

    @Override
    public String titleForFooterInSection(SLTableView tableView, int section) {
        return String.format("第%02d组,结尾.",(section+1));
    }

    private static class HistoryCell extends SLTableViewCell{

        public TextView history_cell_textView;
        public LinearLayout history_cell_layout;

        public HistoryCell(View itemView) {
            super(itemView);
            history_cell_textView = (TextView) itemView.findViewById(R.id.cell_textView);
            history_cell_layout = (LinearLayout) itemView.findViewById(R.id.history_cell_layout);
        }
    }
}
```
###效果图
![image](https://github.com/xiaoshanlin000/SLTableView/raw/master/screen/1.jpg)
![image](https://github.com/xiaoshanlin000/SLTableView/raw/master/screen/2.jpg)