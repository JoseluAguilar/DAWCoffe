/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author joselu
 */
public class Interfaz {

    private static Cafetera cafe = new Cafetera();

    private static int[] valoresBebida = new int[11];

    public static void menuRaiz() {
        //Este método, que tendremos que rellenar más adelante, lo usamos para preguntar la bebida a tomar

        Scanner lector = new Scanner(System.in);
        int seleccion = 0, azucar = 0;
        boolean existe = false;
        double dinero = 0;
        Bebida seleccionada = null;
        cargarBebidas();
        do {

            System.out.print("Introduce la bebida que quieres tomar: ");
            seleccion = lector.nextInt();

            if (seleccion == 99999) {
                inicioSesion(); //Esto devuelve un boolean, tenemos que hacer una comparación, y si devuelve true,
                //Si devuelve true, que se vaya a las opciones de administración, si no, que pida de nuevo la bebida
                continue; //Esto provoca que cuando salga de la consola de administración, no saque por pantalla que la bebida no existe
            }
            //Preguntamos si el código de bebida existe. Si existe, lo devolverá para operar con él
            //en el método main
            if (existeEnArray(seleccion)) {
                existe = true;
            } else {
                System.out.println("El número introducido no pertenece a ninguna bebida, por favor, introduce otro");
            }
        } while (!(existe));
        switch (seleccion) {
            case 1001:
                seleccionada = Bebida.LECHE_FRIA;
                break;
            case 1002:
                seleccionada = Bebida.LECHE_CALIENTE;
                break;
            case 1003:
                seleccionada = Bebida.CAFE_SOLO;
                break;
            case 1004:
                seleccionada = Bebida.CAFE_SOLO_DES;
                break;
            case 1005:
                seleccionada = Bebida.SOLO_LARGO;
                break;
            case 1006:
                seleccionada = Bebida.SOLO_LARGO_DES;
                break;
            case 1007:
                seleccionada = Bebida.CAFE_CON_LECHE;
                break;
            case 1008:
                seleccionada = Bebida.CAFE_CON_LECHE_DES;
                break;
            case 1009:
                seleccionada = Bebida.CORTADO;
                break;
            case 1010:
                seleccionada = Bebida.CORTADO_DES;
                break;
            case 1011:
                seleccionada = Bebida.CHOCOLATE;
                break;

        }
        azucar=azucar();
        do {
            System.out.println("La bebida " + seleccionada.getNombre() + " cuesta " + seleccionada.getPrecio() + "€");
            System.out.println("Has pagado " + dinero + "€ por ahora");
            System.out.print("Introduzca su dinero: ");
            dinero += lector.nextDouble();
        } while (!(cafe.compraBebida(dinero, seleccionada, azucar )));

        if (dinero > seleccionada.getPrecio()) {
            System.out.println("Tome sus " + (dinero - seleccionada.getPrecio()) + "€ de cambio");
        }
        
        System.out.println("Preparando su " + seleccionada.getNombre() + "...");
        delay();
        System.out.println("¡Gracias por su compra! Vuelva pronto\n");

    }
    public static int azucar(){
        Scanner lector = new Scanner(System.in);
        System.out.println("0. Sin azúcar");
        System.out.println("1. Un poco de azúcar");
        System.out.println("2. Mucho azúcar");
        System.out.print("¿Cuánto azucar deseas en tu bebida?: ");
        return lector.nextInt();
    }

    public static void consolaAdministrador(){
        
    }
    
    public static void delay() {
        try {
            System.out.print("-*-");
            for (int i = 8; i > 0; i--) {
                System.out.print("*-");
                Thread.sleep(1000);
            }
            System.out.println("");//Añade un salto de línea
        } catch (InterruptedException ie) {
            System.out.println("Gracias por su compra, vuelva pronto");
        }
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

    private static boolean inicioSesion() {
        //Creamos un método de inicio de sesión, en el cual, si se cumplen las condiciones del método, devolverá true y por tanto, podremos administrar la cafetera
        Random r = new Random();
        Scanner lector = new Scanner(System.in);
        int key;
        int code;
        System.out.println("Bienvenido a la consola de administración.");
        System.out.print("Introduzca el pendrive de administrador, e introduzca el código que verá a continuación: ");
        key = r.nextInt(9999) + 1;//Generamos un código
        System.out.printf("%04d", key); //Mostramos el código
        System.out.print("\n>");
        code = lector.nextInt();//Pedimos que el usuario introduzca un número, en este caso, que sea igual al código
        if (code == key) {
            return true; //Si el código coincide, devolverá verdadero. Podremos continuar con el inicio de sesión
        } else {
            return false; //Si no, devolverá falso
        }
    }
}
