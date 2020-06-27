package ar.edu.unq.tsp.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PedidoDetalleTest {

    PedidoDetalle pedidoDetalle;
    Pedido pedido;
    Producto producto;

    @BeforeEach
    void setUp(){
        pedido = mock(Pedido.class);
        producto = mock(Producto.class);
        pedidoDetalle = new PedidoDetalle(producto,pedido,5d);
    }

    @Test
    @DisplayName("Se puede obtener un subtotal")
    public void testSubTotal(){
        when(producto.getPrecio()).thenReturn(5d);
        assertEquals(pedidoDetalle.getSubTotal(),25d);
    }

}
