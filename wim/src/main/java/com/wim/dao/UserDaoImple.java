package com.wim.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wim.dto.UserVo;

@Repository
public class UserDaoImple implements UserDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<UserVo> selectUserList() {

		StringBuffer sql = new StringBuffer();
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from wim_user ");

		RowMapper<UserVo> mapper = new BeanPropertyRowMapper<UserVo>(UserVo.class);
		return namedParameterJdbcTemplate.query(sql.toString(), mapper);
	}

}
