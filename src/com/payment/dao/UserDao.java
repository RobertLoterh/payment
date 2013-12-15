package com.payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.payment.DButils.DBconnection;
import com.payment.queries.QueryConstant;
import com.payment.vo.User;

public class UserDao {
	
	public void insertUser(User user){
		DBconnection db = new DBconnection("payment","sa","");
		db.openConnection();
		Connection connection = db.getConnection();
				
		try{
			PreparedStatement ps = connection.prepareStatement(QueryConstant.insertUser.toString());
			ps.setString(1, user.getMail_id());
			ps.setString(2, user.getPassword());
			
			ps.executeUpdate();					
			
			ps.close();
			
		}
		catch(SQLException e){
			System.out.println("ERROR in UserDao --- insertUser: "+e.getMessage());
		}
		finally{
			db.closeConnection();
		}
		
	}

}
