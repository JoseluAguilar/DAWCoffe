/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CafeteraDaw;

/**
 *
 * @author carlos-pc
 */
public enum Bebida {
    LECHE_FRIA(1001, "Leche fría", 0.5, false),
    LECHE_CALIENTE(1002, "Leche caliente", 0.5, false),
    CAFE_SOLO(1003, "Café solo", 0.8, false),
    SOLO_LARGO(1005, "Café solo largo", 0.9, false),
    CAFE_CON_LECHE(1007, "Café con leche", 1.1, false),
    CORTADO(1009, "Café descafeinado", 1, false),
    CHOCOLATE(1011, "Chocolate caliente", 1.4, false),
    CAFE_SOLO_DES(1004, "Café solo descafeinado", 0.8, true),
    SOLO_LARGO_DES(1006, "Café largo descafeinado", 0.9, true),
    CAFE_CON_LECHE_DES(1008, "Café con leche descafeinado", 1.1, true),
    CORTADO_DES(1010, "Café cortado descafeinado", 1, true);
    
    private int codigo;
    private String nombre;
    private double precio;
    private boolean descafeinado;

    private Bebida(int codigo, String nombre, double precio, boolean descafeinado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.descafeinado = descafeinado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isDescafeinado() {
        return descafeinado;
    }

    public void setDescafeinado(boolean descafeinado) {
        this.descafeinado = descafeinado;
    }
    
    
    
}
