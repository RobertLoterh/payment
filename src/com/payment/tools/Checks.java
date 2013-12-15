package com.payment.tools;

import org.springframework.security.crypto.bcrypt.*;

public class Checks {
	
	
	public static boolean is_valid_mail_id(String mail_id){
			
		return true;
	}
	
	
	
	public static boolean is_Strong_Password(String password){
		return true;
	}
	
	
	public static String encryptPassword(String password){
		return  BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	
	
   public static  boolean is_Valid_Password(String encPass, String rawPass)  {   
        return BCrypt.checkpw(rawPass, encPass);
    }

}
