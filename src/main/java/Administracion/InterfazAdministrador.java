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
import controlador.Deposito;
public class InterfazAdministrador {
    
    //Aquí vamos a hacer unos cuanto métodos que necesitamos de Administrador
    Deposito auxDeposito = new Deposito();
    public String contadores(){
        return auxDeposito.toString();
    }
    
    public void Rellenar(){
        auxDeposito.rellenarCafetera();
    }
}
