package ar.edu.unq.tsp.repository;

import ar.edu.unq.tsp.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {


    List<Pedido> findByEntregadoTrue();
}
