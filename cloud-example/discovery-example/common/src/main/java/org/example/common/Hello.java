package org.example.common;

import java.io.Serializable;

/**
 * @author smq
 */

public class Hello implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String msg;
	private String date;

	public Hello(Long id, String msg, String date) {
		this.id = id;
		this.msg = msg;
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override public String toString() {
		return "Hello{" +
				"id=" + id +
				", msg='" + msg + '\'' +
				", date='" + date + '\'' +
				'}';
	}
}
