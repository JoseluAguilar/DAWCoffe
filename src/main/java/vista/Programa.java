/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;

/**
 *
 * @author joselu
 */
public class Programa {
    //Según el modelo Vista / Controlador, debemos tener algunas clases para la vista, 
    //y otras para la lógica del programa. 

    //Considerando esto, las clases programa e interfaz deben estar en un paquete vista, 
    //mientras que el resto de clases, en un paquete controlador
    public static void main(String[] args) {
        System.out.println("Bienvenido a la cafetera, por Jose Luís y Carlos");
        while(true){
            menuRaiz();
        }
        
    }
    public static int menuRaiz(){
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce la bebida que quieres tomar: ");
        return lector.nextInt();
    }
}
