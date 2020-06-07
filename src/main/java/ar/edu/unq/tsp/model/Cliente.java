package ar.edu.unq.tsp.model;

import ar.edu.unq.tsp.model.error.NoSeEncontraronLosDatos;

import javax.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreFantasia;
    @OneToOne
    private Direccion direccion;
    private String telefono;
    private String email;

    public Cliente() {}

    public Cliente(String nombreFantasia, Direccion direccion, String telefono, String email) {
        this.nombreFantasia = nombreFantasia;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public void setNombreFantasia(String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccionCompleta() throws NoSeEncontraronLosDatos {
        if(direccion == null || direccion.toString().isEmpty()) {
            throw new NoSeEncontraronLosDatos();
        }
        return this.direccion.toString();
    }
}
