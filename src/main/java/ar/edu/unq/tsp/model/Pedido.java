package ar.edu.unq.tsp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double total = 0d;
    private boolean entregado = false;
    private boolean descartado = false;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pedido")
    List<PedidoDetalle> pedidoDetalleList = new LinkedList();

    public Pedido(List<PedidoDetalle> pedidoDetalles){
        this.pedidoDetalleList = pedidoDetalles;
    }

    public Pedido() {  }


    public void calcularTotal(){
        pedidoDetalleList.forEach(pedidoDetalle -> this.agregarTotal(pedidoDetalle.getSubTotal()));
    }

    public Long getId() {
        return id;
    }

    private void agregarTotal(Double a){
        this.total += a;
    }

    public Pedido setId(Long id) {
        this.id = id;
        return this;
    }

    public void agregarPedidoDetalle(PedidoDetalle pedidoDetalle){
        pedidoDetalle.setPedido(this);
        this.pedidoDetalleList.add(pedidoDetalle);
    }

    public List<PedidoDetalle> getPedidoDetalleList() {
        return pedidoDetalleList;
    }

    public Pedido setPedidoDetalleList(List<PedidoDetalle> pedidoDetalleList) {
        this.pedidoDetalleList = pedidoDetalleList;
        return this;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public Pedido setEntregado(boolean entregado) {
        this.entregado = entregado;
        return this;
    }

    public boolean isDescartado() {
        return descartado;
    }

    public Pedido setDescartado(boolean rechazado) {
        this.descartado = rechazado;
        return this;
    }

    public Double getTotal() {
        return total;
    }

    public Pedido setTotal(Double total) {
        this.total = total;
        return this;
    }
}
