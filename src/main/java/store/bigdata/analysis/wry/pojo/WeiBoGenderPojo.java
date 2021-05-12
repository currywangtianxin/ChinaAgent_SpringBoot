package store.bigdata.analysis.wry.pojo;

public class WeiBoGenderPojo {
private String gender;
private int num;
@Override
public String toString() {
	return "WeiBoGenderPojo [gender=" + gender + ", num=" + num + "]";
}
public WeiBoGenderPojo(String gender, int num) {
	super();
	this.gender = gender;
	this.num = num;
}
public WeiBoGenderPojo() {
	super();
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}

}
