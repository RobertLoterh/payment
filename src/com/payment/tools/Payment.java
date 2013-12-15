package com.payment.tools;

public interface Payment {
	
	public String pay(int amount,int exp_month,int exp_year,String cardNumber);

}
