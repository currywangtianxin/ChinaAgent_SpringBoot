package store.eazychina.wtx.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetList {
	public static List<String> getlist() {
		try {
			InputStream fis =GetList.class.getClassLoader().getResourceAsStream(StaticValue.ipLibraryPath);
//			 File directory  = new File("");
//		        FileInputStream fis =new FileInputStream(directory.getCanonicalPath()+
//		                "/src/main/resources/" + StaticValue.ipLibraryPath);
			// 节点流对接文件
			if(fis == null){
				fis = new FileInputStream(StaticValue.ipLibraryPath);
			}
			if(fis == null){
				fis = new FileInputStream(StaticValue.ipLibraryPath);
			}
//			FileInputStream fis = new FileInputStream(StaticValue.ipLibraryPath);
			// 转换为字符流
			Reader reader = new InputStreamReader(fis,StaticValue.encoding);
			// 缓冲流
			BufferedReader br = new BufferedReader(reader);
			String tempLine = null;
			List<String> lineList = new ArrayList<String>();
			while ((tempLine = br.readLine()) != null) {
				lineList.add(tempLine);
			}
			br.close();
			return lineList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
