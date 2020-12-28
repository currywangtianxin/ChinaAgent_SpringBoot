package store.eazychina.wtx.service;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import store.eazychina.wtx.Util.GetTreeUtil;
import store.eazychina.wtx.Util.IPUtil;
import store.eazychina.wtx.Util.SerDeUtil;
import store.eazychina.wtx.Util.StaticValue;
import store.eazychina.wtx.pojo.equas;
import store.eazychina.wtx.pojo.treemap;

public class FindIPService {

	 public static  Object[][][] iPThreeObjects=(Object[][][]) GetTreeUtil.getIPTree();

	public static equas getIPObject(String IP){
		try {

			equas equas=new equas();
			if (IP.isEmpty()||IP.equals(" ")||IP.equals("")) {
				equas.setPath("IP地址不能为空");
				return equas;
			}
			 Pattern pattern=Pattern.compile("^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$");
			 Matcher matcher = pattern.matcher(IP);
			 if (!matcher.find()) {
				equas.setPath("IP格式错误");
				return equas;
			}
//			//获取tree容器
//			Object[][][] iPThreeObjects=test2.getIPTree();
//			 long starttime=System.currentTimeMillis();
			String[] Start = IP.split("\\.");
			String Start1= Start[0];
			String Start2= Start[1];
			String Start3= Start[2];
			String Start4= Start[3];
			 int num1 = Integer.parseInt(Start1);
			 int num2 = Integer.parseInt(Start2);
			 int num3 = Integer.parseInt(Start3);
			 int num4 = Integer.parseInt(Start4);

			 //如果查询为空,则需要进行模糊查询
			 
			 treemap treemap=(treemap) iPThreeObjects[num1][num2][num3];
			 if (null==treemap) {
				System.out.println("为空");
				//前三字段为空的模糊查询
				int Number1=255;
				int Number2=255;
				int Number3=255;
				//根据保留地址规则,第一个节点一定是对的,不可能是错的,如果第一个节点就是错的,那么后面的查询无法进行
//				for (int k = 0; k <= Number1; k++) {
//					for (int i = 0; i <=Number2; i++) {
//						for (int j = 0; j <=Number3; j++) {
//							
//						}
//					}
//				}
				try {
					for (int i = 0; i <=Number2; i++) {
						for (int j = 0; j <=Number3; j++) {
						 treemap=(treemap) iPThreeObjects[num1][i][j];

							//最后一个字段的模糊查询
							 Map<Integer, equas> i2=treemap.getI11();
							 if (null==i2.get(num4)) {
//								System.out.println("第四个字段为空");
								for(equas value : i2.values()){
									String startIp=value.getStartip();
									String endIP=value.getEndip();
									long startNumber=IPUtil.ipToLong(startIp);
									long endNumber=IPUtil.ipToLong(endIP);
									long findIp=IPUtil.ipToLong(IP);
									if (findIp>=startNumber&findIp<=endNumber) {
										String path=value.getPath();
										equas.setPath(path);
										equas.setEndip(endIP);
										equas.setStartip(startIp);
//										long endTime=System.currentTimeMillis();
//										float seconds = (endTime - starttime) ;  
//										System.out.println("查询耗时 :"+seconds+"毫秒");
										return equas;
									}
									
								}
							}else {
								String path=i2.get(num4).getPath();
								String StartIP=i2.get(num4).getStartip();
								String EndIP=i2.get(num4).getEndip();
								equas.setPath(path);
								equas.setEndip(EndIP);
								equas.setStartip(StartIP);
//								long endTime=System.currentTimeMillis();
//								float seconds = (endTime - starttime) ;  
//								
//								System.out.println("查询耗时 :"+seconds+"毫秒");
								return equas;
							}
								
						
						}
					}
				} catch (Exception e) {
				}finally{
					
				for (int k = 0; k <= Number1; k++) {
					for (int i = 0; i <=Number2; i++) {
						for (int j = 0; j <=Number3; j++) {
						 treemap=(treemap) iPThreeObjects[k][i][j];

							//最后一个字段的模糊查询
							 Map<Integer, equas> i2=treemap.getI11();
							 if (null==i2.get(num4)) {
//								System.out.println("第四个字段为空");
								for(equas value : i2.values()){
									String startIp=value.getStartip();
									String endIP=value.getEndip();
									long startNumber=IPUtil.ipToLong(startIp);
									long endNumber=IPUtil.ipToLong(endIP);
									long findIp=IPUtil.ipToLong(IP);
									if (findIp>=startNumber&findIp<=endNumber) {
										String path=value.getPath();
										equas.setPath(path);
										equas.setEndip(endIP);
										equas.setStartip(startIp);
//										long endTime=System.currentTimeMillis();
//										float seconds = (endTime - starttime) ;  
//										System.out.println("查询耗时 :"+seconds+"毫秒");
										return equas;
									}
									
								}
							}else {
								String path=i2.get(num4).getPath();
								String StartIP=i2.get(num4).getStartip();
								String EndIP=i2.get(num4).getEndip();
								equas.setPath(path);
								equas.setEndip(EndIP);
								equas.setStartip(StartIP);
//								long endTime=System.currentTimeMillis();
//								float seconds = (endTime - starttime) ;  
//								
//								System.out.println("查询耗时 :"+seconds+"毫秒");
								return equas;
							}
								
						
						}
					}
				
					
				}
			}
			}else {
				//最后一个字段的模糊查询
				 Map<Integer, equas> i=treemap.getI11();
				 if (null==i.get(num4)) {
//					System.out.println("第四个字段为空");
					for(equas value : i.values()){
						String startIp=value.getStartip();
						String endIP=value.getEndip();
						long startNumber=IPUtil.ipToLong(startIp);
						long endNumber=IPUtil.ipToLong(endIP);
						long findIp=IPUtil.ipToLong(IP);
						if (findIp>=startNumber&findIp<=endNumber) {
							String path=value.getPath();
							equas.setPath(path);
							equas.setEndip(endIP);
							equas.setStartip(startIp);
//							long endTime=System.currentTimeMillis();
//							float seconds = (endTime - starttime) ;  
//							System.out.println("查询耗时 :"+seconds+"毫秒");
							return equas;
						}
						
					}
				}else {
					String path=i.get(num4).getPath();
					String StartIP=i.get(num4).getStartip();
					String EndIP=i.get(num4).getEndip();
					equas.setPath(path);
					equas.setEndip(EndIP);
					equas.setStartip(StartIP);
//					long endTime=System.currentTimeMillis();
//					float seconds = (endTime - starttime) ;  
//					
//					System.out.println("查询耗时 :"+seconds+"毫秒");
				}
					
			}
				return equas;
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//	public static void main(String[] args) {
//		//249.0.0.0	254.255.255.255	IANA保留地址 CZ88.NET
//
//		System.out.println(getIPObject("250.0.1.0"));
//	}

}
