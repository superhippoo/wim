package com.wim.dao;

import java.util.List;

import com.wim.dto.UserVo;

public interface UserDao {
	public List<UserVo> selectUserList();
	
	public UserVo selectuser(UserVo uservo);
	
	public int insertUser(UserVo uservo);
	
	public int updateUser(UserVo uservo);

	public int deleteUser(UserVo uservo);
	
	public int isExistByKakaoEmail(UserVo uservo);
	
	public UserVo login(UserVo uservo);


}
