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
import controlador.Cafetera;
import controlador.Deposito;
public class InterfazAdministrador {
    
    //Aquí vamos a hacer unos cuanto métodos que necesitamos de Administrador
    private Deposito cafe = Cafetera.getCafe();
    private Deposito cafeDescafeinado = Cafetera.getCafeDescafeinado();
    private Deposito leche = Cafetera.getLeche();
    private Deposito agua = Cafetera.getAgua();
    private Deposito chocolate = Cafetera.getChocolate();
    private Deposito azucar = Cafetera.getAzucar();
    
    private int contadorCafe = Cafetera.getTotalCafe();
    private int contadorCafeConLeche = Cafetera.getTotalCafeConLeche();
    private int contadorCafeDescafeinado = Cafetera.getTotalCafeDescafeinado();
    private int contadorCafeDescafeinadoConLeche = Cafetera.getTotalCafeDescafeinadoConLeche();
    private int contadorChocolate = Cafetera.getTotalChocolate();
    private int contadorLeche = Cafetera.getTotalLeche();
    
    
    public String contadores(){
       
        
        return ("Se han servido: \n"
                + "" + contadorCafe + " cafés\n"
                + "" + contadorCafeConLeche + " cafés con leche\n"
                + "" + contadorCafeDescafeinado + " cafés descafeinados\n"
                + "" + contadorCafeDescafeinadoConLeche + " cafés descafeinados con leche\n"
                + "" + contadorLeche + " leches\n"
                + "" + contadorChocolate + " chocolates");
    }
    
    
    public void apagar(){
        System.exit(0);
    }
    
    public void rellenarTodosDepositos(){
        cafe.rellenarCafetera();
        cafeDescafeinado.rellenarCafetera();
        leche.rellenarCafetera();
        chocolate.rellenarCafetera();
        agua.rellenarCafetera();
        azucar.rellenarCafetera();
    }
    
    public String revisar(){
        return ("El estado actual de los despositos es : \n"
                + "" + cafe.toString()+ "\n"
                + "" + cafeDescafeinado.toString() + "\n"
                + "" + leche.toString() + "\n"
                + "" + chocolate.toString() + " \n"
                + "" + agua.toString() + " \n"
                + "" + azucar.toString());
    }
    
}
