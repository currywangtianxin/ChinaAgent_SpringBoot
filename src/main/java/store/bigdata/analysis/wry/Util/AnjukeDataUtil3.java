package store.bigdata.analysis.wry.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import store.bigdata.analysis.wry.pojo.AnjukePojo2;


public class AnjukeDataUtil3 {
	public static void main(String[] args) throws Exception {

			// G://五八爬虫数据
			HashSet<String>set=new HashSet<String>();
			String path="G:\\五八爬虫数据\\安居客爬虫数据\\详细数据";
			getCollectionsData(path, set);
			List<AnjukePojo2> list =getData(set);
			for (AnjukePojo2 anjukePojo2 : list) {
				System.out.println(anjukePojo2);
			}
			
	}
	public static List<AnjukePojo2> getData(HashSet<String>set) throws Exception{
		List<AnjukePojo2> list=new ArrayList<AnjukePojo2>();
		for (String string : set) {
			AnjukePojo2 obj=new AnjukePojo2();
			final String startStr = "<?xml version=\"1.0\" encoding=\"utf-8\" ?> <root>";
			final String endStr = "</root>";
			String str=string.replace("&nbsp", "&#160");
			Document doc =DocumentHelper.parseText(startStr+str+endStr);
			Element rootElt = doc.getRootElement(); // 获取根节点
			Element name = (Element) rootElt.selectSingleNode("h1");
			Element addr = (Element) rootElt.selectSingleNode("//span[@class='sub-hd']");
			Element price = (Element) rootElt.selectSingleNode("//span[@class='average']");
			try {
				if (name.getText().isEmpty()||name.getText()==null) {
					System.out.println(string);
				}else {
					obj.setName(name.getText().trim());
				}
					obj.setAddr(addr.getText().trim());
					obj.setPrice(Integer.parseInt(price.getText().trim()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			List<Element> listMessage =  rootElt.selectNodes("//dd");
			for (int j = 0; j < listMessage.size(); j++) {
				obj.setRopertyType(listMessage.get(0).getText().trim());
				obj.setRopertyCost(listMessage.get(1).getText().trim());
				obj.setArea(listMessage.get(2).getText().trim());
				if (listMessage.get(3).getText().trim().equalsIgnoreCase("暂无数据")!=true) {
					int a=Integer.parseInt(listMessage.get(3).getText().trim().replace("户", ""));
					obj.setUv(a);
				}
				if (listMessage.get(4).getText().trim().equalsIgnoreCase("暂无数据")!=true) {
					int year=Integer.parseInt(listMessage.get(4).getText().trim().replace("年", ""));
					obj.setYear(year);
				}
				if (listMessage.get(5).getText().trim().equalsIgnoreCase("暂无数据")!=true) {
					int park=Integer.parseInt(listMessage.get(5).getText().trim());
					obj.setParkings(park);
				}
				obj.setPotRatio(listMessage.get(6).getText().trim());
				obj.setGreeningRate(listMessage.get(7).getText().trim());
				obj.setDeveloper(listMessage.get(8).getText().trim());
				obj.setPropertyAgent(listMessage.get(9).getText().trim());
				obj.setBusinessDistrict(listMessage.get(10).getText().trim());
			}
			System.out.println(obj+"------");
			list.add(obj);
		}
		return list;
	}
	public static HashSet<String> getCollectionsData(String path,HashSet<String> set) throws Exception{
		List<String> list =new ArrayList<String>();
		List<String> list2 =new ArrayList<String>();
		getFiles(path, list);
		list2=readFileFromFilePath(list);
		int i=0;
		for (String string : list2) {
			String[] arr=string.split("/001");
			for (String string2 : arr) {
				if (string2.trim().isEmpty()!=true) {
					i++;
					set.add(string2);
				}
			}
		}
		System.out.println(set.size());
		//去重后577***去重前7298
	
		return set;
	}
	/**
	 * 边缘校验
	 */
	public static void checkFilePath(String path) {
		if (path.trim().length() == 0 || path == null) {
			throw new IllegalArgumentException("路径不合法");
		}
	}
	public static void getFiles(String path, List<String> list) {
		checkFilePath(path);
		File file = new File(path);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					getFiles(files[i].getPath(), list);
				} else {
					list.add(files[i].getPath());
				}
			}
		} else {
			list.add(file.getPath());
		}
	}
	public static List<String> readFileFromFilePath(List<String> list)
			throws IOException {
		FileInputStream fil;
		BufferedReader bfr = null;
		StringBuffer sbf = new StringBuffer();
		List<String> stringData = new ArrayList<String>();
		for (String string : list) {
			checkFilePath(string);
			File file = new File(string);
			try {
				bfr = new BufferedReader(new java.io.FileReader(file));
				String tempStr;
				while ((tempStr = bfr.readLine()) != null) {
					sbf.append(tempStr + "\n");
				}
				bfr.close();
				stringData.add(sbf.toString());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return stringData;
	}
}
