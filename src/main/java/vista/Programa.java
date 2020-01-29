/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author joselu
 */
public class Programa {
    //Según el modelo Vista / Con100programa. 

    //Considerando esto, las clases programa e interfaz deben estar en un paquete vista, 
    //mientras que el resto de clases, en un paquete controlador
    public static void main(String[] args) {
        while (true) {
            Interfaz.menuRaiz();
        }

    }
}
