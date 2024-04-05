
package com.example.demo.controller;

import com.example.demo.DTO.VentaDTO;
import com.example.demo.entities.Cliente;
import com.example.demo.entities.Producto;
import com.example.demo.entities.Venta;
import com.example.demo.service.IVentaService;
import java.time.LocalDate;
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
public class VentaController {
    
    @Autowired
    private IVentaService ventaService; 
    
    //crear Venta
    @PostMapping("/ventas/crear")
    public String createVenta(@RequestBody Venta venta){
        ventaService.saveVenta(venta);
        return "Venta registrada con éxito";
    }
    
    
    //Traer todas las ventas
    @GetMapping("/ventas/traer")
    public List<Venta> getVentas(){
        return ventaService.getVentas();
    }
    
    
    //Traer una venta en particular
    @GetMapping("/ventas/traer/{codigo}")
    public Venta getVenta(@PathVariable Long codigo){
        return ventaService.findVenta(codigo);
    }
    

    //Eliminar una venta
    @DeleteMapping("/ventas/eliminar/{codigo}")
    public String deleteVenta(@PathVariable Long codigo){
        ventaService.deleteVenta(codigo);
        return "Venta eliminada con éxito";
    }
    
    
    //Editar una venta
    @PutMapping("/ventas/editar")
    public Venta editarVenta(@RequestBody Venta venta){
        
        ventaService.editarVenta(venta);

        return venta;
    }
    
    //detalle de X venta
    @GetMapping("/ventas/detalle/{codigo}")
    public List<Producto> detalleVenta(@PathVariable Long codigo){
        
        return ventaService.detalleVenta(codigo);
    }
    
    //ventas por fecha (cantidad y monto total)
    @GetMapping("/ventas/{fecha}")
    public String ventasPorFecha(@PathVariable LocalDate fecha){
        return ventaService.ventaFecha(fecha);
    }
    
    //mayor venta
    @GetMapping("/ventas/mayor_venta")
    public VentaDTO mayorVenta(){
        return ventaService.mayorVenta();
    }
    
    
}
