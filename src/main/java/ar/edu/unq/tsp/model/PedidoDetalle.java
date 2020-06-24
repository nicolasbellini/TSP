package ar.edu.unq.tsp.model;

import javax.persistence.*;

@Entity
public class PedidoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Producto producto;
    private Double cantidad;

    public PedidoDetalle(){  }

    public PedidoDetalle(Producto producto, Double cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Double getTotal(){
        return cantidad * producto.getPrecio();
    }

    public Long getId() {
        return id;
    }

    public PedidoDetalle setId(Long id) {
        this.id = id;
        return this;
    }

    public Producto getProducto() {
        return producto;
    }

    public PedidoDetalle setProducto(Producto producto) {
        this.producto = producto;
        return this;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public PedidoDetalle setCantidad(Double cantidad) {
        this.cantidad = cantidad;
        return this;
    }
}
