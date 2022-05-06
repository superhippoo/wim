package com.wim.dao;

import java.util.List;

import com.wim.dto.UserVo;

public interface UserDao {
	public List<UserVo> selectUserList(UserVo uservo);
}
