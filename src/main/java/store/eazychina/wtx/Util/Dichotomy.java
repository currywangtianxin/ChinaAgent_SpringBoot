package store.eazychina.wtx.Util;

import store.eazychina.wtx.pojo.IpPojo;


public class Dichotomy {


	public static int getIndex(int startIndex,int endIndex,String IP,IpPojo[] array){
		
		long startNumnber=IPUtil.ipToLong(array[startIndex].getStartIP());
		long endNumber=IPUtil.ipToLong(array[endIndex].getEndIp());
		long attack=IPUtil.ipToLong(IP);
		long mindNumber=IPUtil.ipToLong(array[(endIndex+startIndex)/2].getStartIP());
		if (mindNumber>endNumber) {
			return -1;
		}
		if (mindNumber<startNumnber) {
			//在左边
			endIndex=startIndex-1;
		}else if (mindNumber>endNumber) {
			startIndex=endIndex+1;
		}else {
			return    (endIndex+startIndex)/2;
		}
		
		return getIndex(startIndex, endIndex, IP, array);
	}
	
	public static int binarySearch(IpPojo[] nArray, String ip, int startIndex, int endIndex){
        // 获取搜索片段的下标中间值
        int index = (startIndex + endIndex) / 2;
        // 若未找到值会报栈溢出错误，所以需要捕捉
        // 也有可能报数组下标越界异常
        // 索性直接捕捉所有错误和异常
        try {
        	
            if (IPUtil.ipToLong(nArray[index].getStartIP()) > IPUtil.ipToLong(ip))
                // index-1: 因为 nArray[index] 已经确认大于查找的值，需要把搜索结束点往左（小）移，故需要-1
                return binarySearch(nArray, ip, startIndex, index-1);
            else if(IPUtil.ipToLong(nArray[index].getEndIp()) < IPUtil.ipToLong(ip))
            	/* if (nArray[index] < val) */
                // index+1: 因为 nArray[index] 已经确认小于查找的值，需要把搜索起始点往右（大）移，故需要+1
                return binarySearch(nArray, ip, index+1, endIndex);
            else  
                return index;
        }
        catch (Throwable t){
            return -1;
        }
    }

}
