package com.payment.vo;

import java.io.Serializable;

public class Invoice  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String to_mail;
	private int value;
	private String state;
	private int invoice_id;
	private int user_id;
	
	
	public String getTo_mail() {
		return to_mail;
	}
	public void setTo_mail(String to_mail) {
		this.to_mail = to_mail;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	

}
