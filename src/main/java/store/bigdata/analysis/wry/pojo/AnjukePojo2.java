package store.bigdata.analysis.wry.pojo;

public class AnjukePojo2 {
	
	private String name;
	private String addr;
	private int year;
	private int price;
	//物业类型
	private String ropertyType;
	//物业费
	private String ropertyCost;
	//总建筑面积
	private String area;
	//总户数
	private int  uv;
	//停车位
	private int parkings;
	//容积率
	private String potRatio;
	//绿化率
	private String greeningRate;
	//开发商
	private String developer;
	//物业公司
	private String propertyAgent;
	//所属商圈
	private String businessDistrict;
	@Override
	public String toString() {
		return "AnjukePojo2 [name=" + name + ", addr=" + addr + ", year="
				+ year + ", price=" + price + ", ropertyType=" + ropertyType
				+ ", ropertyCost=" + ropertyCost + ", area=" + area + ", uv="
				+ uv + ", parkings=" + parkings + ", potRatio=" + potRatio
				+ ", greeningRate=" + greeningRate + ", developer=" + developer
				+ ", propertyAgent=" + propertyAgent + ", businessDistrict="
				+ businessDistrict + "]";
	}
	
	
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


	public String getRopertyType() {
		return ropertyType;
	}


	public void setRopertyType(String ropertyType) {
		this.ropertyType = ropertyType;
	}


	public String getRopertyCost() {
		return ropertyCost;
	}


	public void setRopertyCost(String ropertyCost) {
		this.ropertyCost = ropertyCost;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public int getUv() {
		return uv;
	}


	public void setUv(int uv) {
		this.uv = uv;
	}


	public int getParkings() {
		return parkings;
	}


	public void setParkings(int parkings) {
		this.parkings = parkings;
	}


	public String getPotRatio() {
		return potRatio;
	}


	public void setPotRatio(String potRatio) {
		this.potRatio = potRatio;
	}


	public String getGreeningRate() {
		return greeningRate;
	}


	public void setGreeningRate(String greeningRate) {
		this.greeningRate = greeningRate;
	}


	public String getDeveloper() {
		return developer;
	}


	public void setDeveloper(String developer) {
		this.developer = developer;
	}


	public String getPropertyAgent() {
		return propertyAgent;
	}


	public void setPropertyAgent(String propertyAgent) {
		this.propertyAgent = propertyAgent;
	}


	public String getBusinessDistrict() {
		return businessDistrict;
	}


	public void setBusinessDistrict(String businessDistrict) {
		this.businessDistrict = businessDistrict;
	}


	public AnjukePojo2() {
		super();
	}
	public AnjukePojo2(String name, String addr, int year, int price,
			String ropertyType, String ropertyCost, String area, int uv,
			int parkings, String potRatio, String greeningRate,
			String developer, String propertyAgent, String businessDistrict) {
		super();
		this.name = name;
		this.addr = addr;
		this.year = year;
		this.price = price;
		this.ropertyType = ropertyType;
		this.ropertyCost = ropertyCost;
		this.area = area;
		this.uv = uv;
		this.parkings = parkings;
		this.potRatio = potRatio;
		this.greeningRate = greeningRate;
		this.developer = developer;
		this.propertyAgent = propertyAgent;
		this.businessDistrict = businessDistrict;
	}
}
