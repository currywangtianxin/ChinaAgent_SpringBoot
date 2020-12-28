package store.eazychina.wtx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import store.eazychina.wtx.pojo.BiPojo;

@Mapper
public interface BiMapper {

	public List<BiPojo> findlist();
	
}
