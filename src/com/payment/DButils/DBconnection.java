package com.payment.DButils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.payment.queries.QueryConstant;



public class DBconnection implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private String user;
	private String password;
	private String dbname;
	private static final String driver="org.hsqldb.jdbcDriver";
	
	
	
	
	
	
	
	public DBconnection(String dbname,String user,String password){
		this.user = user;
		this.password=password;
		this.dbname=dbname;
	}
	
	
	
	public void openConnection(){
		
		try{Class.forName(driver);}		
	    catch(Exception e){System.out.println("DRIVER PATH ERROR");}
		
		
		try{
		    this.connection = DriverManager.getConnection("jdbc:hsqldb:mem:"+dbname,user,password);
		    System.out.println("CONNECTED");	    
	       }
        catch(Exception e){System.out.println("CONNECTION FAILED");}
	   
	}
	
	
	public void createTables(){
		
		try{
		   openConnection();
		   Statement statement = connection.createStatement() ;
		   statement.executeUpdate(QueryConstant.createTables.toString());
		   closeConnection();
		   System.out.println("TABLES CREATION COMPLETED ");
		   }
		catch(Exception e){
			System.out.println("TABLES CREATION FAILED: "+e.getMessage());
		}
		
	}
	
	
	
	
	public void closeConnection(){
		
		if(this.connection!=null) {
			
			try{
				connection.close();
				}
			catch(Exception e){}
			
		}
		else{this.connection=null;}
		
	}
	
	
	
	
	
	
	
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	
	
	
	
	

}
