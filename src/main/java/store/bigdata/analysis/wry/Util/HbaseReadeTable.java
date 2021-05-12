package store.bigdata.analysis.wry.Util;

import java.util.HashMap;
import java.util.List;

import store.bigdata.analysis.wry.pojo.HbasePojo;

public class HbaseReadeTable {
public static void main(String[] args) throws Exception {
	UtilHbase hbaseUtil=new UtilHbase();
	String hbaseTabName="wangtianxin_bigscreen_realtime_stats";
	//前缀字段:wtx_bidscreen01
	DataUtil dataUtil=new DataUtil();
	List<String> key4redis=dataUtil.getIOData4RealTimeDate2RedisKey("2012", "1", "2");
//			String finalKey="wtx_bidscreen01_"+string;
	hbaseUtil.getData(hbaseTabName, key4redis);
	hbaseUtil.cleanUp();
}
public static List<HbasePojo>  getHbaseData() throws Exception{
	UtilHbase hbaseUtil=new UtilHbase();
	String hbaseTabName="wangtianxin_bigscreen_realtime_stats";
	//前缀字段:wtx_bidscreen01
	DataUtil dataUtil=new DataUtil();
	List<String> key4redis=dataUtil.getIOData4RealTimeDate2RedisKey("2012", "1", "2");
	List<HbasePojo> dataMap=hbaseUtil.getData(hbaseTabName, key4redis);
	hbaseUtil.cleanUp();
	return dataMap;
}
}
