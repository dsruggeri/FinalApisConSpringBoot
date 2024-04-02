
package com.example.demo.service;

import com.example.demo.entities.Producto;
import com.example.demo.repository.IProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private IProductoRepository productoRepo;

    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProductos = productoRepo.findAll();
        return listaProductos;      
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepo.deleteById(id);
    }

    @Override
    public Producto findProducto(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public void editProducto(Long codigoOriginal, String nombreNuevo, 
                            String marcaNueva, Double costoNuevo, 
                            Double cantidadNueva) {
        Producto producto = this.findProducto(codigoOriginal);
        
        producto.setNombre_producto(nombreNuevo);
        producto.setMarca(marcaNueva);
        producto.setCosto(costoNuevo);
        producto.setCantidad_disponible(cantidadNueva);
        
        this.saveProducto(producto);
        
    }
    
}
