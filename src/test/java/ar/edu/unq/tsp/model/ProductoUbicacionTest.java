package ar.edu.unq.tsp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductoUbicacionTest {

    ProductoUbicacion productoUbicacion;
    Double stock;
    Direccion direccion;

    @BeforeEach
    void setUp(){
        stock = 12d;
        productoUbicacion = new ProductoUbicacion();
        direccion = mock(Direccion.class);
    }

    @Test
    void sePuedeCambiarElStockDeUnProducto(){
        productoUbicacion.setStock(12d);
        assertEquals(productoUbicacion.getStock(),12d);
    }

    @Test
    void sePuedeCambiarDireccionDelStock(){
        productoUbicacion.setDireccion(direccion);
        when(direccion.toString()).thenReturn("Esta");
        assertEquals(productoUbicacion.getDireccion().toString(),"Esta");
    }


}
