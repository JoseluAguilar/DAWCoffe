/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;
import java.util.Arrays;
import controlador.*;

/**
 *
 * @author joselu
 */
public class Programa {
    //Según el modelo Vista / Controlador, debemos tener algunas clases para la vista, 
    //y otras para la lógica del programa. 

    //Considerando esto, las clases programa e interfaz deben estar en un paquete vista, 
    //mientras que el resto de clases, en un paquete controlador
    private static int[] valoresBebida = new int[11];

    public static void main(String[] args) {
        System.out.println("Bienvenido a la cafetera, por Jose Luís y Carlos");
        int seleccionMenu;
        cargarBebidas();
        while (true) {
            seleccionMenu = menuRaiz();

        }

    }

    public static int menuRaiz() {
        Scanner lector = new Scanner(System.in);
        int seleccion;
        boolean existe = false;
        do {
            System.out.println("Introduce la bebida que quieres tomar: ");
            seleccion = lector.nextInt();
            if(existeEnArray(seleccion)){
                existe = true;
            }
            else{
                System.out.println("El número introducido no pertenece a ninguna bebida, por favor, introduce otro");
            }
        } while (!(existe));
        return seleccion;

    }

    public static void cargarBebidas() {
        int codBebida = 1000;
        for (int i = 0; i < valoresBebida.length; i++) {
            codBebida++;
            valoresBebida[i] = codBebida;
        }
    }
    public static boolean existeEnArray(int num){
        for (int i = 0; i < valoresBebida.length; i++) {
            if(num == valoresBebida[i]){
                return true;
            }
        }
        return false;
    }
}
