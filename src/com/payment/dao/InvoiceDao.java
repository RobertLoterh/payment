package com.payment.dao;

import com.payment.vo.Invoice;
import com.payment.queries.QueryConstant;
import com.payment.DButils.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InvoiceDao {
	
	public ArrayList<Invoice> getAllInvoices(){
		DBconnection db = new DBconnection("payment","sa","");
		db.openConnection();
		Connection connection = db.getConnection();
		Invoice invoice = new Invoice();
		ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		try{
			PreparedStatement ps = connection.prepareStatement(QueryConstant.getAllInvoices.toString());
			ResultSet rs = ps.executeQuery();			
			while(rs.next()){
				invoice.setInvoice_id(rs.getInt(1));
				invoice.setUser_id(rs.getInt(2));
				invoice.setTo_mail(rs.getString(3));
				invoice.setValue(rs.getInt(4));
				invoice.setState(rs.getString(5));
				invoices.add(invoice);
				invoice = new Invoice();
			}
			rs.close();
			ps.close();
			
		}
		catch(SQLException e){
			System.out.println("ERROR in InvoiceDao --- getAllInvoices: "+e.getMessage());
		}
		finally{
			db.closeConnection();
		}
		
		return invoices;
	}

	
	public ArrayList<Invoice> getInvoicesByUser(int user_id){
		DBconnection db = new DBconnection("payment","sa","");
		db.openConnection();
		Connection connection = db.getConnection();
		Invoice invoice = new Invoice();
		ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		try{
			PreparedStatement ps = connection.prepareStatement(QueryConstant.getInvoicesByUser.toString());
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();			
			while(rs.next()){
				invoice.setInvoice_id(rs.getInt(1));
				invoice.setUser_id(rs.getInt(2));
				invoice.setTo_mail(rs.getString(3));
				invoice.setValue(rs.getInt(4));
				invoice.setState(rs.getString(5));
				invoices.add(invoice);
			}
			rs.close();
			ps.close();
			
		}
		catch(SQLException e){
			System.out.println("ERROR in InvoiceDao --- getInvoicesByUsers: "+e.getMessage());
		}
		finally{
			db.closeConnection();
		}
		
		return invoices;
	}
	
	public void insertInvoice(Invoice invoice){
		DBconnection db = new DBconnection("payment","sa","");
		db.openConnection();
		Connection connection = db.getConnection();
				
		try{
			PreparedStatement ps = connection.prepareStatement(QueryConstant.insertInvoice.toString());
			ps.setInt(1, invoice.getUser_id());
			ps.setString(2, invoice.getTo_mail());
			ps.setInt(3, invoice.getValue());
			ps.setString(4, invoice.getState());
			ps.executeUpdate();					
			
			ps.close();
			
		}
		catch(SQLException e){
			System.out.println("ERROR in InvoiceDao --- insertInvoice: "+e.getMessage());
		}
		finally{
			db.closeConnection();
		}
		
	}
	

}
