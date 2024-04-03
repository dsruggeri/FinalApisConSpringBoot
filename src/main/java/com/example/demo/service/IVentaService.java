
package com.example.demo.service;


import com.example.demo.entities.Cliente;
import com.example.demo.entities.Producto;
import com.example.demo.entities.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
    //CRUD DE VENTA
    
    //traer todas las ventas
    public List<Venta> getVentas();
    
    //nueva venta
    public void saveVenta(Venta venta);
    
    //borrar una venta
    public void deleteVenta(Long id);
    
    //traer una venta específica
    public Venta findVenta(Long id);
    
    //editar una venta
    public void editarVenta(Long codigo_venta, LocalDate fecha_venta, Double total,
                            List<Producto> listaProductos, Cliente cliente);
    
    
}
