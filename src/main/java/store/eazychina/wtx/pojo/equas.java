package store.eazychina.wtx.pojo;

import java.io.Serializable;

public class equas implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String startip;
	private String endip;
	private String path;
	
	public equas(String startip, String endip, String path) {
		super();
		this.startip = startip;
		this.endip = endip;
		this.path = path;
	}
	public String getStartip() {
		return startip;
	}
	public void setStartip(String startip) {
		this.startip = startip;
	}
	public String getEndip() {
		return endip;
	}
	public void setEndip(String endip) {
		this.endip = endip;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "equas [startip=" + startip + ", endip=" + endip + ", path="
				+ path + "]";
	}
	public equas() {
		super();
	}
	public equas(String endip, String path) {
		super();
		this.endip = endip;
		this.path = path;
	}
	
}
