/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

/**
 *
 * @author carlos
 */
import controlador.Bebida;
import controlador.Cafetera;
import controlador.Deposito;

public class InterfazAdministrador {
    private int contadorCafe = Cafetera.getTotalCafe();
    private int contadorCafeConLeche = Cafetera.getTotalCafeConLeche();
    private int contadorCafeDescafeinado = Cafetera.getTotalCafeDescafeinado();
    private int contadorCafeDescafeinadoConLeche = Cafetera.getTotalCafeDescafeinadoConLeche();
    private int contadorChocolate = Cafetera.getTotalChocolate();
    private int contadorLeche = Cafetera.getTotalLeche();

    public String contadores() {

        return ("Se han servido: \n"
                + "" + contadorCafe + " cafés\n"
                + "" + contadorCafeConLeche + " cafés con leche\n"
                + "" + contadorCafeDescafeinado + " cafés descafeinados\n"
                + "" + contadorCafeDescafeinadoConLeche + " cafés descafeinados con leche\n"
                + "" + contadorLeche + " leches\n"
                + "" + contadorChocolate + " chocolates");
    }

    public void apagar() {
        System.exit(0);
    }

    public void rellenarTodosDepositos(Deposito dep) {
        dep.rellenarCafetera();
    }

    public String revisar(Deposito cafe, Deposito descafeinado, Deposito leche, Deposito chocolate, Deposito agua, Deposito azucar) {
        return ("El estado actual de los despositos es : \n"
                + "" + cafe.toString() + "\n"
                + "" + descafeinado.toString() + "\n"
                + "" + leche.toString() + "\n"
                + "" + chocolate.toString() + " \n"
                + "" + agua.toString() + " \n"
                + "" + azucar.toString());
    }
    public double ganancias(){
        return ((contadorCafe * Bebida.CAFE_SOLO.getPrecio())+(contadorCafeConLeche * Bebida.CAFE_CON_LECHE.getPrecio())+(contadorCafeDescafeinado * Bebida.CAFE_SOLO_DES.getPrecio())+(contadorCafeDescafeinadoConLeche*Bebida.CAFE_CON_LECHE_DES.getPrecio())+(contadorChocolate * Bebida.CHOCOLATE.getPrecio())+(contadorLeche*Bebida.LECHE_CALIENTE.getPrecio()));
    }

}
