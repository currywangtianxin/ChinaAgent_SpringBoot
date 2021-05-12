package store.bigdata.analysis.wry.service.impl;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import store.bigdata.analysis.wry.mapper.wubaMapper;
import store.bigdata.analysis.wry.pojo.pojo;
import store.bigdata.analysis.wry.service.wubaDataServie;


@Service
public class wubaDataServiceImpl implements wubaDataServie{
	@Autowired(required=false)
	wubaMapper boss;
	

	public void addwubaData(HashSet<pojo> set) {
		int i=0;
		for (pojo pojo : set) {
			System.out.println("数据库插入数据第"+i+"次");
			boss.wubaInsertData(pojo);
			i++;
		}
	}

}
