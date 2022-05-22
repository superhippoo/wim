package com.wim.svc;

import java.util.List;
import java.util.Optional;

import com.wim.Entity.UserEntity;
import com.wim.dto.UserVo;

public interface UserSvc {

	public List<UserVo> selectUserList();
	
	public List<UserEntity> selectUserListJPA();
	
	public UserVo selectuser(String userId);

	public Optional<UserEntity> selectuserJPA(String userId);
	
	public int insertUser(UserVo uservo);

	public UserEntity insertUserJPA(UserEntity user);

	public int updateUser(UserVo uservo);

	public UserEntity updateUserJPA(UserEntity user);
	
	public int deleteUser(UserVo uservo);

	public void deleteUserJPA(String userId);
	
	public UserVo login(UserVo uservo);



}
