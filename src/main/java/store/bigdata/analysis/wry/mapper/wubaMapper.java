package store.bigdata.analysis.wry.mapper;


import org.apache.ibatis.annotations.Mapper;

import store.bigdata.analysis.wry.pojo.pojo;

@Mapper
public interface wubaMapper {
	
	public  void wubaInsertData(pojo obj);
}
