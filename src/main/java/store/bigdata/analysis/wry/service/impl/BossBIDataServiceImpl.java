package store.bigdata.analysis.wry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import store.bigdata.analysis.wry.mapper.BossBISpiderMapper;
import store.bigdata.analysis.wry.mapper.BossSpiderMapper;
import store.bigdata.analysis.wry.mapper.WeiBoMapper;
import store.bigdata.analysis.wry.pojo.BossBiPojo;
import store.bigdata.analysis.wry.pojo.BossBiPojoFromAddr;
import store.bigdata.analysis.wry.pojo.WeiBoPojo;
import store.bigdata.analysis.wry.pojo.bossPojo;
import store.bigdata.analysis.wry.service.BossBIDataService;
import store.bigdata.analysis.wry.service.BossDataService;
import store.bigdata.analysis.wry.service.WeiBoBIDataService;


@Component
public class BossBIDataServiceImpl implements BossBIDataService{


	@Autowired(required=false)
	BossBISpiderMapper boss;

	public List<BossBiPojo> findByAddr() {
		return boss.findByAddr();
	}

	public List<BossBiPojo> findByJobName() {
		return boss.findByJobName();
	}
						   
	public List<BossBiPojo> findByAddrJobName() {
		return boss.findByAddrJobName();
	}

	public List<BossBiPojo> findByAddrJobNameBeiJing() {
		return boss.findByAddrJobNameBeiJing();
	}
}
