/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eteptech.dao;

import com.eteptech.essentials.ConfigFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbContext {
    public static Connection con=null;
    public static String message="Connected";
    public static Connection con(ConfigFile c){ 
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection(""+c.getDbhost()+"/"+""+c.getDbname(),""+""+c.getDbuser(),""+""+c.getDbpsswsd());
            
        }catch(SQLException|ClassNotFoundException e){
            message=e.getMessage();
      
        }
        return con;
        
    }
}
