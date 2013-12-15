package com.payment.vo;

import java.io.Serializable;

public class Gateway implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int gateway_id;
	private String gateway_name;
	
	
	public int getGateway_id() {
		return gateway_id;
	}
	public void setGateway_id(int gateway_id) {
		this.gateway_id = gateway_id;
	}
	public String getGateway_name() {
		return gateway_name;
	}
	public void setGateway_name(String gateway_name) {
		this.gateway_name = gateway_name;
	}
	
	

}
