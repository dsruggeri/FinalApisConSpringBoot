
package com.example.demo.service;

import com.example.demo.entities.Producto;
import java.util.List;


public interface IProductoService {
    
    //CRUD DE PRODUCTO
    
    //traer todos los productos
    public List<Producto> getProductos();
    
    //nuevo producto
    public void saveProducto(Producto producto);
    
    //borrar un producto
    public void deleteProducto(Long id);
    
    //traer un producto específico
    public Producto findProducto(Long id);
    
    //editar un producto
    public void editProducto(Long codigoOriginal, 
                                String nombreNuevo, String marcaNueva,
                                    Double costoNuevo, Double cantidadNueva);
    
}
