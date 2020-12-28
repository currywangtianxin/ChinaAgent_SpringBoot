package store.eazychina.wtx.contollor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import store.eazychina.wtx.Util.GetList;
import store.eazychina.wtx.pojo.IpPojo;
import store.eazychina.wtx.pojo.equas;
import store.eazychina.wtx.service.FindIPService;
import store.eazychina.wtx.service.IPService;
import store.eazychina.wtx.service.impl.DataProcessManager;
import store.eazychina.wtx.service.impl.IPServiceImpl;

@Controller
@RequestMapping("LookingIP")
public class FindIPContollor {
//	FindIPService ipService=new FindIPService();
	@Autowired(required=true)
	IPService ipObj;
	@ResponseBody
	@RequestMapping("ByTree")
	public equas findIpPathByTree(String IP){
		System.out.println(IP);
		long starttime=System.currentTimeMillis();
//		=ipService.getIPObject(IP);
//		System.out.println(equas1);
		long endTime=System.currentTimeMillis();
		float seconds = (endTime - starttime) ;  
		System.out.println(seconds);
//		String str=equas1.getPath();
		String str= "  尚未支持Linux系统缓存查询      此次查询耗时"+seconds+"毫秒";
		equas equas1=new equas();
		equas1.setPath(str);
		return equas1;
	}
	@RequestMapping("Tree")
	public String findIPbyTree(){
		System.out.println("相应页面数据");
		return "/jsp/findip/findipbytree";
	}
	
	@RequestMapping("sql")
	public String findIPbySql(){
		System.out.println("相应页面数据");
		return "/jsp/findip/findipbysql";
	}
	@ResponseBody
	@RequestMapping("BySql")
	public IpPojo findIpPathBySql(String IP){
		System.out.println(IP);
		long starttime=System.currentTimeMillis();
		List<IpPojo>list=ipObj.getList();
		IpPojo[] array=new IpPojo[list.size()];
		list.toArray(array);
		Arrays.sort(array);
		IpPojo equas1=DataProcessManager.findMethod(IP, array);
		System.out.println(equas1);
		long endTime=System.currentTimeMillis();
		float seconds = (endTime - starttime) ;  
		System.out.println(seconds);
		String str=equas1.getLocation();
		str=str+"       此次查询耗时"+seconds+"毫秒";
		equas1.setLocation(str);
		return equas1;
	}
	
	
	
}
