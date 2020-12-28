package store.eazychina.wtx.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class treemap implements Serializable{
	private static final long serialVersionUID = 1L;
	//验证是否唯一
	private int number;
	private   int num1;
	//第一个字段
	private   int num2;
	//第二个字段
	private   int num3;
	//第三个字段
	private   int num4;
	//第四个字段
	private  Map<Integer, equas> i11=new HashMap<Integer, equas>();
	//map
	@Override
	public String toString() {
		return "treemap [number=" + number + ", num1=" + num1 + ", num2="
				+ num2 + ", num3=" + num3 + ", num4=" + num4 + ", i11=" + i11
				+ "]";
	}
	public treemap(int number, int num1, int num2, int num3, int num4,
			Map<Integer, equas> i11) {
		super();
		this.number = number;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.i11 = i11;
	}
	public treemap() {
		super();
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int getNum3() {
		return num3;
	}
	public void setNum3(int num3) {
		this.num3 = num3;
	}
	public int getNum4() {
		return num4;
	}
	public void setNum4(int num4) {
		this.num4 = num4;
	}
	public Map<Integer, equas> getI11() {
		return i11;
	}
	public void setI11(Map<Integer, equas> i11) {
		this.i11 = i11;
	}
	

}
