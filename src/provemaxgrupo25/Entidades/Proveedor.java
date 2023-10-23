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
public class Proveedor {
    
    private int idProveedor;
    private String razonSocial;
    private int cuit;
    private String domicilio;
    private String telefono;
    private boolean estado;

    public Proveedor() {
    }

    public Proveedor(String razonSocial, int cuit, String domicilio, String telefono, boolean estado) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Proveedor(int idProveedor, String razonSocial, int cuit, String domicilio, String telefono, boolean estado) {
        this.idProveedor = idProveedor;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return razonSocial + " - " + domicilio;
    }

    
    
    
    
}
