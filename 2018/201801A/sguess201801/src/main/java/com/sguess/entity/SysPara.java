package com.sguess.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SysPara implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String sessionId;

	@Column
	private String token;

	public SysPara() {
		super();
	}

	public SysPara(String sessionId, String token) {
		super();
		this.sessionId = sessionId;
		this.token = token;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
