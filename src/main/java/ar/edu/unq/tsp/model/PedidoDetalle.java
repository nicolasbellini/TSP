package ar.edu.unq.tsp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class PedidoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="pedido_id")
    private Pedido pedido;
    @OneToOne
    private Producto producto;
    private Double cantidad;

    public PedidoDetalle(){  }

    public PedidoDetalle(Producto producto, Pedido pedido, Double cantidad){
        this.producto = producto;
        this.pedido = pedido;
        this.cantidad = cantidad;
    }

    public Double getSubTotal(){
        return cantidad * producto.getPrecio();
    }

    public Long getId() {
        return id;
    }

    public PedidoDetalle setId(Long id) {
        this.id = id;
        return this;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public PedidoDetalle setPedido(Pedido pedido) {
        this.pedido = pedido;
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
