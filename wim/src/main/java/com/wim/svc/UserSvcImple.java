package com.wim.svc;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wim.Entity.UserEntity;
import com.wim.dao.UserDao;
import com.wim.dao.UserRepository;
import com.wim.dto.UserVo;

@Service
public class UserSvcImple implements UserSvc {

	@Autowired
	private UserDao userdao;

	@Autowired
	private UserRepository userrepository;

	@Override
	public List<UserVo> selectUserList() {
		return userdao.selectUserList();
	}

	@Override
	public List<UserEntity> selectUserListJPA() {
		return userrepository.findAll();
	}

	@Override
	public UserVo selectuser(UserVo uservo) {
		return userdao.selectuser(uservo);
	}

	@Override
	public Optional<UserEntity> selectuserJPA(String userId) {
		return userrepository.findById(userId);
	}

	@Override
	public int insertUser(UserVo uservo) {
		return userdao.insertUser(uservo);

	}

	@Override
	public UserEntity insertUserJPA(UserEntity user) {
		return userrepository.saveAndFlush(user);
	}

	@Override
	public int updateUser(UserVo uservo) {
		return userdao.updateUser(uservo);
	}

	@Override
	public UserEntity updateUserJPA(UserEntity user) {
		return userrepository.saveAndFlush(user);
	}

	@Override
	public int deleteUser(UserVo uservo) {
		return userdao.deleteUser(uservo);
	}

	@Override
	public void deleteUserJPA(String userId) {

		UserEntity user = new UserEntity();
		user.setUser_id(userId);
		userrepository.delete(user);

	}

}
