package ar.edu.unq.tsp.service;

import ar.edu.unq.tsp.DTO.PedidoDetalleDTO;
import ar.edu.unq.tsp.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> getAll();
    Optional<Pedido> getById(Long id);
    Pedido create(Pedido producto);
    Pedido update(Pedido producto) throws Exception;
    void delete(Pedido producto);
    Pedido nuevoPedidoDetalle(PedidoDetalleDTO pedidoDetalleDTO) throws Exception;

    Pedido enviarPedido(Pedido pedido);

    List<Pedido> getPedidosEnviados();

    Pedido descartarPedido(Pedido pedido);

    List<Pedido> getPedidosDescartados();
}
