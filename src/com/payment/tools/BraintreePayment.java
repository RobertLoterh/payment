package com.payment.tools;

import java.math.BigDecimal;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Environment;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;
import com.braintreegateway.ValidationError;

public class BraintreePayment implements Payment{
	
	public  String pay(int amount,int exp_month,int exp_year,String cardNumber){
		
		BraintreeGateway gateway = new BraintreeGateway(
	            Environment.SANDBOX,
	            "f7dmnvgr9pkff6x5",
	            "b6373bxvmfrh7zrv",
	            "4e492c4d135c71d91385956dab70b863"
	        );
		
		TransactionRequest request = new TransactionRequest()
	    .amount(new BigDecimal(new Integer(amount).toString()))
	    .creditCard()
	      .number(cardNumber)
	      .expirationMonth(new Integer(exp_month).toString())
	      .expirationYear(new Integer(exp_year).toString())
	      .done();

	Result<Transaction> result = gateway.transaction().sale(request);
    String value="";
	if (result.isSuccess()) {
	    Transaction transaction = result.getTarget();
	    System.out.println("Success!: " + transaction.getId());
	    value="success";
	} else if (result.getTransaction() != null) {
	    System.out.println("Message: " + result.getMessage());
	    Transaction transaction = result.getTransaction();
	    System.out.println("Error processing transaction:");
	    System.out.println("  Status: " + transaction.getStatus());
	    System.out.println("  Code: " + transaction.getProcessorResponseCode());
	    System.out.println("  Text: " + transaction.getProcessorResponseText());
	    value="failed"+result.getMessage();
	} else {
	    System.out.println("Message: " + result.getMessage());
	    for (ValidationError error : result.getErrors().getAllDeepValidationErrors()) {
	        System.out.println("Attribute: " + error.getAttribute());
	        System.out.println("  Code: " + error.getCode());
	        System.out.println("  Message: " + error.getMessage());
	        
	    }
	    
	    value="failed"+result.getMessage();
	}
	    
	return value;
	}
	
	

	
}
