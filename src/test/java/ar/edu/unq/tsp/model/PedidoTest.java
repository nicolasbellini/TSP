package ar.edu.unq.tsp.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class PedidoTest {

    Pedido pedido;
    List<PedidoDetalle> pedidoDetalleList = new LinkedList<>();
    PedidoDetalle pedidoDetalleMock;
    PedidoDetalle pedidoDetalleMock2;

    @BeforeEach
    void setUp(){

        pedidoDetalleMock = mock(PedidoDetalle.class);
        pedidoDetalleMock2 = mock(PedidoDetalle.class);
        pedidoDetalleList.add(pedidoDetalleMock);
        pedidoDetalleList.add(pedidoDetalleMock2);
        pedido = new Pedido(pedidoDetalleList);

    }

    @Test
    @DisplayName("Creo un pedido y puedo setearle el total")
    void testCrearPedidoConTotal(){
        when(pedidoDetalleMock.getSubTotal()).thenReturn(5d);
        when(pedidoDetalleMock2.getSubTotal()).thenReturn(5d);
        pedido.calcularTotal();
        assertEquals(pedido.getTotal(),10d);
    }

}
