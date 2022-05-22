package com.wim.svc;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wim.Entity.UserEntity;
import com.wim.dao.UserDao;
import com.wim.dao.UserRepository;
import com.wim.dto.UserVo;
import com.wim.util.uidUtil;

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
	public UserVo selectuser(String userId) {
		UserVo uservo = new UserVo();
		uservo.setUser_id(userId);

		return userdao.selectuser(uservo);
	}

	@Override
	public Optional<UserEntity> selectuserJPA(String userId) {
		return userrepository.findById(userId);
	}

	@Override
	public int insertUser(UserVo uservo) {
		// return code def
		// 1 = success, 2 = existuser, 0= fail
		if (userdao.isExistByKakaoEmail(uservo) != 0) {
			return 2;
		}
		uservo.setUser_id(uidUtil.generateUid("U"));
		uservo.setUse_storage_num(1);
		uservo.setAct_yn("Y");
		uservo.setAdmin_yn("N");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		uservo.setReg_dt(time);
		uservo.setMdfy_dt(time);

		return userdao.insertUser(uservo);

	}

	@Override
	public UserEntity insertUserJPA(UserEntity user) {
		System.out.println(user.getKakaEmail());
		Optional<UserEntity> tempuser = userrepository.findBykakaEmail(user.getKakaEmail());
		System.out.println(tempuser);
		if (tempuser.isPresent()) {
			return null;
		}
		user.setUser_id(uidUtil.generateUid("U"));
		user.setAct_yn("Y");
		user.setAdmin_yn("N");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		user.setReg_dt(time);
		user.setMdfy_dt(time);
		user.setUse_storage_num(1);

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

	@Override
	public UserVo login(UserVo uservo) {
		UserVo temp = new UserVo();
		temp = userdao.login(uservo);
		// 1. login success = "Y", 2. login fail = "N", 3. Sign up Required = "R", 4. inactive user = "I" 

		if (temp != null) {
			if ("Y".equals(temp.getAct_yn())) {
				temp.setLogin_status("Y");
			} else if ("N".equals(temp.getAct_yn())) {
				temp.setLogin_status("I");
			} else {
				temp.setLogin_status("N");
			}
		} else {
			temp = new UserVo();
			temp.setLogin_status("R");
		}

		return temp;
	}

}
