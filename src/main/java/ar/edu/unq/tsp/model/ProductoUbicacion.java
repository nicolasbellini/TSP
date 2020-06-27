package ar.edu.unq.tsp.model;

import javax.persistence.*;

@Entity
public class ProductoUbicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    Double stock;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Direccion direccion;

    public ProductoUbicacion(){
    }

    public ProductoUbicacion(Double stock, Direccion direccion) {
        this.stock = stock;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
