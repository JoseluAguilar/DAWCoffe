/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.*;
import java.util.InputMismatchException;
import Administracion.*;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author joselu
 */
public class Interfaz {
    
    //Crea los depósitos
    private Deposito cafeSolo = new Deposito(1001, "Café", 1000, 1000, 100);
    private Deposito cafeDescafeinado = new Deposito(1002, "Café descafeinado", 1000, 1000, 100);
    private Deposito leche = new Deposito(1003, "leche", 1000, 1000, 100);
    private Deposito agua = new Deposito(1004, "agua", 1000, 1000, 100);
    private Deposito chocolate = new Deposito(1005, "chocholate", 1000, 1000, 100);
    private Deposito azucar = new Deposito(0, "azucar", 1000, 1000, 100);

    private Cafetera cafe = new Cafetera(cafeSolo, cafeDescafeinado, leche, agua, chocolate, azucar);

    private static InterfazAdministrador admin = new InterfazAdministrador();
    private static int[] valoresBebida = new int[11];

    public Interfaz() {
    }
    
    
    public void menuRaiz() {
        //Este método, que tendremos que rellenar más adelante, lo usamos para preguntar la bebida a tomar

        Scanner lector = new Scanner(System.in);
        int seleccion = 0, cantidadAzucar = 0;
        boolean existe = false;
        double dinero = 0;
        Bebida seleccionada = null;
        cargarBebidas();
        try {
            do {
                System.out.println("Hola bienvenido a la cafetera de Joselu y Carlos\n"
                        + "El menú para bebida es:\n"
                        + "1001 -- Leche fria - Precio: 0,5€\n"
                        + "1002 -- Leche caliente - Precio: 0,5€\n"
                        + "1003 -- Café solo - Precio: 0,8€\n"
                        + "1004 -- Café solo descafeinado - Precio:0,8€\n"
                        + "1005 -- Café solo largo - Precio: 0,9\n"
                        + "1006 -- Café solo largo - Precio: 0,9\n"
                        + "1007 -- Café con leche - Precio: 1,1€\n"
                        + "1008 -- Café con leche descafeinado - Precio: 1,1€\n"
                        + "1009 -- Café cortado - Precio: 1€\n"
                        + "1010 -- Café cortado descafeinado - Precio: 1€\n"
                        + "1011 -- Chocolate caliente - Precio: 1€");
                System.out.print("Introduce la bebida que quieres tomar: ");
                seleccion = lector.nextInt();

                if (seleccion == 99999) {
                    if (inicioSesion()) {
                        //Esto devuelve un boolean, tenemos que hacer una comparación, y si devuelve true,
                        //Si devuelve true, que se vaya a las opciones de administración, si no, que pida de nuevo la bebida
                        consolaAdministrador();
                        continue; //Esto provoca que cuando salga de la consola de administración, no saque por pantalla que la bebida no existe
                    } else {
                        System.out.println("Las credenciales son incorrectas, inténtelo más tarde");
                        continue;
                    }
                }
                //Preguntamos si el código de bebida existe. Si existe, lo devolverá para operar con él
                //en el método main
                if (existeEnArray(seleccion)) {
                    existe = true;
                } else {
                    System.out.println("El número introducido no pertenece a ninguna bebida, por favor, introduce otro");

                }

            } while (!(existe));
        } catch (InputMismatchException ime) {
            System.out.println("Ha introducido algo que mi sistema no es capaz de gestionar pi pi pi ");
            menuRaiz();
        }
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

        try {
            cantidadAzucar = azucar();
        } catch (InputMismatchException ime) {
            System.out.println("La cantidad de azucar seleccionada no es la correcta");
        }

        do {
            System.out.println("La bebida " + seleccionada.getNombre() + " cuesta " + seleccionada.getPrecio() + "€");
            System.out.println("Has pagado " + dinero + "€ por ahora");
            System.out.print("Introduzca su dinero: ");
            dinero += lector.nextDouble();
        } while(!(cafe.compraBebida(dinero, seleccionada, cantidadAzucar)));

        if (dinero > seleccionada.getPrecio()) {
            System.out.println("Tome sus " + (dinero - seleccionada.getPrecio()) + "€ de cambio");
        }

        System.out.println("Preparando su " + seleccionada.getNombre() + "...");
        delay();
        System.out.println("¡Gracias por su compra! Vuelva pronto\n");

    }

    public static int azucar() {
        int seleccion = 0;

        Scanner lector = new Scanner(System.in);
        int aux;
        try {
            do {
                System.out.println("0. Sin azúcar");
                System.out.println("1. Un poco de azúcar");
                System.out.println("2. Mucho azúcar");
                System.out.print("¿Cuánto azucar deseas en tu bebida?: ");
                aux = lector.nextInt();
                if ((aux < 0 || aux >= 3)) {
                    System.out.println("Has introducido una cantidad de azúcar incorrecta");
                }
            } while ((aux < 0 || aux >= 3));
            return aux;
        } catch (InputMismatchException ime) {
            System.out.println("Introduce una número");
            azucar();
        }
        return 0;
    }

    public void consolaAdministrador() {
        Scanner lector = new Scanner(System.in);
        int seleccion;
        boolean salir = false;
        do {
            System.out.println("0. Apagar cafetera");
            System.out.println("1. Rellenar depósitos");
            System.out.println("2. Realizar labores de mantenimiento");
            System.out.println("3. Revisar si existen depósitos en reserva");
            System.out.println("4. Ver la cantidad de dinero recaudada");
            System.out.println("5. Ver los contadores de las bebidas");
            System.out.println("6. Salir");
            System.out.print("ADMIN>");
            seleccion = lector.nextInt();
            switch (seleccion + 1) {
                case 1:
                    System.out.println("Apagando la cafetera");
                    admin.apagar();
                    break;
                case 2:
                    admin.rellenarDeposito(cafeSolo);
                    admin.rellenarDeposito(leche);
                    admin.rellenarDeposito(cafeDescafeinado);
                    admin.rellenarDeposito(agua);
                    admin.rellenarDeposito(azucar);
                    admin.rellenarDeposito(chocolate);
                    System.out.println("Todos los depósitos rellenados con éxito");
                    break;
                case 3:
                    admin.revisar(cafeSolo, cafeDescafeinado, leche, chocolate, agua, azucar);
                    break;
                case 4:
                    System.out.println(admin.comprobarEstado(cafeSolo));
                    System.out.println(admin.comprobarEstado(cafeDescafeinado));
                    System.out.println(admin.comprobarEstado(leche));
                    System.out.println(admin.comprobarEstado(chocolate));
                    System.out.println(admin.comprobarEstado(agua));
                    System.out.println(admin.comprobarEstado(azucar));
                    break;
                case 5:
                    System.out.println("Se han recaudado " + admin.ganancias()+ "€");
                    break;
                case 6:
                    System.out.println(admin.contadores());
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
            }
        } while (!(salir));
    }

    public void delay() {
        try {
            System.out.print("-x-");
            for (int i = 8; i > 0; i--) {
                System.out.print("x-");
                Thread.sleep(1000);
            }
            System.out.println("");//Añade un salto de línea
        } catch (InterruptedException ie) {
            System.out.println("Gracias por su compra, vuelva pronto");
        }
    }

    public void cargarBebidas() {
        //Creamos este método para cargar los códigos de bebidas en un array
        int codBebida = 1000;
        for (int i = 0; i < valoresBebida.length; i++) {
            codBebida++;
            valoresBebida[i] = codBebida;
        }
    }

    public boolean existeEnArray(int num) {
        //Este método busca y pregunta si un valor existe o no en un array
        for (int i = 0; i < valoresBebida.length; i++) {
            if (num == valoresBebida[i]) {
                return true;
            }
        }
        return false;
    }

    private boolean inicioSesion() {
        //Creamos un método de inicio de sesión, en el cual, si se cumplen las condiciones del método, devolverá true y por tanto, podremos administrar la cafetera
        Random r = new Random();
        Scanner lector = new Scanner(System.in);
        int key;
        int code;
        System.out.println("Bienvenido a la consola de administración.");
        System.out.print("Introduzca el pendrive de administrador, e introduzca el código que verá a continuación: ");
        key = r.nextInt(9999) + 1;//Generamos un código
        System.out.printf("%04d", key); //Mostramos el código
        System.out.print("\nusr>");
        code = lector.nextInt();//Pedimos que el usuario introduzca un número, en este caso, que sea igual al código
        if (code == key) {
            return true; //Si el código coincide, devolverá verdadero. Podremos continuar con el inicio de sesión
        } else {
            return false; //Si no, devolverá falso
        }
    }
}
