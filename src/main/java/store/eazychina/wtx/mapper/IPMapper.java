package store.eazychina.wtx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import store.eazychina.wtx.pojo.IpPojo;

@Mapper
public interface IPMapper {
public List<IpPojo> loadBySql();
}
