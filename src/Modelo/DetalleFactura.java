package Modelo;

public class DetalleFactura {
    
    private int id_factura = 0;
    private int id_producto = 0;
    private float precio = 0;
    private int cantidad = 0;
    private double subTotal = 0.0;
    
    public DetalleFactura(int id_factura, int id_producto, float precio, int cantidad){
        this.id_factura = id_factura;
        this.id_producto = id_producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subTotal = this.precio*this.cantidad;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getSubTotal(){
        return this.subTotal;
    }
    
    
    
}
