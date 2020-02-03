/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.Interfaz;

/**
 *
 * @author carlos
 */
public class Cafetera {

    private Deposito cafe;
    private Deposito cafeDescafeinado;
    private Deposito leche;
    private Deposito agua;
    private Deposito chocolate;
    private Deposito azucar;

    private static int totalCafe = 0;
    private static int totalCafeDescafeinado = 0;
    private static int totalLeche = 0;
    private static int totalChocolate = 0;
    private static int totalCafeConLeche = 0;
    private static int totalCafeDescafeinadoConLeche = 0;


    public Cafetera(Deposito cafeSolo, Deposito cafeDescafeinado, Deposito leche, Deposito agua, Deposito chocolate, Deposito azucar) {
       this.cafe = cafeSolo;
       this.cafeDescafeinado = cafeDescafeinado;
       this.leche = leche;
       this.agua = agua;
       this.chocolate = chocolate;
       this.azucar = azucar;
    }

    public boolean compraBebida(double precio, Bebida bebida, int azucar) {
        if (precio >= bebida.getPrecio()) {
            this.dispensarBebida(bebida.getCodigo()); //Que dispense la bebida
            this.dispensarAzucar(azucar);
            return true; //Si devuelve verdadero, entonces que no pregunte más y que se vaya al menú principal
        } else {
            return false; //Que siga preguntando hasta que, o el usuario meta el precio, o se salga
        }
    }

    private void dispensarBebida(int codigo) {
        switch (codigo) {
            //Los Case son códigos que están en el enum de bebida
            case 1001:
            case 1002:
                leche.dispensarBebida();
                //Implementación de que cada vez que dispensemos una bebida
                //El contador aumenta
                //Hay que controlar también que tengamos suficiente cantidad
                totalLeche++;
                break;
            case 1003:
            case 1005:
            case 1009:
                agua.dispensarBebida();
                cafe.dispensarBebida();
                totalCafe++;
                break;
            case 1004:
            case 1006:
            case 1010:
                cafeDescafeinado.dispensarBebida();
                agua.dispensarBebida();
                totalCafeDescafeinado++;
                break;
            case 1007:
                agua.dispensarBebida();
                cafe.dispensarBebida(20); //Al ser la mitad de lo que un café tiene por defecto
                leche.dispensarBebida(20);
                totalCafeConLeche++;

                break;
            case 1008:
                agua.dispensarBebida();
                cafeDescafeinado.dispensarBebida(20); //Al ser la mitad de lo que un café tiene por defecto
                leche.dispensarBebida(20);
                totalCafeDescafeinadoConLeche++;
                break;

            case 1011:
                agua.dispensarBebida();
                chocolate.dispensarBebida();
                totalChocolate++;
                break;
            default:
                throw new IllegalArgumentException("La bebida seleccionada no existe"); //Lanza una excepción para controlar
            //Que la bebida seleccionada no existe
        }

    }

    public void dispensarAzucar(int seleccion) {
        //Dependiendo de la selección, se quita ese número de gramos
        azucar.dispensarBebida(seleccion);
    }

    //Métodos Get y Set
    public Deposito getCafe() {
        return cafe;
    }

    public void setCafe(Deposito cafe) {
        this.cafe = cafe;
    }

    public Deposito getCafeDescafeinado() {
        return cafeDescafeinado;
    }

    public void setCafeDescafeinado(Deposito cafeDescafeinado) {
        this.cafeDescafeinado = cafeDescafeinado;
    }

    public Deposito getLeche() {
        return leche;
    }

    public void setLeche(Deposito leche) {
        this.leche = leche;
    }

    public Deposito getAgua() {
        return agua;
    }

    public void setAgua(Deposito agua) {
        this.agua = agua;
    }

    public Deposito getChocolate() {
        return chocolate;
    }

    public void setChocolate(Deposito chocolate) {
        this.chocolate = chocolate;
    }
        public static int getTotalCafe() {
        return totalCafe;
    }

    public void setTotalCafe(int aTotalCafe) {
        totalCafe = aTotalCafe;
    }

    public static int getTotalCafeDescafeinado() {
        return totalCafeDescafeinado;
    }

    public void setTotalCafeDescafeinado(int aTotalCafeDescafeinado) {
        totalCafeDescafeinado = aTotalCafeDescafeinado;
    }

    public static int getTotalLeche() {
        return totalLeche;
    }

    public void setTotalLeche(int aTotalLeche) {
        totalLeche = aTotalLeche;
    }

    public static int getTotalChocolate() {
        return totalChocolate;
    }

    public void setTotalChocolate(int aTotalChocolate) {
        totalChocolate = aTotalChocolate;
    }

    public static int getTotalCafeConLeche() {
        return totalCafeConLeche;
    }

    public void setTotalCafeConLeche(int aTotalCafeConLeche) {
        totalCafeConLeche = aTotalCafeConLeche;
    }

    public static int getTotalCafeDescafeinadoConLeche() {
        return totalCafeDescafeinadoConLeche;
    }

    public void setTotalCafeDescafeinadoConLeche(int aTotalCafeDescafeinadoConLeche) {
        totalCafeDescafeinadoConLeche = aTotalCafeDescafeinadoConLeche;
    }

    public Deposito getAzucar() {
        return azucar;
    }

    public void setAzucar(Deposito aAzucar) {
        azucar = aAzucar;
    }
    

}
