package com.payment.backingBeans;

import java.util.List;
import java.util.ArrayList;





import com.payment.tools.BraintreePayment;
import com.payment.tools.StripePayment;
import com.payment.vo.*;
import com.payment.DButils.DBconnection;
import com.payment.dao.InvoiceDao;
import com.payment.dao.UserDao;

public class MainBackingBean {
	
	private List<Invoice> invoices ;
	private List<Gateway> gateways;
	private User connectedUser ;
	private Invoice invoice;
	private boolean connected;
	private int id;
	
	
	static { new DBconnection("payment","sa","").createTables();
	        System.out.println("DATABASE READY");
	}
	
	public MainBackingBean(){
		
		getAllInvoices();
		gateways = new ArrayList<Gateway>();
		connectedUser = new User();
		connected=false;
		invoice = new Invoice();
		connectedUser = new User();
		
	}

	public String disconnect(){
		getAllInvoices();
		gateways = new ArrayList<Gateway>();
		connectedUser = new User();
		connected=false;
		invoice = new Invoice();
		return null;
	}
	
	public String createUser(){
		
		
		new UserDao().insertUser(connectedUser);
		connection();
		getAllInvoices();
		return "back";
	}
	
	public String signUp(){
		
		return "signUp";
	}
		
    public String back(){
		
		return "back";
	}
			
	public String connection(){
		getAllInvoices();
		gateways = new ArrayList<Gateway>();
		connected=true;
		invoice = new Invoice();
		return null;
	}
	
    public String  insertInvoice(){
    	connectedUser= new User();
    	connectedUser.setMail_id("user@mail.com");
    	connectedUser.setPassword("password");
    	new UserDao().insertUser(connectedUser);
    	
    	
    	invoice.setState("DRAFT");
    	invoice.setUser_id(1);
    	new InvoiceDao().insertInvoice(invoice);
    	
    	getAllInvoices();
    	//invoice = new Invoice();
    	return null;
    } 
		   
    public void getAllInvoices(){
		if(!connected)
		   invoices= new InvoiceDao().getAllInvoices();
		else
			invoices = new InvoiceDao().getAllInvoices();
		
		System.out.println(invoices.size());
	}
       
	public String edit(){
		//System.out.println(id);
		return null;
	}

    public String delete(){
    	//System.out.println(id);
		return null;
	}

    public String pay(){
    	System.out.println("Braintree "+new BraintreePayment().pay(200, 11, 2015, "4242424242424242"));
    	//System.out.println(id);
	   return null;
   }
    
    
    
    
    
    
 // GETTERS  AND SETTERS   
    
    public List<Invoice> getInvoices() {
		return invoices;
	}
	
	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public List<Gateway> getGateways() {
		return gateways;
	}

	public void setGateways(List<Gateway> gateways) {
		this.gateways = gateways;
	}

	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	
    public int getId() {
		return id;
	}

	
    public void setId(int id) {
		this.id = id;
	}

	
   
	
	
}
