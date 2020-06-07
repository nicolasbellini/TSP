package ar.edu.unq.tsp.repository;

import ar.edu.unq.tsp.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
