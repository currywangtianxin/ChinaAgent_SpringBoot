package store.eazychina.wtx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.eazychina.wtx.mapper.IPMapper;
import store.eazychina.wtx.pojo.IpPojo;
import store.eazychina.wtx.service.IPService;
@Service
public class IPServiceImpl implements IPService {
	@Autowired
	IPMapper ipDao;
	@Override
	public List<IpPojo> getList() {
		return ipDao.loadBySql();
	}
}
