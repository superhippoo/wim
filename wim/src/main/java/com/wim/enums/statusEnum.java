package com.wim.enums;

public enum statusEnum {

	OK(200), 
	BAD_REQUEST(400), 
	NOT_FOUND(404), 
	INTERNAL_SERVER_ERROR(500);

	int statusCode;

	statusEnum(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return this.statusCode;
	}

}
