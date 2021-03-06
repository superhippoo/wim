package com.wim.dto;

import java.sql.Timestamp;

public class UserVo {

	private String user_id;
	private String user_nickname;
	private String kakao_email;
	private int use_storage_num;
	private String act_yn;
	private String admin_yn;
	private Timestamp reg_dt;
	private Timestamp mdfy_dt;
	private String login_status;
	// Def login status
	// 1. login success = "Y", 2. login fail = "N", 3. Sign up Required = "R", 4. inactive user = "I" 

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getKakao_email() {
		return kakao_email;
	}

	public void setKakao_email(String kakao_email) {
		this.kakao_email = kakao_email;
	}

	public int getUse_storage_num() {
		return use_storage_num;
	}

	public void setUse_storage_num(int use_storage_num) {
		this.use_storage_num = use_storage_num;
	}

	public String getAct_yn() {
		return act_yn;
	}

	public void setAct_yn(String act_yn) {
		this.act_yn = act_yn;
	}

	public String getAdmin_yn() {
		return admin_yn;
	}

	public void setAdmin_yn(String admin_yn) {
		this.admin_yn = admin_yn;
	}

	public Timestamp getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Timestamp reg_dt) {
		this.reg_dt = reg_dt;
	}

	public Timestamp getMdfy_dt() {
		return mdfy_dt;
	}

	public void setMdfy_dt(Timestamp mdfy_dt) {
		this.mdfy_dt = mdfy_dt;
	}

	public String getLogin_status() {
		return login_status;
	}

	public void setLogin_status(String login_status) {
		this.login_status = login_status;
	}

	@Override
	public String toString() {
		return "UserVo [user_id=" + user_id + ", user_nickname=" + user_nickname + ", kakao_email=" + kakao_email
				+ ", use_storage_num=" + use_storage_num + ", act_yn=" + act_yn + ", admin_yn=" + admin_yn + ", reg_dt="
				+ reg_dt + ", mdfy_dt=" + mdfy_dt + ", login_status=" + login_status + "]";
	}

}
