package store.eazychina.wtx.service.impl;

import java.io.File;
import java.io.IOException;

import store.eazychina.wtx.Util.Dichotomy;
import store.eazychina.wtx.Util.RegularUtil;
import store.eazychina.wtx.Util.SerDeUtil;
import store.eazychina.wtx.Util.StaticValue;
import store.eazychina.wtx.Util.getPojoArray;
import store.eazychina.wtx.pojo.IpPojo;

public class DataProcessManager {


	public static IpPojo[] array;
	public static IpPojo equas=new IpPojo();
	
	
	//获取容器后开始查询
	//查询方法
	public static IpPojo findMethod(String IP,IpPojo[] array){
		//IP格式校验
		if (!RegularUtil.isIP(IP)) {
			equas.setLocation("IP地址格式错误");
			return  equas;
		}

		int startIndex=0;
		int endIndex=array.length-1;
		int index=Dichotomy.binarySearch(array, IP, startIndex, endIndex);
		if (index==-1) {
			equas.setLocation("此IP不存在");
		}
		equas=array[index];
		return equas;
	}

}
