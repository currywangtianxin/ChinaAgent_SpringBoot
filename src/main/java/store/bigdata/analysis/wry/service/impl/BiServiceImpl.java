package store.bigdata.analysis.wry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.bigdata.analysis.wry.mapper.BiMapper;
import store.bigdata.analysis.wry.pojo.BiPojo;
import store.bigdata.analysis.wry.service.BiService;
@Service
public class BiServiceImpl implements BiService {
	@Autowired 
	BiMapper biMapper;
	public List<BiPojo> findlist() {
		if(biMapper.findlist()==null)	
			System.out.println("查询为空");
		 
			return biMapper.findlist();
	}
	public List<BiPojo>  findlistgroupbydatseq(){
		if(biMapper.findlist()==null)	
			System.out.println("查询为空");
		 
			return biMapper.findlistgroupbydatseq();
	}

}
