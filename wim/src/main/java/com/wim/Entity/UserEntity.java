package com.wim.Entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wim_user")
public class UserEntity {

	@Id
	@Column
	private String user_id;
	@Column
	private String user_nickname;

	@Column(name = "kakao_email")
	private String kakaEmail;

	@Column
	private int use_storage_num;
	@Column
	private String act_yn;
	@Column
	private String admin_yn;
	@Column
	private Timestamp reg_dt;
	@Column
	private Timestamp mdfy_dt;

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

	public String getKakaEmail() {
		return kakaEmail;
	}

	public void setKakaEmail(String kakaEmail) {
		this.kakaEmail = kakaEmail;
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

	@Override
	public String toString() {
		return "UserEntity [user_id=" + user_id + ", user_nickname=" + user_nickname + ", kakaEmail=" + kakaEmail
				+ ", use_storage_num=" + use_storage_num + ", act_yn=" + act_yn + ", admin_yn=" + admin_yn + ", reg_dt="
				+ reg_dt + ", mdfy_dt=" + mdfy_dt + "]";
	}
}
