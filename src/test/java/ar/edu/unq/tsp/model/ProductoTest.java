package ar.edu.unq.tsp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ProductoTest {

    @Mock
    Set<ProductoUbicacion> productoUbicacion;
    String nombre;
    Double precio;
    Producto producto;
    Direccion direccion;


    @BeforeEach
    void setUp(){
        nombre = "Jabon";
        precio = 128d;
        producto = new Producto(nombre, precio);
        direccion = new Direccion();
    }

    @Test
    void puedoGenerarUnCliente() {
        Producto producto = new Producto();
        assertNotNull(producto);
    }

    @Test
    void aUnProductoUnaVezCreadoSeLeDeseaPoderCambiarElNombre(){
        String nombreNuevo = "Arroz";
        producto.setNombre(nombreNuevo);
        assertEquals(producto.getNombre() ,nombreNuevo);
    }


    

}
