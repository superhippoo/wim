package com.wim.svc;

import java.util.List;

import com.wim.dto.UserVo;

public interface UserSvc {

	public List<UserVo> selectUserList(UserVo uservo);

}
