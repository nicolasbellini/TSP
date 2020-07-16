package ar.edu.unq.tsp.service.impl;

import ar.edu.unq.tsp.DTO.ProductoUbicacionDTO;
import ar.edu.unq.tsp.exception.ProductoUbicacionException;
import ar.edu.unq.tsp.model.Producto;
import ar.edu.unq.tsp.repository.ProductoRepository;
import ar.edu.unq.tsp.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getById(Long id) {
        return productoRepository.findById(id);
    }

    public Producto create(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto update(Producto producto) {
        return productoRepository.save(producto);
    }

    public void delete(Producto producto) {
        productoRepository.delete(producto);
    }


    public Producto agregarProductoUbicacion(ProductoUbicacionDTO productoUbicacionDTO) throws ProductoUbicacionException {
        Optional<Producto> productoOptional = productoRepository.findById(productoUbicacionDTO.getId());
        if (productoOptional.isPresent()){
            Producto producto = productoOptional.get();
            producto.nuevoProductoUbicacion(productoUbicacionDTO.getStock(),productoUbicacionDTO.getDireccion());
            return productoRepository.save(producto);
        }
        else{
            throw new ProductoUbicacionException();
        }
    }
}
