package ar.edu.unq.tsp.model;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DireccionTest {

    Direccion direccion;
    String calle;
    String altura;
    String localidad;
    String provincia;

    @BeforeEach
    void setUp() {
        calle = "lavalle";
        altura = "160";
        localidad = "Bernal oeste";
        provincia = "Cordoba";
        direccion = new Direccion(calle, altura, localidad,provincia);
    }

    @Test
    void puedoCrearUnaDireccion() {
        Direccion dir = new Direccion();
        assertNotNull(dir);
    }

    @Test
    void unaDireccionTieneUnaCalle() {
        assertEquals(direccion.getCalle(), calle);
    }

    @Test
    void unaDireccionConUnaCalleSePuedeActualizar() {
        String calleNueva = "avellaneda";
        direccion.setCalle(calleNueva);
        assertEquals(direccion.getCalle() ,calleNueva);
    }

    @Test
    void unaDireccionTieneUnaAltura() {
        assertEquals(direccion.getAltura() ,altura);
    }

    @Test
    void unaDireccionConUnaAlturaSePuedeActualizar() {
        String alturaNuevo = "200";
        direccion.setAltura(alturaNuevo);
        assertEquals(direccion.getAltura() ,alturaNuevo);
    }

    @Test
    void unaDireccionTieneUnaLocalidad() {
        assertEquals(direccion.getLocalidad() ,localidad);
    }

    @Test
    void unaDireccionConUnaLocalidadSePuedeActualizar() {
        String localidadNuevo = "Bernal";
        direccion.setLocalidad(localidadNuevo);
        assertEquals(direccion.getLocalidad() ,localidadNuevo);
    }

    @Test
    void unaDireccionTieneUnaProvincia() {
        assertEquals(direccion.getProvincia() ,provincia);
    }

    @Test
    void unaDireccionConUnaProvinciaSePuedeActualizar() {
        String provinciaNuevo = "Buenos Aires";
        direccion.setProvincia(provinciaNuevo);
        assertEquals(direccion.getProvincia() ,provinciaNuevo);
    }

    @Test
    void unaDireccionEsCapazDeSaberSuDireccionComoString() {
        String direccionString = "lavalle 160,Bernal oeste,Cordoba";
        assertEquals(direccion.toString() ,direccionString);
    }
}