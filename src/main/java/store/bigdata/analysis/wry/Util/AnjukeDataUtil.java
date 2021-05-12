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

import store.bigdata.analysis.wry.pojo.AnjukePojo;


public class AnjukeDataUtil {
	public static void main(String[] args) throws Exception {
		// G://五八爬虫数据
		HashSet<String>set=new HashSet<String>();
		String path="G:\\五八爬虫数据\\房地产\\demo";
		getCollectionsData(path, set);
		List<AnjukePojo>list=getData(set);
		for (AnjukePojo anjukePojo : list) {
			System.out.println(anjukePojo);
		}
		}
	public static List<AnjukePojo> getData(HashSet<String> set) throws Exception{
		final String startStr = "<?xml version=\"1.0\" encoding=\"utf-8\" ?> <root>";
		final String endStr = "</root>";
		List<AnjukePojo> list=new ArrayList<AnjukePojo>();
		for (String string : set) {
			AnjukePojo obj=new AnjukePojo();
			Document doc =DocumentHelper.parseText(startStr+string+endStr);
			Element rootElt = doc.getRootElement(); // 获取根节点
			Element name = (Element) rootElt.selectSingleNode("//div[@class='nowrap-min li-community-title']");
			System.out.println(name.getText().trim().replace(" ", "").replace("-", ""));
			obj.setName(name.getText().trim().replace(" ", "").replace("-", ""));
			List<Element> jobTagItem = rootElt.selectNodes("//span");
				if (jobTagItem.size()>2) {
					obj.setAddr(jobTagItem.get(2).getText().trim().replace(" ", "").replace("-", ""));
					obj.setYear(Integer.parseInt(jobTagItem.get(0).getText().trim().replace(" ", "").replace("-", "").replace("建", "")));
					System.out.println("年份为"+jobTagItem.get(0).getText().trim().replace(" ", "").replace("-", ""));
					System.out.println("地址"+jobTagItem.get(2).getText().trim().replace(" ", "").replace("-", ""));
				}else {
					obj.setYear(0);
					obj.setAddr(jobTagItem.get(0).getText().trim().replace(" ", "").replace("-", ""));
					System.out.println("年份为"+0);
					System.out.println("地址"+jobTagItem.get(0).getText().trim().replace(" ", "").replace("-", ""));
				}
			Element price = (Element) rootElt.selectSingleNode("//strong");
			System.out.println(price.getText().trim().replace(" ", "").replace("-", ""));
			obj.setPrice(Integer.parseInt(price.getText().trim().replace(" ", "").replace("-", "")));
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
	
		return null;
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
