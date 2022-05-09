package com.wim.ctl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;

import com.wim.Entity.UserEntity;
import com.wim.dto.UserVo;
import com.wim.svc.UserSvc;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserSvc usersvc;

	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public List<UserVo> selectUserList() {

		return usersvc.selectUserList();

	}

	@RequestMapping(value = "/userlistjpa", method = RequestMethod.GET)
	public List<UserEntity> selectUserListJPA() {

		return usersvc.selectUserListJPA();

	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public UserVo selectUser(@RequestParam("userId") String userId) {
		UserVo uservo = new UserVo();
		uservo.setUser_id(userId);

		return usersvc.selectuser(uservo);

	}

	@RequestMapping(value = "/userjpa", method = RequestMethod.GET)
	public Optional<UserEntity> selectUserJPA(@RequestParam("userId") String userId) {

		return usersvc.selectuserJPA(userId);

	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public int insertUser(@RequestBody UserVo uservo) {

		return usersvc.insertUser(uservo);

	}

	@RequestMapping(value = "/userjpa", method = RequestMethod.POST)
	public UserEntity insertUserJPA(@RequestBody UserVo uservo) {

		ModelMapper modelMapper = new ModelMapper();
		UserEntity user = modelMapper.map(uservo, UserEntity.class);
		return usersvc.insertUserJPA(user);

	}
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public int updateUser(@RequestBody UserVo uservo) {

		return usersvc.updateUser(uservo);

	}
	
	@RequestMapping(value = "/userjpa", method = RequestMethod.PUT)
	public UserEntity updateUserJPA(@RequestBody UserVo uservo) {

		ModelMapper modelMapper = new ModelMapper();
		UserEntity user = modelMapper.map(uservo, UserEntity.class);
		return usersvc.updateUserJPA(user);

	}
	
	@RequestMapping(value = "/user", method = RequestMethod.DELETE)
	public int deleteUser(@RequestParam("userId") String userId) {
		UserVo uservo = new UserVo();
		uservo.setUser_id(userId);

		return usersvc.deleteUser(uservo);

	}
	
	@RequestMapping(value = "/userjpa", method = RequestMethod.DELETE)
	public void deleteUserJPA(@RequestParam("userId") String userId) {

		usersvc.deleteUserJPA(userId);

	}

}
