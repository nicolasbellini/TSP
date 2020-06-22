package ar.edu.unq.tsp.repository;

import ar.edu.unq.tsp.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
