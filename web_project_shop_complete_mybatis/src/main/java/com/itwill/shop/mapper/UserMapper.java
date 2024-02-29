package com.itwill.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.shop.user.User;

public interface UserMapper {

	@Insert("insert into userinfo(userid,password,name,email) values(#{userId},#{password},#{name},#{email})")
	public int insert(User user);

	@Update("update  userinfo set password=#{password},name=#{name},email=#{email} where userid=#{userId}")
	public int update(User user);

	@Delete("delete userinfo where userid=#{userId}")
	public int delete(String userId) throws Exception;

	@Select("select userid,password,name,email from userinfo where userid=#{userId}")
	public User findUser(@Param("userId") String userId);

	@Select("select userid,password,name,email from userinfo")
	public List<User> findUserList();

	@Select("select count(*) cnt from userinfo where userid=#{userId}")
	int countByUserId(@Param("userId") String userId) throws Exception;

}