package store.eazychina.wtx.Util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerDeUtil {

	/**
	 * 对象数据的写出 缓冲流
	 * 
	 * @param obj
	 * @param objFilePath
	 * @throws IOException
	 */
	public static void saveObj(Object[][][] obj, String objFilePath,int cacheByteArrayLength)
			throws IOException {
		FileOutputStream fos = new FileOutputStream(objFilePath);
		// 字节数组缓冲流
		ByteArrayOutputStream baos = new ByteArrayOutputStream(cacheByteArrayLength);
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obj);
		byte[] byteArray = baos.toByteArray();
		fos.write(byteArray);
		oos.close();
		fos.close();
	}

	/**
	 * 对象读取 缓冲流
	 * 
	 * @param objFilePaht
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object getObj(String objFilePath,int cacheByteArrayLength)
			throws ClassNotFoundException, IOException {
		
		FileInputStream fis = new FileInputStream(objFilePath);
		byte[] byteArray = new byte[cacheByteArrayLength];
		fis.read(byteArray);
		fis.close();
	
		// 字节数组缓冲流
		ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
		ObjectInputStream ois = new ObjectInputStream(bais);
		
		
		long startTimeMillis = System.currentTimeMillis();
		Object object = ois.readObject();
		 long endTimeMillis = System.currentTimeMillis();
		 System.out.println(endTimeMillis - startTimeMillis);
		 
		 
		ois.close();
		return object;
	}
	
	/**
	 * 对象数据的写出
	 * 
	 * @param obj
	 * @param objFilePath
	 * @throws IOException
	 */
	public static void saveObj(Object obj, String objFilePath)
			throws IOException {
		FileOutputStream fos = new FileOutputStream(objFilePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
	}

	/**
	 * 对象读取
	 * 
	 * @param objFilePaht
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object getObj(String objFilePath)
			throws ClassNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(objFilePath);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object object = ois.readObject();
		ois.close();
		return object;
	}

}
