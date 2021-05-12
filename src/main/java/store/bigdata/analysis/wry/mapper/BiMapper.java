package store.bigdata.analysis.wry.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import store.bigdata.analysis.wry.pojo.BiPojo;

@Mapper
public interface BiMapper {
//词云图
	public List<BiPojo> findlist();
	public List<BiPojo>  findlistgroupbydatseq();
}
