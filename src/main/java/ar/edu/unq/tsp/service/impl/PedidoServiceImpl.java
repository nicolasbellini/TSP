package ar.edu.unq.tsp.service.impl;

import ar.edu.unq.tsp.DTO.PedidoDetalleDTO;
import ar.edu.unq.tsp.model.Pedido;
import ar.edu.unq.tsp.repository.PedidoRepository;
import ar.edu.unq.tsp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> getById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido update(Pedido pedido) throws Exception {
        if (!pedido.isEntregado()){
            pedido.calcularTotal();
            return pedidoRepository.save(pedido);
        }
        else {
            throw new Exception("Este pedido ya ah sido entregado");
        }
    }

    @Override
    public void delete(Pedido producto) {
        pedidoRepository.delete(producto);
    }

    @Override
    public Pedido nuevoPedidoDetalle(PedidoDetalleDTO pedidoDetalleDTO) throws Exception {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(pedidoDetalleDTO.getId());
        if (pedidoOptional.isPresent()){
            Pedido pedido = pedidoOptional.get();
            if(pedido.isEntregado()) {
                pedido.agregarPedidoDetalle(pedidoDetalleDTO.getPedidoDetalle());
                pedido.calcularTotal();
                return pedidoRepository.save(pedido);
            }else{
                    throw new Exception("El pedido ya fue entregado");
                }
            }
        else {
            throw new Exception("El pedido no existe");
        }
    }

    @Override
    public Pedido enviarPedido(Pedido pedido) {
            pedido.setEntregado(true);
            return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> getPedidosEnviados() {
        return this.pedidoRepository.findByEntregadoTrue();
    }

    @Override
    public Pedido descartarPedido(Pedido pedido) {
        pedido.setDescartado(true);
        return this.pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> getPedidosDescartados() {
        return this.pedidoRepository.findByDescartadoTrue();
    }

    @Override
    public Pedido create(Pedido pedido) {
        pedido.calcularTotal();
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido deshacerDescarte(Pedido pedido) {
        pedido.setDescartado(false);
        return this.pedidoRepository.save(pedido);
    }
}
