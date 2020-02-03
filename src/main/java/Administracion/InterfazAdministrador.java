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

    
    
    private String nombre;
    private String contrasenia;
    
    public InterfazAdministrador(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contrasenia = contraseña;
    }
    
    public String contadores() {

        return ("Se han servido: \n"
                + "" + Cafetera.getTotalCafeSolo() + " cafés solos\n"
                + "" + Cafetera.getTotalCafeSoloDescafeinado() + " cafés solos descafeinados\n"
                + "" + Cafetera.getTotalCafeConLeche() + " cafés con leche\n"
                + "" + Cafetera.getTotalCafeConLecheDescafeinado() + " cafés con leche descafeinado\n"
                + "" + Cafetera.getTotalCafeCortado() + " cafés cortados\n"
                + "" + Cafetera.getTotalCafeCortadoDescafeinado()+ " cafés cortados descafeinados\n"
                + "" + Cafetera.getTotalCafeCortado()+ " cafés solo largo\n"
                + "" + Cafetera.getTotalCafeSoloLargoDescafeinado()+ " cafés solo largo descafeinado\n"
                + "" + Cafetera.getTotalChocolate() + " chocolates\n"
                + "" + Cafetera.getTotalLeche() + " leches\n");
    }

    public void apagar() {
        System.exit(0);
    }

    public void rellenarDeposito(Deposito dep) {
        dep.rellenarCafetera();
    }
    public String comprobarEstado(Deposito dep){
        if(dep.getCapacidadActual()<=dep.getCapacidadAviso()){
            return "Por favor, rellene el depósito " + dep.getContenidoDeposito();
        }else{
            return "El depósito " + dep.getContenidoDeposito() + " parece estar en buenas condiciones";
        }
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
        public String ganancias(){
        //Variables auxiliares para comprender mejor el código;
        double auxCafeSolo = (Cafetera.getTotalCafeSolo()+Cafetera.getTotalCafeSoloDescafeinado())*Bebida.CAFE_SOLO.getPrecio();
        double auxCafeLeche = (Cafetera.getTotalCafeConLeche()+Cafetera.getTotalCafeConLecheDescafeinado()) * Bebida.CAFE_CON_LECHE.getPrecio();
        double auxCafeCortado = (Cafetera.getTotalCafeCortado()+ Cafetera.getTotalCafeCortadoDescafeinado()) * Bebida.CORTADO.getPrecio();
        double auxLeche = Cafetera.getTotalLeche() * Bebida.LECHE_FRIA.getPrecio();             
        double auxChoco = Cafetera.getTotalChocolate() * Bebida.CHOCOLATE.getPrecio();
        double auxCafeSoloLargo = (Cafetera.getTotalCafeCortado() + Cafetera.getTotalCafeCortadoDescafeinado()) * Bebida.CORTADO.getPrecio();
        
        double total = auxCafeSolo + auxCafeLeche + auxCafeCortado + auxLeche + auxChoco + auxCafeSoloLargo;
        return String.format("%.2f", total) ; 
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contraseña) {
        this.contrasenia = contraseña;
    }
}
