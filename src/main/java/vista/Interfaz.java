/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Bebida;
import controlador.Cafetera;
import java.util.Random;
import java.util.Scanner;
import static vista.Programa.valoresBebida;

/**
 *
 * @author joselu
 */
public class Interfaz {

    private static Cafetera cafe = new Cafetera();

 

    public static int menuRaiz() {
        //Este método, que tendremos que rellenar más adelante, lo usamos para preguntar la bebida a tomar
        Scanner lector = new Scanner(System.in);
        int seleccion;
        boolean existe = false;
        do {
            System.out.println("Introduce la bebida que quieres tomar: ");
            seleccion = lector.nextInt();
            if (seleccion == 99999) {
                inicioSesion();

            }
            //Preguntamos si el código de bebida existe. Si existe, lo devolverá para operar con él
            //en el método main
            if (existeEnArray(seleccion)) {
                existe = true;
            } else {
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

    public static boolean existeEnArray(int num) {
        //Este método busca y pregunta si un valor existe o no en un array
        for (int i = 0; i < valoresBebida.length; i++) {
            if (num == valoresBebida[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean inicioSesion() {
        //Creamos un método de inicio de sesión, en el cual, si se cumplen las condiciones del método, devolverá true y por tanto, podremos administrar la cafetera
        Random r = new Random();
        Scanner lector = new Scanner(System.in);
        int key;
        int code;
        System.out.println("Bienvenido a la consola de administración.");
        System.out.print("Introduzca el pendrive de administrador, e introduzca el código que verá a continuación: ");
        key = r.nextInt(9999) + 1;//Generamos un código
        System.out.printf("%04d", key); //Mostramos el código
        System.out.print(">");
        code = lector.nextInt();//Pedimos que el usuario introduzca un número, en este caso, que sea igual al código
        if (code == key) {
            return true; //Si el código coincide, devolverá verdadero. Podremos continuar con el inicio de sesión
        } else {
            return false; //Si no, devolverá falso
        }
    }
}
