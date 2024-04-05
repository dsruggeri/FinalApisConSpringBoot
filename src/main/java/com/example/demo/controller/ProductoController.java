
package com.example.demo.controller;

import com.example.demo.entities.Cliente;
import com.example.demo.entities.Producto;
import com.example.demo.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
     @Autowired
    private IProductoService productoService;
    
    //crear producto
    @PostMapping("/productos/crear")
    public String createProducto(@RequestBody Producto producto){
        productoService.saveProducto(producto);
        return "Producto creado con éxito";
    }
    
    //traer todos los productos
    @GetMapping("/productos/traer")
    public List<Producto> getProductos(){
        return productoService.getProductos();
    }
    
    //traer un producto en particular
    @GetMapping("/productos/{codigo}")
    public Producto getProducto(@PathVariable Long codigo){
        return productoService.findProducto(codigo);
    }
    
    //eliminar un producto
    @DeleteMapping("/productos/eliminar/{codigo}")
    public String deleteProducto(@PathVariable Long codigo){
        productoService.deleteProducto(codigo);
        return "Producto borrado de la base de datos.";
        
    }
    
    //editar un producto
    @PutMapping("/productos/editar/{codigo}")
    public Producto editarProducto(@PathVariable Long codigo,
            
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "marca") String nuevaMarca,
            @RequestParam(required = false, name = "costo") Double nuevoCosto,
            @RequestParam(required = false, name = "cantidad") Double nuevaCantidad){
        
        productoService.editProducto(codigo, nuevoNombre, nuevaMarca, nuevoCosto, nuevaCantidad);
        
        Producto producto = productoService.findProducto(codigo);
        
        
        return producto;
    }
    
    //traer los productos con poco stock
    @GetMapping("/productos/falta_stock")
    public List<Producto> faltaStock(){
        return productoService.faltaStock();
    }
    
    
    
}
