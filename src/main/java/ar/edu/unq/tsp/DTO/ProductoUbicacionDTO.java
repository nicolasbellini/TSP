package ar.edu.unq.tsp.DTO;

import ar.edu.unq.tsp.model.Direccion;

public class ProductoUbicacionDTO {

    Direccion direccion;
    Double stock;
    Long id;

    public Direccion getDireccion() {
        return direccion;
    }

    public ProductoUbicacionDTO setDireccion(Direccion direccion) {
        this.direccion = direccion;
        return this;
    }

    public Double getStock() {
        return stock;
    }

    public ProductoUbicacionDTO setStock(Double stock) {
        this.stock = stock;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ProductoUbicacionDTO setId(Long id) {
        this.id = id;
        return this;
    }

}
