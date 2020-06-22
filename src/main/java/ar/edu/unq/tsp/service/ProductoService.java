package ar.edu.unq.tsp.service;

import ar.edu.unq.tsp.DTO.ProductoUbicacionDTO;
import ar.edu.unq.tsp.exception.ProductoUbicacionException;
import ar.edu.unq.tsp.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
     List<Producto> getAll();
     Optional<Producto> getById(Long id);
     Producto create(Producto producto);
     Producto update(Producto producto);
     void delete(Producto producto);
     Producto agregarProductoUbicacion(ProductoUbicacionDTO productoUbicacionDTO) throws ProductoUbicacionException;
}
