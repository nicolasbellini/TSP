package ar.edu.unq.tsp.model;

import ar.edu.unq.tsp.model.error.NoSeEncontraronLosDatos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteTest {

    String nombre;
    String telefono;
    String email;
    Direccion direccion;
    Cliente tito;


    @BeforeEach
    void setUp() {
        nombre = "tito";
        telefono = "113781654";
        email = "seba@gmail.com";
        direccion = mock(Direccion.class);

        tito = new Cliente(nombre, direccion, telefono, email);
    }

    @Test
    void puedoGenerarUnCliente() {
        Cliente cliente = new Cliente();
        assertNotNull(cliente);
    }

    @Test
    void aUnClienteUnaVezCreadoSeLeDeseaPoderCambiarElNombre(){
        String nombreNuevo = "Tito Lopez";
        tito.setNombreFantasia(nombreNuevo);
        assertEquals(tito.getNombreFantasia() ,nombreNuevo);
    }

    @Test
    void aUnClienteUnaVezCreadoSeLeDeseaPoderCambiarLaCalleDondeSeEntrega(){
        String calleNueva = "avellaneda";

        when(direccion.getCalle()).thenReturn(calleNueva);
        tito.setDireccion(direccion);

        assertEquals(tito.getDireccion().getCalle() ,calleNueva);
    }

    @Test
    void aUnClienteUnaVezCreadoSeLeDeseaPoderCambiarLaAlturaDeLaCalleDondeEntregarElPedido(){
        String alturaNuevo = "200";

        when(direccion.getAltura()).thenReturn(alturaNuevo);
        tito.setDireccion(direccion);

        assertEquals(tito.getDireccion().getAltura() ,alturaNuevo);
    }

    @Test
    void aUnClienteUnaVezCreadoSeLeDeseaPoderCambiarSuLocalidad(){
        String localidadNuevo = "Bernal";

        when(direccion.getLocalidad()).thenReturn(localidadNuevo);
        tito.setDireccion(direccion);

        assertEquals(tito.getDireccion().getLocalidad() ,localidadNuevo);
    }

    @Test
    void aUnClienteUnaVezCreadoSeLeDeseaPoderCambiarSuProvincia(){
        String provinciaNuevo = "Buenos Aires";

        when(direccion.getProvincia()).thenReturn(provinciaNuevo);
        tito.setDireccion(direccion);

        assertEquals(tito.getDireccion().getProvincia() ,provinciaNuevo);
    }

    @Test
    void alCrearUnClientePuedeTenerAsociadaUnaDireccion() {
        tito.setDireccion(direccion);
        verify(tito.getDireccion());
    }

    @Test
    void unClienteSaveSuDireccion() throws NoSeEncontraronLosDatos {
        String dir = "lavalle 160,Bernal oeste,Cordoba";

        when(direccion.toString()).thenReturn(dir);
        tito.setDireccion(direccion);

        assertEquals(tito.getDireccionCompleta() ,dir);
    }

    @Test
    void unClientePuedeTenerAsociadoUnTelefonoYPuedeEditarElMismo() {
        String telefonoNuevo = "1234567";

        tito.setTelefono(telefonoNuevo);

        assertEquals(tito.getTelefono() , telefonoNuevo);
    }

    @Test
    void unClientePuedeTenerAsociadoUnEmailYPuedeEditarElMismo() {
        String emailNuevo = "asdf@asdf.com";

        tito.setEmail(emailNuevo);

        assertEquals(tito.getEmail() , emailNuevo);
    }

    @Test
    void unClienteQueNoTieneDireccionPuedeLanzarUnaExcepcion(){
        Cliente cliente = new Cliente();
        assertThrows(NoSeEncontraronLosDatos.class, ()->{
                cliente.getDireccionCompleta();
            }
        );
    }
}