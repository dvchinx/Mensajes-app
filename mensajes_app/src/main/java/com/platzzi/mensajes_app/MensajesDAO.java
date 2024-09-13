package com.platzzi.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dvchinx
 */
public class MensajesDAO {
    
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion dbConn = new Conexion();
        
        try (Connection conexion = dbConn.get_connection()){
            
            PreparedStatement pS = null;
            String query = "INSERT INTO `mensajes` (`mensaje`, `autor_mensaje`) VALUES (?, ?)";
            
            pS = conexion.prepareStatement(query);
            pS.setString(1, mensaje.getMensaje());
            pS.setString(2, mensaje.getAutor_mensaje());
            
            pS.executeUpdate();
            System.out.println("Mensaje Agregado Correctamente.");
            
        }catch (Exception e){
            System.out.println("Error.");
        }
    }
    
    public static void leerMensajesDB(){
        Conexion dbConn = new Conexion();
        PreparedStatement pS = null;
        ResultSet rS = null;
        
        try (Connection conexion = dbConn.get_connection()){
            
            String query = "SELECT * FROM mensajes";
            pS = conexion.prepareStatement(query);
            rS = pS.executeQuery();
            
            while(rS.next()){
                System.out.println("ID: "+ rS.getString("id_mensaje"));
                System.out.println("Mensaje: " + rS.getString("mensaje"));
                System.out.println("Autor: " + rS.getString("autor_mensaje"));
                System.out.println("Fecha: " + rS.getString("fecha_mensaje") + "\n");
            }
            
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error.");
        }
    }
    
    public static void borrarMensajeDB(int id_mensaje){
        Conexion dbConn = new Conexion();
        PreparedStatement pS = null;
        
        try (Connection conexion = dbConn.get_connection()){
            String query = "DELETE FROM `mensajes` WHERE `id_mensaje` = ?";
        
            pS = conexion.prepareStatement(query);
            pS.setInt(1, id_mensaje);
            pS.executeUpdate();
            
            System.out.println("Mensaje Eliminado Correctamente.");
            
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error.");
        }
    }
    
    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion dbConn = new Conexion();
        PreparedStatement pS = null;
        
        try (Connection conexion = dbConn.get_connection()){
            String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";

            pS = conexion.prepareStatement(query);
            pS.setString(1, mensaje.getMensaje());
            pS.setInt(2, mensaje.getId_mensaje());
            pS.executeUpdate();
            
            System.out.println("Mensaje Actualizado Correctamente.");
            
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error.");
        }
    }
}
