package ar.edu.unq.tsp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Producto {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public Long id;
    public String nombre;
    public Double precio;
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ProductoUbicacion> productoUbicacion = new HashSet<>();


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


    public void addProductoUbicacion(ProductoUbicacion productoUbicacion) {
        this.productoUbicacion.add(productoUbicacion);
    }

    public ProductoUbicacion nuevoProductoUbicacion(Double stock, Direccion direccion){
        ProductoUbicacion productoUbicacion = new ProductoUbicacion(stock, direccion, this);
        this.productoUbicacion.add(productoUbicacion);
        return productoUbicacion;
    }

    public double getStockTotal() {
        double total = 0d;
        for (ProductoUbicacion productoUbicacion : this.productoUbicacion){
            total = total + productoUbicacion.getStock();
        }
        return total;
    }
}
