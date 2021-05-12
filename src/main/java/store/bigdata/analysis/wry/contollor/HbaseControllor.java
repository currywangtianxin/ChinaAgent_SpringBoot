package store.bigdata.analysis.wry.contollor;

import java.util.List;

import net.minidev.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import store.bigdata.analysis.wry.Util.HbaseReadeTable;
import store.bigdata.analysis.wry.pojo.HbasePojo;

@Controller
public class HbaseControllor {
	HbaseReadeTable hbaseReadeTable=new HbaseReadeTable() ;
	
	@RequestMapping("getData4Hbase2Echarts")
	public  String getData4Hbase2Echarts(Model model) throws Exception{
		JSONArray arr=new JSONArray();
		JSONArray arr2=new JSONArray();
		JSONObject jo=new JSONObject();
		List<HbasePojo>  dataMap=hbaseReadeTable.getHbaseData();
		for (HbasePojo hbasePojo : dataMap) {
			String str=hbasePojo.getKey().substring(5,hbasePojo.getKey().toString().length()).split("_")[1];
//			arr.add(str.substring(8).substring(0,2)+":"+str.substring(10));
//			System.out.print(" ---  "+str);
			String seconds=str.substring(10);
			if (seconds.length()<2) {
				seconds=0+seconds;
			}
			arr.add(str.substring(8).substring(0,2)+":"+seconds);
			arr2.add(hbasePojo.getValue());
		}
		System.out.println(arr);
		System.out.println(arr2);
		jo.put("time", arr);
		jo.put("value", arr2);
		model.addAttribute("data", jo);
		return "/BI/RealTime4Hbase";
	}
	
	@ResponseBody
	@RequestMapping("upData4Hbase2Echarts")
	public  JSONObject upData4Hbase2Echarts(Model model) throws Exception{
		JSONArray arr=new JSONArray();
		JSONArray arr2=new JSONArray();
		JSONObject jo=new JSONObject();
		List<HbasePojo>  dataMap=hbaseReadeTable.getHbaseData();
		for (HbasePojo hbasePojo : dataMap) {
			String str=hbasePojo.getKey().substring(5,hbasePojo.getKey().toString().length()).split("_")[1];
//			arr.add(str.substring(8).substring(0,2)+":"+str.substring(10));
//			System.out.print(" ---  "+str);
			String seconds=str.substring(10);
			if (seconds.length()<2) {
				seconds=0+seconds;
			}
			arr.add(str.substring(8).substring(0,2)+":"+seconds);
			arr2.add(hbasePojo.getValue());
		}
		System.out.println(arr);
		System.out.println(arr2);
		jo.put("time", arr);
		jo.put("value", arr2);
		return jo;
		
	}
}
