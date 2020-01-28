/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;
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
    public static int[] valoresBebida = new int[11];

    public static void main(String[] args) {
        System.out.println("Bienvenido a la cafetera, por Jose Luís y Carlos");
        int seleccionMenu;
        cargarBebidas();
        while (true) {
            //TODO tenemos que poner aquí los códigos de bebida, así como poner el precio. Podemos hacerlo con un 
            //toString en la clase Bebida
            seleccionMenu = menuRaiz(); //Esto lo arreglaremos más adelante, lo dejamos así por ahora

        }

    }

    public static int menuRaiz() {
        //Este método, que tendremos que rellenar más adelante, lo usamos para preguntar la bebida a tomar
        Scanner lector = new Scanner(System.in);
        int seleccion;
        boolean existe = false;
        do {
            System.out.println("Introduce la bebida que quieres tomar: ");
            seleccion = lector.nextInt();
            //Preguntamos si el código de bebida existe. Si existe, lo devolverá para operar con él
            //en el método main
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
        //Creamos este método para cargar los códigos de bebidas en un array
        int codBebida = 1000;
        for (int i = 0; i < valoresBebida.length; i++) {
            codBebida++;
            valoresBebida[i] = codBebida;
        }
    }
    public static boolean existeEnArray(int num){
        //Este método busca y pregunta si un valor existe o no en un array
        for (int i = 0; i < valoresBebida.length; i++) {
            if(num == valoresBebida[i]){
                return true;
            }
        }
        return false;
    }
}
