package ar.edu.unq.tsp.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    Cliente tito = new Cliente();

    @Test
    public void alCrearUnClientePuedeTenerUnNombreFantasia(){
        assertEquals(tito.getNombreFantasia() ,"tito");
    }
}