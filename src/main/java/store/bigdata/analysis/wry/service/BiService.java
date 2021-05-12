package store.bigdata.analysis.wry.service;

import java.util.List;

import store.bigdata.analysis.wry.pojo.BiPojo;

public interface BiService {
	public List<BiPojo> findlist();
	public List<BiPojo>  findlistgroupbydatseq();

}
