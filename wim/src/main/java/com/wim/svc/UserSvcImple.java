package com.wim.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wim.dao.UserDao;
import com.wim.dto.UserVo;

@Service
public class UserSvcImple implements UserSvc{
	
	@Autowired
	private UserDao userdao;

	@Override
	public List<UserVo> selectUserList() {
		return userdao.selectUserList();
	}
	
}
