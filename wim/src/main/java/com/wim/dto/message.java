package com.wim.dto;

import com.wim.enums.statusEnum;

public class message {

	private int status;
	private String returnmessage;
	private Object data;
	private String totalcount;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getReturnmessage() {
		return returnmessage;
	}

	public void setReturnmessage(String returnmessage) {
		this.returnmessage = returnmessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(String totalcount) {
		this.totalcount = totalcount;
	}

	public message() {
		this.status = statusEnum.BAD_REQUEST.getStatusCode();
		this.returnmessage = null;
		this.data = null;
		this.totalcount = null;
	}

}
