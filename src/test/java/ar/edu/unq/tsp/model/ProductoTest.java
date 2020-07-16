package ar.edu.unq.tsp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


public class ProductoTest {


    Set<ProductoUbicacion> productoUbicacionSet;
    ProductoUbicacion productoUbicacion;
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
        productoUbicacionSet = new HashSet<>();
        productoUbicacion = new ProductoUbicacion(3d, direccion);
        productoUbicacionSet.add(productoUbicacion);
        producto.setProductoUbicacion(productoUbicacionSet);
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

    @Test
    void sePuedeCambiarElPrecioDeUnProducto(){
        Double nuevoPrecio = 50d;
        producto.setPrecio(nuevoPrecio);
        assertEquals(nuevoPrecio, producto.getPrecio());
    }

    @Test
    void sePuedeAgregarUnProductoUbicacionAlProducto(){
        producto.addProductoUbicacion(productoUbicacion);
        assertEquals(1,producto.getProductoUbicacion().size());
    }

    @Test
    void sePuedeObtenerElTotalDeStockDeUnProducto(){
        assertEquals(3d,producto.getStockTotal());
    }

    @Test
    void seAgregaUnProductoUbicacionYSeRetorna(){
        ProductoUbicacion productoUbicacionNuevo = producto.nuevoProductoUbicacion(123d, direccion);
        assertEquals(producto.getProductoUbicacion().size(),2);
        assertEquals(productoUbicacionNuevo.getDireccion(), direccion);
        assertEquals(productoUbicacionNuevo.getStock(),123d);
    }
}
