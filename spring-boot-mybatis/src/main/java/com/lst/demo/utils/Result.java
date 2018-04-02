package com.lst.demo.utils;


import java.io.Serializable;

public class Result<E> implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -8872966587737849450L;

	public int code;

	public String msg;

	public E data;

	public  Result() {
		this.code = 200;
		this.msg = "";
	}

	public Result(E e) {
		this.code = 200;
		this.msg = "";
		this.data = e;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Result<E> error(int code, String errorMsg) {
		this.code = code;
		this.msg = errorMsg;
		return this;
	}

	public Result<E> success(String msg) {
		this.code =200;
		this.msg = msg;
		return this;
	}



	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}



}
