package com.payment.tools;

import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

public class StripePayment implements Payment{
	
	
	public  String pay(int amount,int exp_month,int exp_year,String cardNumber){
		
		Stripe.apiKey = "sk_test_XshUuuCon85hTERV68N5lrGz";
        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", amount);
        chargeMap.put("currency", "usd");
        Map<String, Object> cardMap = new HashMap<String, Object>();
        cardMap.put("number", cardNumber);
        cardMap.put("exp_month", exp_month);
        cardMap.put("exp_year", exp_year);
        chargeMap.put("card", cardMap);
        String value="";
        try {
            Charge charge = Charge.create(chargeMap);
            System.out.println(charge);
            value= "success";
        } catch (StripeException e) {
        	System.out.println("Transaction failed: "+e.getMessage());
        	value= "failed:"+e.getMessage();
            
        }
        
        return value;
	}

}
