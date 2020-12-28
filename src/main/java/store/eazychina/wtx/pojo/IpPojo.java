package store.eazychina.wtx.pojo;

import java.io.Serializable;

import store.eazychina.wtx.Util.IPUtil;


public class IpPojo implements Comparable<IpPojo>,Serializable{
	private static final long serialVersionUID = 1L;
private String startIP;
private String endIp;
private String location;
public String getStartIP() {
	return startIP;
}
public void setStartIP(String startIP) {
	this.startIP = startIP;
}
public String getEndIp() {
	return endIp;
}
public void setEndIp(String endIp) {
	this.endIp = endIp;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
@Override
public String toString() {
	return "IpPojo [startIP=" + startIP + ", endIp=" + endIp + ", location="
			+ location + "]";
}
public IpPojo(String startIP, String endIp, String location) {
	super();
	this.startIP = startIP;
	this.endIp = endIp;
	this.location = location;
}
public IpPojo() {
	super();
}
@Override
public int compareTo(IpPojo o) {
	long status = IPUtil.ipToLong(this.startIP) - IPUtil.ipToLong(o.startIP);
	return  status > 0 ? 1 : (status < 0 ? -1 : 0);
}

}
