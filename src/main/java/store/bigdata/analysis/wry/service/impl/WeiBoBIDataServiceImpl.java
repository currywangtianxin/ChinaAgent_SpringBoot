package store.bigdata.analysis.wry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import store.bigdata.analysis.wry.mapper.BossBISpiderMapper;
import store.bigdata.analysis.wry.mapper.BossSpiderMapper;
import store.bigdata.analysis.wry.mapper.WeiBoMapper;
import store.bigdata.analysis.wry.pojo.BossBiPojo;
import store.bigdata.analysis.wry.pojo.BossBiPojoFromAddr;
import store.bigdata.analysis.wry.pojo.WeiBoGenderPojo;
import store.bigdata.analysis.wry.pojo.WeiBoPojo;
import store.bigdata.analysis.wry.pojo.bossPojo;
import store.bigdata.analysis.wry.service.BossBIDataService;
import store.bigdata.analysis.wry.service.BossDataService;
import store.bigdata.analysis.wry.service.WeiBoBIDataService;


@Service 
public class WeiBoBIDataServiceImpl implements WeiBoBIDataService{
	@Autowired(required=false)
	WeiBoMapper weiBoMapper;

	public List<WeiBoPojo> WeiBofindAll() {
		return weiBoMapper.WeiBofindAll();
	}

	public List<WeiBoPojo> WeiBofindByF() {
		return weiBoMapper.WeiBofindByF();
	}

	public List<WeiBoPojo> WeiBofindByM() {
		return weiBoMapper.WeiBofindByM();
	}

	public List<WeiBoGenderPojo> WeiBofindGender() {
		return weiBoMapper.WeiBofindGender();
	}

	public List<WeiBoGenderPojo> WeiBoGroupByDate() {
		return weiBoMapper.WeiBoGroupByDate();
	}

	public List<store.bigdata.analysis.wry.pojo.WeiBoGenderPojo> WeiFindAll() {
		return weiBoMapper.WeiFindAll();
	}

	public List<store.bigdata.analysis.wry.pojo.WeiBoGenderPojo> WeiBoTextLike(String str) {
		System.out.println(str+"**************");
		return weiBoMapper.WeiBoTextLike(str);
	}
}
