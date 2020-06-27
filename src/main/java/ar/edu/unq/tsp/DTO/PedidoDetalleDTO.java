package ar.edu.unq.tsp.DTO;

import ar.edu.unq.tsp.model.PedidoDetalle;

public class PedidoDetalleDTO {

    Long id;
    PedidoDetalle pedidoDetalle;

    public Long getId() {
        return id;
    }

    public PedidoDetalleDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public PedidoDetalle getPedidoDetalle() {
        return pedidoDetalle;
    }

    public PedidoDetalleDTO setPedidoDetalle(PedidoDetalle pedidoDetalle) {
        this.pedidoDetalle = pedidoDetalle;
        return this;
    }
}
