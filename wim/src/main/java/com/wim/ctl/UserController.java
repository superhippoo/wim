package com.wim.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wim.dto.UserVo;
import com.wim.svc.UserSvc;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserSvc usersvc;
	
	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public List<UserVo> selectUserList(){
		
		return usersvc.selectUserList();
		
	}
}
