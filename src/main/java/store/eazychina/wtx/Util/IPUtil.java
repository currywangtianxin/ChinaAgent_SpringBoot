package store.eazychina.wtx.Util;

public class IPUtil {
	public static long ipToLong(String ipString) {

		long result = 0;
		String[] strs = ipString.split("\\.");
		result += Long.parseLong(strs[0]) << 24;
		result += Long.parseLong(strs[1]) << 16;
		result += Long.parseLong(strs[2]) << 8;
		result += Long.parseLong(strs[3]);
		// 1.1.1.255
		return result;
	}

	public static String longToIp(long ip) {
		StringBuilder sb = new StringBuilder();
		// 直接右移24位
		sb.append(ip >> 24);
		sb.append(".");
		// 将高8位置0，然后右移16
		sb.append((ip & 0x00FFFFFF) >> 16);
		sb.append(".");
		// 将高16位置0，然后右移8位
		sb.append((ip & 0x0000FFFF) >> 8);
		sb.append(".");
		// 将高24位置0
		sb.append((ip & 0x000000FF));
		return sb.toString();
	}

	public static void main(String[] args) {
		String ip = "1.255.19.5";
		// 33493253
		long ipLong = ipToLong(ip);
		System.out.println(ipLong);
		String ipStr = longToIp(ipLong);
		System.out.println(ipStr);
	}

}
