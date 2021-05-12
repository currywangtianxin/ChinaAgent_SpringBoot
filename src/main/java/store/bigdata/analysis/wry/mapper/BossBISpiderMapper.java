package store.bigdata.analysis.wry.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import store.bigdata.analysis.wry.pojo.BossBiPojo;
import store.bigdata.analysis.wry.pojo.BossBiPojoFromAddr;
import store.bigdata.analysis.wry.pojo.WeiBoPojo;
import store.bigdata.analysis.wry.pojo.bossPojo;

@Mapper
public interface BossBISpiderMapper {
	public  List<BossBiPojo> findByAddr();
	public  List<BossBiPojo> findByJobName();
	public  List<BossBiPojo> findByAddrJobName();
	public  List<BossBiPojo> findByAddrJobNameBeiJing();
}
