
package com.example.demo.service;


import com.example.demo.entities.Venta;
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
    
    
}
