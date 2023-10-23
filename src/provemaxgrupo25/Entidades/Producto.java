/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemaxgrupo25.Entidades;

/**
 *
 * @author Sd
 */
public class Producto {
    
    private int idProducto;
    private String nombreProd;
    private String descripcion;
    private double precioActual;
    private int stock;
    private boolean estado;

    public Producto(int idProducto, String nombreProd, String descripcion, double precioActual, int stock, boolean estado) {
        this.idProducto = idProducto;
        this.nombreProd = nombreProd;
        this.descripcion = descripcion;
        this.precioActual = precioActual;
        this.stock = stock;
        this.estado = estado;
    }

    public Producto(String nombreProd, String descripcion, double precioActual, int stock, boolean estado) {
        this.nombreProd = nombreProd;
        this.descripcion = descripcion;
        this.precioActual = precioActual;
        this.stock = stock;
        this.estado = estado;
    }

    public Producto() {
    }

    public Producto(int idProducto, String nombreProd, double precioActual, int stock, boolean estado) {
        this.idProducto = idProducto;
        this.nombreProd = nombreProd;
        this.precioActual = precioActual;
        this.stock = stock;
        this.estado = estado;
    }

    

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  nombreProd ;
    }
    
    
    
}
