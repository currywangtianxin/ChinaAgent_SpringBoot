package store.eazychina.wtx.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import store.eazychina.wtx.pojo.IpPojo;




public class getPojoArray {
	public static  IpPojo[] getIParray() {

		 long starttime=System.currentTimeMillis();
		 
		 List<String> list= GetList.getlist();

		 List<IpPojo> obj=new ArrayList<IpPojo>();
		 for (String string : list) {
		 	// 处理空行
		 	if (string == null || string.trim().equals("")) {
		 		continue;
		 	}
		 	// 以制表符分割,得到字符串数组
		 	String[] columnArray = string.split("\t");
		 	// 获取起始IP
		 	String startIP = columnArray[0];
		 	// 获取结束IP
		 	String endIP = columnArray[1];
		 	// 获取归属地
		 	String location = columnArray[2];
		 	IpPojo pojo=new IpPojo(startIP, endIP, location);
		 	
		 	obj.add(pojo);

		 }


		 IpPojo[] array= new IpPojo[obj.size()];
		 obj.toArray(array);

		 Arrays.sort(array);
		 return array;
	}
}
