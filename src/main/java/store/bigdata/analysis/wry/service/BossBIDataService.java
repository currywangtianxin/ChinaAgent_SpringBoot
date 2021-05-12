package store.bigdata.analysis.wry.service;

import java.util.List;

import store.bigdata.analysis.wry.pojo.BossBiPojo;
import store.bigdata.analysis.wry.pojo.BossBiPojoFromAddr;
import store.bigdata.analysis.wry.pojo.WeiBoPojo;
import store.bigdata.analysis.wry.pojo.bossPojo;



public interface BossBIDataService {
	public  List<BossBiPojo> findByAddr();
	public  List<BossBiPojo> findByJobName();
	public  List<BossBiPojo> findByAddrJobName();
	public  List<BossBiPojo> findByAddrJobNameBeiJing();
}

