package store.eazychina.wtx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.eazychina.wtx.mapper.BiMapper;
import store.eazychina.wtx.pojo.BiPojo;
import store.eazychina.wtx.service.BiService;
@Service
public class BiServiceImpl implements BiService {
	@Autowired 
	BiMapper biMapper;
	@Override
	public List<BiPojo> findlist() {
		if(biMapper.findlist()==null)	
			System.out.println("查询为空");
		 
			return biMapper.findlist();
	}

}
