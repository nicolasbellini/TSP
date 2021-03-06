package ar.edu.unq.tsp.controller;


import ar.edu.unq.tsp.DTO.ProductoUbicacionDTO;
import ar.edu.unq.tsp.exception.ProductoUbicacionException;
import ar.edu.unq.tsp.model.Producto;
import ar.edu.unq.tsp.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> getAll() {
        return productoService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Producto getById(@PathVariable("id") Long id) {
        Optional<Producto> producto = productoService.getById(id);
        return producto.orElse(new Producto());
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto create(@RequestBody Producto producto) {
        return productoService.create(producto);
    }

    @PostMapping("/nuevoProductoUbicacion")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crearProductoUbicacion(@RequestBody ProductoUbicacionDTO productoUbicacionDTO) throws ProductoUbicacionException {
        return productoService.agregarProductoUbicacion(productoUbicacionDTO);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Producto update(@RequestBody Producto producto) {
        return productoService.update(producto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        Optional<Producto> producto = productoService.getById(id);
        if(producto.isPresent()) {
            productoService.delete(producto.get());
        }
    }

}
