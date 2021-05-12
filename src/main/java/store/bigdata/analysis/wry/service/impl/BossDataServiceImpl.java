package store.bigdata.analysis.wry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import store.bigdata.analysis.wry.mapper.BossSpiderMapper;
import store.bigdata.analysis.wry.pojo.bossPojo;
import store.bigdata.analysis.wry.service.BossDataService;


@Component
public class BossDataServiceImpl implements BossDataService{
	@Autowired(required=false)
	BossSpiderMapper boss;
	
	public void addBossData(List<bossPojo> bossdata) {
		int i=0;
		for (bossPojo bossPojo : bossdata) {
			System.out.println("数据库插入数据第"+i+"次");
			boss.bossAddData(bossPojo);
			i++;
		}
	}

	public List<bossPojo> findAll() {
		return boss.findAll();
	}

	public List<bossPojo> PathLike(String value) {
		return boss.PathLike(value);	}

	public List<bossPojo> jobName(String value) {
		return boss.jobName(value);	}

	public List<bossPojo> companyName(String value) {
		return boss.companyName(value);	}


	public List<bossPojo> jobTagItem(String value) {
		return boss.jobTagItem(value);	}

	public List<bossPojo> moneyLike(Integer value) {
		return boss.moneyLike(value);
	}

	public List<bossPojo> alldata(bossPojo obj) {
		return boss.alldata(obj);
	}

}
