package ar.edu.unq.tsp.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double total;

    @OneToMany
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

    public List<PedidoDetalle> getPedidoDetalleList() {
        return pedidoDetalleList;
    }

    public Pedido setPedidoDetalleList(List<PedidoDetalle> pedidoDetalleList) {
        this.pedidoDetalleList = pedidoDetalleList;
        return this;
    }
}
