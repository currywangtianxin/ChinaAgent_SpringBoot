package store.eazychina.wtx.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import store.eazychina.wtx.exception.SSMException;
import store.eazychina.wtx.pojo.User;



public interface IUserService {

	public List<User> list();

	public User login(User user) throws SSMException;
	
	public void register(User user) throws SSMException;
	
	public boolean forgetpassword(String email, HttpSession session);

	public void updateByEmail(User user) throws SSMException;

}
