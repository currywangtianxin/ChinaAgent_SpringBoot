package store.eazychina.wtx.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import store.eazychina.wtx.pojo.equas;



public class RegularUtil {

	public static boolean isIP(String IP){
		equas equas=new equas();
		if (IP.isEmpty()||IP.equals(" ")||IP.equals("")) {
			return false;
		}
		 Pattern pattern=Pattern.compile("^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$");
		 Matcher matcher = pattern.matcher(IP);
		 if (!matcher.find()) {
			return false;
		}
		 return true;
	}
	
	
	/**
	 * 格式校验
	 * 
	 * @param regexPattern
	 * @param input
	 * @return
	 */
	public static boolean isValid(String regexPattern, String input) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}

	/**
	 * 提取数据
	 * 
	 * @param regexPattern
	 * @param input
	 * @param groupIndex
	 * @return
	 */
	public static String getMatchContent(String regexPattern, String input,
			int groupIndex) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			return matcher.group(groupIndex);
		}
		return null;
	}
}
