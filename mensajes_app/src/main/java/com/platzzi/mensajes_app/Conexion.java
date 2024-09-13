package com.platzzi.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dvchinx
 */
public class Conexion {
    
    public Connection get_connection(){
        Connection connection = null;
        
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "root", "");
            if(connection != null) System.out.println("Conexion exitosa. \n");
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Error.");
        }
        return connection;
    }
}
