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

}
