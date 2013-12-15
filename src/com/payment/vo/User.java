package com.payment.vo;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String mail_id;
	private String password;
	
	
	
	
	
	
	public boolean equals(Object o){
		if(o instanceof User){
			
			String mail_id = ((User) o).getMail_id();
			
			if(mail_id.equals(this.mail_id)){
			     return true;
			}
			else{
				 return false;
			}
			
		}
		else{
			return true;
		}
		
	}
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
