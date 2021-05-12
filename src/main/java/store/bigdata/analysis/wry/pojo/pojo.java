package store.bigdata.analysis.wry.pojo;

public class pojo {
//名称
private String name;
//地区
private String region;
//位置
private String position;
//经营状态
private String state;
//详细信息(店铺位置状态)
private String information;
//联系人
private String agent;
//承租属性
private String managerCompany;
//用途属性
private String tag_wrap;
//价格
private double price;
//面积
private double area;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRegion() {
	return region;
}
public void setRegion(String region) {
	this.region = region;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getInformation() {
	return information;
}
public void setInformation(String information) {
	this.information = information;
}
public String getAgent() {
	return agent;
}
public void setAgent(String agent) {
	this.agent = agent;
}
public String getManagerCompany() {
	return managerCompany;
}
public void setManagerCompany(String managerCompany) {
	this.managerCompany = managerCompany;
}
public String getTag_wrap() {
	return tag_wrap;
}
public void setTag_wrap(String tag_wrap) {
	this.tag_wrap = tag_wrap;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public double getArea() {
	return area;
}
public void setArea(double area) {
	this.area = area;
}
@Override
public String toString() {
	return "pojo [name=" + name + ", region=" + region + ", position="
			+ position + ", state=" + state + ", information=" + information
			+ ", agent=" + agent + ", managerCompany=" + managerCompany
			+ ", tag_wrap=" + tag_wrap + ", price=" + price + ", area=" + area
			+ "]";
}
public pojo(String name, String region, String position, String state,
		String information, String agent, String managerCompany,
		String tag_wrap, double price, double area) {
	super();
	this.name = name;
	this.region = region;
	this.position = position;
	this.state = state;
	this.information = information;
	this.agent = agent;
	this.managerCompany = managerCompany;
	this.tag_wrap = tag_wrap;
	this.price = price;
	this.area = area;
}
public pojo() {
	super();
}


}
