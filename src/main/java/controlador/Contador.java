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
public class Contador {
    //Un contador para cada bebida 
    //Para controlar que piden los usuarios y en que se puede invertir
    //En mejoras para la cafetera

    private int totalLeche = 0;
    private int totalCafe = 0;
    private int totalCafeDescafeinado = 0;
    private int totalChocolate = 0;

    public int getTotalLeche() {
        return totalLeche;
    }

    public void setTotalLeche(int totalLeche) {
        if (totalLeche > 0) {
            this.totalLeche += totalLeche;
        } else {
            throw new IllegalArgumentException(" El contador de leche no puede ser negativo o 0");
        }

    }

    public int getTotalCafe() {
        return totalCafe;
    }

    public void setTotalCafe(int totalCafe) {
        if (totalCafe > 0) {
            this.totalCafe += totalCafe;
        } else {
            throw new IllegalArgumentException(" El contador de Cafe no puede ser negativo o 0");
        }
    }

    public int getTotalCafeDescafeinado() {
        return totalCafeDescafeinado;
    }

    public void setTotalCafeDescafeinado(int totalCafeDescafeinado) {
        if (totalCafeDescafeinado > 0) {
            this.totalCafeDescafeinado += totalCafeDescafeinado;
        } else {
            throw new IllegalArgumentException(" El contador de Cafe descafeinado no puede ser negativo o 0");
        }
    }

    public int getTotalChocolate() {
        return totalChocolate;
    }

    public void setTotalChocolate(int totalChocolate) {
        if (totalChocolate > 0) {
            this.totalChocolate += totalChocolate;
        } else {
            throw new IllegalArgumentException(" El contador de Cafe descafeinado no puede ser negativo o 0");
        }
    }

    @Override
    public String toString() {
        return "Contador de productos vendidos:\n"
                + "Leche fria o leche caliente: " + totalLeche + "\n"
                + "Cafes con cafeína: " + totalCafe + "\n"
                + "Cafes descafeinados: " + totalCafeDescafeinado + "\n"
                + "Chocolates" + totalChocolate;
    }

}
