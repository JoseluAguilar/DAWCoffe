/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CafeteraDaw;

/**
 *
 * @author joselu
 */
public class Deposito {
    private int codDeposito;
    private String contenidoDeposito;
    private int capacidadActual;
    private int capacidadMaxima;
    private int capacidadAviso;
    
    //Creamos constructor por defecto
    public Deposito(){
        
    }

    //Creamos un constructor parametrizado en el cual se indica la capacidad máxima y la capacidad de aviso es cuando llega a los 100g. 
    //Se inicia con 0g en el depósito
    public Deposito(int codDeposito, String contenidoDeposito, int capacidadMaxima) {
        this.codDeposito = codDeposito;
        this.contenidoDeposito = contenidoDeposito;
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadActual = 0;
        this.capacidadAviso = 100;
    }

    
    //Se crea un constructor parametrizado en el cual puedes ajustar todos los parámetros del depósito
    public Deposito(int codDeposito, String contenidoDeposito, int capacidadActual, int capacidadMaxima, int capacidadAviso) {
        this.codDeposito = codDeposito;
        this.contenidoDeposito = contenidoDeposito;
        this.capacidadActual = capacidadActual;
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadAviso = capacidadAviso;
    }
    
    //Ceamos método rellenar cafetera
    
    public void rellenarCafetera(int gramos){
        gramos = Math.abs(gramos); //Hacemos el valor absoluto de los gramos, puesto que no podemos rellenar con valores nulos
        
        if(gramos > this.capacidadMaxima){
            throw new IllegalArgumentException("No puedes rellenar una cafetera con más gramos que los que puede almacenar el depósito"); //Tira una excepción si nos pasamos llenando
        }
        else{
            this.setCapacidadActual(this.capacidadActual+gramos);//Rellenamos la cafetera con el valor pasado por parámetros
        }
    }
    public void rellenarCafetera(){
        this.setCapacidadActual(this.capacidadMaxima);//Rellenamos la cafetera a tope
    }
    public void dispensarBebida(){
        //Teniendo en cuenta que cada bebida quita 40g de cada elemento
        if(this.capacidadActual < 40){
            throw new IllegalAccessError("No se puede servir la bebida porque el depósito no tiene suficiente cantidad para ello");
        }
        else{
            this.capacidadActual-=40;
        }
    }
    
    //Métodos Getters y Setters

    public int getCodDeposito() {
        return codDeposito;
    }

    public void setCodDeposito(int codDeposito) {
        this.codDeposito = codDeposito;
    }

    public String getContenidoDeposito() {
        return contenidoDeposito;
    }

    public void setContenidoDeposito(String contenidoDeposito) {
        this.contenidoDeposito = contenidoDeposito;
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }

    private void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getCapacidadAviso() {
        return capacidadAviso;
    }

    public void setCapacidadAviso(int capacidadAviso) {
        this.capacidadAviso = capacidadAviso;
    }
    
    //Método toString

    @Override
    public String toString() {
        return ("El depósito con identificador " + this.codDeposito + ", que contiene " + this.contenidoDeposito + ", con capacidad máxima " 
                + this.capacidadMaxima + ", dispone de " + this.capacidadActual + "g de " + this.contenidoDeposito);
    }
    
    
    
    
}
