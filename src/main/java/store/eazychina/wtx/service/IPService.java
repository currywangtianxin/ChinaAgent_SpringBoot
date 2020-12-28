package store.eazychina.wtx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.eazychina.wtx.pojo.IpPojo;


public interface IPService {
	
	public List<IpPojo> getList();

}
