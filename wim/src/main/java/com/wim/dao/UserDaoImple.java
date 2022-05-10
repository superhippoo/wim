package com.wim.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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

	@Override
	public UserVo selectuser(UserVo uservo) {
		StringBuffer sql = new StringBuffer();
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from wim_user ");
		sql.append("\n").append("where user_id = :user_id ");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(uservo);
		RowMapper<UserVo> mapper = new BeanPropertyRowMapper<UserVo>(UserVo.class);

		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, mapper);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertUser(UserVo uservo) {
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("INSERT INTO wim_user ");
		sql.append("\n").append("(user_id,user_nickname,kakao_email,use_storage_num,");
		sql.append("\n").append("act_yn,admin_yn,reg_dt,mdfy_dt) ");
		sql.append("\n").append("VALUES (:user_id,:user_nickname,:kakao_email,:use_storage_num,");
		sql.append("\n").append(":act_yn,:admin_yn,:reg_dt,:mdfy_dt)");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(uservo);

		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int updateUser(UserVo uservo) {
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("update wim_user set");
		sql.append("\n").append("user_nickname = :user_nickname , ");
		sql.append("\n").append("kakao_email = :kakao_email , ");
		sql.append("\n").append("use_storage_num = :use_storage_num , ");
		sql.append("\n").append("act_yn = :act_yn , ");
		sql.append("\n").append("admin_yn = :admin_yn , ");
		sql.append("\n").append("reg_dt = :reg_dt , ");
		sql.append("\n").append("mdfy_dt = :mdfy_dt");
		sql.append("\n").append("where user_id = :user_id");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(uservo);

		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int deleteUser(UserVo uservo) {
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("delete from wim_user");
		sql.append("\n").append("where user_id = :user_id");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(uservo);

		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int isExistByKakaoEmail(UserVo uservo) {
		StringBuffer sql = new StringBuffer();
		sql.append("\n").append("select ");
		sql.append("\n").append("count(*) ");
		sql.append("\n").append("from wim_user ");
		sql.append("\n").append("where kakao_email = :kakao_email ");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(uservo);

		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, Integer.class);
		} catch (Exception e) {
			return 0;
		}
	}

}
