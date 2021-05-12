package store.bigdata.analysis.wry.pojo;

public class HbasePojo {

	private String key;
	private String value;
	public HbasePojo(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public HbasePojo() {
		super();
	}
	@Override
	public String toString() {
		return "HbasePojo [key=" + key + ", value=" + value + "]";
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
