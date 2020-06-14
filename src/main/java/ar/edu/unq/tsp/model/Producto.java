package ar.edu.unq.tsp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Producto {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public Long id;
    public String nombre;
    public Double precio;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProductoUbicacion> productoUbicacion = new HashSet<ProductoUbicacion>();


    public Producto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Set<ProductoUbicacion> getProductoUbicacion() {
        return productoUbicacion;
    }

    public void setProductoUbicacion(Set<ProductoUbicacion> productoUbicacion) {
        this.productoUbicacion = productoUbicacion;
    }


}
