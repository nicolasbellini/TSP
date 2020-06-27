package ar.edu.unq.tsp;

import ar.edu.unq.tsp.repository.ClienteRepository;
import ar.edu.unq.tsp.repository.PedidoRepository;
import ar.edu.unq.tsp.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootstrapApp implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
