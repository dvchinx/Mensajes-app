package com.platzzi.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author dvchinx
 */
public class Inicio {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("-----------"
                    + "\nAplicacion de Mensajes"
                    + "\n1. Crear mensaje"
                    + "\n2. Listar mensajes"
                    + "\n3. Borrar mensaje"
                    + "\n4. Editar mensaje"
                    + "\n5. Salir");
            opcion = scan.nextInt();
            
            switch (opcion) {
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.borrarMensaje();
                    break;
                case 4:
                    MensajesService.editarMensaje();
                    break;
                default:
                    if(opcion != 5)
                    System.out.println("Elige una opcion del menu.");
                    break;
            }
            
        } while (opcion != 5);
        
    }
}
