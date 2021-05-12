package store.bigdata.analysis.wry.pojo;

public class AnjukePojo {
private String name;
private String addr;
private int year;
private int price;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
@Override
public String toString() {
	return "AnjukePojo [name=" + name + ", addr=" + addr + ", year=" + year
			+ ", price=" + price + "]";
}
public AnjukePojo(String name, String addr, int year, int price) {
	super();
	this.name = name;
	this.addr = addr;
	this.year = year;
	this.price = price;
}
public AnjukePojo() {
	super();
}

}
