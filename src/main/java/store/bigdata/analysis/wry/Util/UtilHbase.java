package store.bigdata.analysis.wry.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellScanner;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import store.bigdata.analysis.wry.pojo.HbasePojo;


public class UtilHbase {

	//用于链接hbase的连接器对象,类似mysql jdbc的connection
	public Connection connection;
    //用hbase configuration初始化配置信息的时候会自动加载当前应用classpath下的hbase-site.xml
	public static Configuration configuration = HBaseConfiguration.create();
	
	//初始化hbase操作对象
	public UtilHbase() throws Exception{
	    // ad = new HBaseAdmin(configuration); //过期了，推荐使用Admin
		configuration.set("hbase.zookeeper.quorum", "172.17.0.11");
		configuration.set("hbase.zookeeper.property.clientPort", "2181");
		configuration.set("zookeeper.znode.parent", "/hbase-unsecure");
		//初始化connection连接器
		connection=ConnectionFactory.createConnection(configuration);
	}



    // 新增数据到表里面Put
    public void putData4BigData(String table_name,String rowKey,String value) throws Exception {
        TableName tableName = TableName.valueOf(table_name);
        Table table = connection.getTable(tableName);
        List<Put> batPut = new ArrayList<Put>();
            // 构建put的参数是rowkey rowkey_i (Bytes工具类，各种java基础数据类型和字节数组之间的相互转换)
            Put put = new Put(Bytes.toBytes(rowKey));
            put.addColumn(Bytes.toBytes("five_minutes_stats"), Bytes.toBytes("five_minutes"),
                    Bytes.toBytes(value));
            batPut.add(put);
        table.put(batPut);
        System.out.println("表插入数据成功！");
    }

    // 查询数据
    public List<HbasePojo> getData(String table_Name,List<String> rowkeys) throws Exception {
    	List<HbasePojo> dataMap=new ArrayList<HbasePojo>();
    	TableName tableName = TableName.valueOf(table_Name);
        Table table = connection.getTable(tableName);
        // 构建get对象
        List<Get> gets = new ArrayList<Get>();
        for (String rowkey : rowkeys) {
        	 Get get = new Get(Bytes.toBytes("wtx_bidscreen01_"+rowkey));
        	  gets.add(get);
		}
        Result[] results = table.get(gets);
        for (Result result : results) {
            // 使用cell获取result里面的数据
            CellScanner cellScanner = result.cellScanner();
            while (cellScanner.advance()) {
                Cell cell = cellScanner.current();
                // 从单元格cell中把数据获取并输出
                // 使用 CellUtil工具类，从cell中把数据获取出来
                String rowkey = Bytes.toString(CellUtil.cloneRow(cell));
                String value = Bytes.toString(CellUtil.cloneValue(cell));
                HbasePojo hbPojo=new HbasePojo();
                hbPojo.setKey(rowkey);
                hbPojo.setValue(value);
                dataMap.add(hbPojo);
                System.out.println("rowkey:" + rowkey +",value:" + value);
            }
        }
		return dataMap;
    }

    // 关闭连接
    public void cleanUp() throws Exception {
        connection.close();
    }

}
