package com.platzzi.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author dvchinx
 */
public class MensajesService {
    private static final Scanner sc = new Scanner(System.in);
    
    public static void crearMensaje(){
        System.out.println("Ingresa tu mensjae:");
        String mensaje = sc.nextLine();
        System.out.println("Ingresa tu nombre:");
        String nombre = sc.nextLine();
        
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        
        MensajesDAO.crearMensajeDB(registro);
    }
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
    }
    
    public static void borrarMensaje(){
        System.out.println("Ingreas el ID del Mensaje a Borrar:");
        
        MensajesDAO.borrarMensajeDB(sc.nextInt());
    }
    
    public static void editarMensaje(){
        System.out.println("Ingresa el Nuevo Mensaje:");
        String mensaje = sc.nextLine();
        System.out.println("Ingresa el ID del Mensaje a Editar:");
        int id_mensaje = sc.nextInt();
        
        Mensajes act = new Mensajes();
        act.setId_mensaje(id_mensaje);
        act.setMensaje(mensaje);
        
        MensajesDAO.actualizarMensajeDB(act);
    }
}
