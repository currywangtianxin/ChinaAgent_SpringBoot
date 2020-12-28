package store.eazychina.wtx.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import store.eazychina.wtx.pojo.IpPojo;
import store.eazychina.wtx.pojo.equas;
import store.eazychina.wtx.pojo.treemap;



public class GetTreeUtil {
	 public static Object[][][] getIPTree(){
//tree中只存着startip,其他信息在map中



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
//for (IpPojo ipPojo : array) {
//	System.out.println(ipPojo);
//}

Arrays.sort(array);
Object[][][] tree=new Object[256][256][256];
//List<String[][][]> lt=new ArrayList<String[][][]>();
int i111=0;
for (IpPojo ipPojo : array) {
	equas equas=new equas();
	i111++;
	treemap treemap;
	String[] Start = ipPojo.getStartIP().split("\\.");
	String path=ipPojo.getLocation();
	String Start1= Start[0];
	String Start2= Start[1];
	String Start3= Start[2];
	String Start4= Start[3];
	 int num1 = Integer.parseInt(Start1);
	 int num2 = Integer.parseInt(Start2);
	 int num3 = Integer.parseInt(Start3);
	 int num4 = Integer.parseInt(Start4);
		String endip=ipPojo.getEndIp();
		String[] end = ipPojo.getEndIp().split("\\.");
	 	String end1= end[0];
		String end2= end[1];
		String end3= end[2];
		String end4= end[3];
		 int numa1 = Integer.parseInt(end1);
		 int numa2 = Integer.parseInt(end2);
		 int numa3 = Integer.parseInt(end3);
		 int numa4 = Integer.parseInt(end4);
//		 System.out.println(end1+end2+end3+end4+" endip "+endip);
	 equas.setEndip(endip);
	 equas.setPath(path);
	 equas.setStartip(ipPojo.getStartIP());;//头
	 
	 if(tree[num1][num2][num3]!=null){
		 //三维数组中不存在此map
		 treemap=(treemap)tree [num1][num2][num3];
		 treemap.setNumber(i111);
		 treemap.setNum1(num1);
		 treemap.setNum2(num2);
		 treemap.setNum3(num3);
		 Map<Integer, equas> i=treemap.getI11();
		 i.put(numa4, equas);
		 treemap.setI11(i);
		 tree[num1][num2][num3]=treemap;
	 }else {
		 //存在此map直接调用
		 treemap=new treemap();
		 treemap.setNumber(i111);
		 treemap.setNum1(num1);
		 treemap.setNum2(num2);
		 treemap.setNum3(num3);
		 Map<Integer, equas> i=new HashMap<Integer, equas>();
		 i.put(num4, equas);
		 treemap.setI11(i);
		 tree[num1][num2][num3]=treemap;
	}//尾
	 if(tree[numa1][numa2][numa3]!=null){
		 //三维数组中不存在此map
		 treemap=(treemap)tree [numa1][numa2][numa3];
		 treemap.setNumber(i111);
		 treemap.setNum1(numa1);
		 treemap.setNum2(numa2);
		 treemap.setNum3(numa3);
		 Map<Integer, equas> i=treemap.getI11();
		 i.put(numa4, equas);
		 treemap.setI11(i);
		 tree[numa1][numa2][numa3]=treemap;
	 }else {
		 //存在此map直接调用
		 treemap=new treemap();
		 treemap.setNumber(i111);
		 treemap.setNum1(numa1);
		 treemap.setNum2(numa2);
		 treemap.setNum3(numa3);
		 Map<Integer, equas> i=new HashMap<Integer, equas>();
		 i.put(numa4, equas);
		 treemap.setI11(i);
		 tree[numa1][numa2][numa3]=treemap;
	}  

		 }

return tree;
	 }
}
