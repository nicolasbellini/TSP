package ar.edu.unq.tsp.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteTest {

    @Test
    public void alCrearUnClientePuedeTenerUnNombreFantasia(){
        Cliente tito = new Cliente();
        assertEquals(tito.getNombreFantasia() ,"tito");
    }

}