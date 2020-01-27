/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author carlos
 */
public class Cafetera {
    private Deposito cafe = new Deposito(1001, "Café", 1000, 0, 100);
    private Deposito cafeDescafeinado = new Deposito(1002, "Café descafeinado", 1000, 0, 100);
    private Deposito leche = new Deposito(1003, "leche", 1000, 0, 100);
    private Deposito agua = new Deposito(1004, "agua", 1000, 0, 100);
    private Deposito chocolate = new Deposito(1005, "chocholate", 1000, 0, 100);
    
    public Cafetera(){
        
    }
    
    
    
}
