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

    //Creamos constructor por defecto
    public Cafetera() {

    }

    public void dispensarBebida(int codigo) {
        switch (codigo) {
            //Los Case son códigos que están en el enum de bebida
            case 1001:
            case 1002:
                leche.dispensarBebida();
            case 1003:
            case 1005:
            case 1009:
                agua.dispensarBebida();
                cafe.dispensarBebida();
            case 1004:
            case 1006:
            case 1010:
                cafeDescafeinado.dispensarBebida();
                agua.dispensarBebida();
            case 1007:
                agua.dispensarBebida();
                cafe.dispensarBebida(20); //Al ser la mitad de lo que un café tiene por defecto
                leche.dispensarBebida(20);
            case 1008:
                agua.dispensarBebida();
                cafeDescafeinado.dispensarBebida(20); //Al ser la mitad de lo que un café tiene por defecto
                leche.dispensarBebida(20);
        }
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
}
