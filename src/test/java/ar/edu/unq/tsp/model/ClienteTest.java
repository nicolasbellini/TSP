package ar.edu.unq.tsp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClienteTest {

    String nombre;
    String calle;
    String altura;
    String localidad;
    String provincia;
    Cliente tito;

    @BeforeEach
    void setUp() {
        nombre = "tito";
        calle = "lavalle";
        altura = "160";
        localidad = "Bernal oeste";
        provincia = "Cordoba";
        tito = new Cliente(nombre, calle, altura, localidad,provincia);
    }

    @Test
    public void puedoGenerarUnCliente() {
        Cliente cliente = new Cliente();
        assertNotNull(cliente);
    }

    @Test
    public void alCrearUnClientePuedeTenerUnNombreFantasia(){
        assertEquals(tito.getNombreFantasia() ,nombre);
    }

    @Test
    public void aUnClienteUnaVezCreadoSeLeDeseaPoderCambiarElNombre(){
        String nombreNuevo = "Tito Lopez";
        tito.setNombreFantasia(nombreNuevo);
        assertEquals(tito.getNombreFantasia() ,nombreNuevo);
    }

    @Test
    public void alCrearUnClientePuedeTenerunaCalle(){
        assertEquals(tito.getCalle() ,calle);
    }

    @Test
    public void aUnClienteUnaVezCreadoSeLeDeseaPoderCambiarLaCalleDondeSeEntrega(){
        String calleNueva = "avellaneda";
        tito.setCalle(calleNueva);
        assertEquals(tito.getCalle() ,calleNueva);
    }

    @Test
    public void alCrearUnClientePuedeTenerunaAltura(){
        assertEquals(tito.getAltura() ,altura);
    }

    @Test
    public void aUnClienteUnaVezCreadoSeLeDeseaPoderCambiarLaAlturaDeLaCalleDondeEntregarElPedido(){
        String alturaNuevo = "200";
        tito.setAltura(alturaNuevo);
        assertEquals(tito.getAltura() ,alturaNuevo);
    }

    @Test
    public void alCrearUnClientePuedeTenerLocalidad(){
        assertEquals(tito.getLocalidad() ,localidad);
    }

    @Test
    public void aUnClienteUnaVezCreadoSeLeDeseaPoderCambiarSuLocalidad(){
        String localidadNuevo = "Bernal";
        tito.setLocalidad(localidadNuevo);
        assertEquals(tito.getLocalidad() ,localidadNuevo);
    }

    @Test
    public void alCrearUnClientePuedeTenerAsociadaUnaProvincia(){
        assertEquals(tito.getProvincia() ,provincia);
    }

    @Test
    public void aUnClienteUnaVezCreadoSeLeDeseaPoderCambiarSuProvincia(){
        String provinciaNuevo = "Buenos Aires";
        tito.setProvincia(provinciaNuevo);
        assertEquals(tito.getProvincia() ,provinciaNuevo);
    }

}