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
    private Double total;
    private boolean entregado = false;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pedido")
    List<PedidoDetalle> pedidoDetalleList = new LinkedList();

    public Pedido(List<PedidoDetalle> pedidoDetalles){
        this.pedidoDetalleList = pedidoDetalles;
    }

    public Pedido() {  }

    public Long getId() {
        return id;
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
}
