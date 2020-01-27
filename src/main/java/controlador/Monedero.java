/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author josel
 */
public class Monedero {

    //Clase establecida para almacenar el dinero 
    //Cada vez que la maquina inicie, esta tendra 50€ de cambio
    //No se permitirá un importe introducido que no podamos devolver cambio
    //Si se requiriese.
    private double dinero = 50.00;

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        if (dinero > 0) {
            this.dinero = dinero;
        } else {
            throw new IllegalArgumentException(" No se puede introducir al monedero ninguna cantidad negativa ");
        }

    }

}
