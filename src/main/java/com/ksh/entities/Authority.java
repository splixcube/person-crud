package com.ksh.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHORITIES")
public class Authority implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "AUTHORITY")
	private String authority;
	@ManyToOne
	@JoinColumn(name = "USERNAME")
	private User user;

	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
