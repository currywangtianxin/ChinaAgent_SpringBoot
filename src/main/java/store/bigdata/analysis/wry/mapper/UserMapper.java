package store.bigdata.analysis.wry.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import store.bigdata.analysis.wry.pojo.User;


@Mapper
public interface UserMapper {
	public User loadByUsername(String username);

	public User loadByEmail(String email);

	public void updateByEmail(User user);
	
	public List<User> list();
	
	public void add(User user);
	
	public void delete(int id);
}
