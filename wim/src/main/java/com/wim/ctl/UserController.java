package com.wim.ctl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wim.Entity.UserEntity;
import com.wim.dao.UserRepository;
import com.wim.dto.UserVo;
import com.wim.dto.message;
import com.wim.enums.statusEnum;
import com.wim.svc.UserSvc;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserSvc usersvc;

	@Autowired
	private UserRepository userrepository;

	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public ResponseEntity<message> selectUserList() {
		message ms = new message();
		List<UserVo> resultvo = new ArrayList<UserVo>();
		resultvo = usersvc.selectUserList();
		ms.setData(resultvo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(resultvo.size()));
		ms.setReturnmessage("Success");
		if (resultvo.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "/userlistjpa", method = RequestMethod.GET)
	public ResponseEntity<message> selectUserListJPA() {

		message ms = new message();
		List<UserEntity> resultvo = new ArrayList<UserEntity>();
		resultvo = usersvc.selectUserListJPA();
		ms.setData(resultvo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setTotalcount(String.valueOf(resultvo.size()));
		ms.setReturnmessage("Success");
		if (resultvo.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<message> selectUser(@RequestParam("userId") String userId) {

		message ms = new message();
		UserVo resultVo = new UserVo();
		resultVo = usersvc.selectuser(userId);
		ms.setData(resultVo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setReturnmessage("Success");
		if (resultVo == null) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "/userjpa", method = RequestMethod.GET)
	public ResponseEntity<message> selectUserJPA(@RequestParam("userId") String userId) {
		message ms = new message();
		Optional<UserEntity> resultVo = usersvc.selectuserJPA(userId);
		ms.setData(resultVo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setReturnmessage("Success");
		if (resultVo == null) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<message> insertUser(@RequestBody UserVo uservo) {

		message ms = new message();

		int result = usersvc.insertUser(uservo);
		ms.setData(null);
		if (result == 1) {// success
			ms.setReturnmessage("Success");
			ms.setStatus(statusEnum.OK.getStatusCode());
		} else if (result == 2) {// existuser by kakaoemail
			ms.setReturnmessage("Exist User");
			ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
		} else {// fail
			ms.setReturnmessage("Fail");
			ms.setStatus(statusEnum.INTERNAL_SERVER_ERROR.getStatusCode());
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);

	}

	@RequestMapping(value = "/userjpa", method = RequestMethod.POST)
	public UserEntity insertUserJPA(@RequestBody UserVo uservo) {

		ModelMapper modelMapper = new ModelMapper();
		UserEntity user = modelMapper.map(uservo, UserEntity.class);
		user.setKakaEmail(uservo.getKakao_email());//jpa method용 파라미터명 변경
		
//		message ms = new message();
//		ms.setData(null);
//
//		if (usersvc.insertUserJPA(user) == null) {
//			ms.setReturnmessage("Exist User");
//			ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
//			
//		}else {
//			ms.setReturnmessage("Success");
//			ms.setStatus(statusEnum.OK.getStatusCode());
//		}
//		
//		return new ResponseEntity<message>(ms,HttpStatus.OK);
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

	@RequestMapping(value = "/testjpa", method = RequestMethod.POST)
	public Optional<UserEntity> testUserJPA(@RequestBody UserVo uservo) throws Exception {

		Optional<UserEntity> user = userrepository.findBykakaEmail(uservo.getKakao_email());
		
		return user;

	}

}
