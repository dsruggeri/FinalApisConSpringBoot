
package com.example.demo.service;

import com.example.demo.DTO.VentaDTO;
import com.example.demo.entities.Producto;
import com.example.demo.entities.Venta;
import com.example.demo.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {
    
    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public void saveVenta(Venta venta) {
                   
        ventaRepo.save(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public Venta findVenta(Long id) {
        Venta venta = ventaRepo.findById(id).orElse(null);
        return venta;
    }

    @Override
    public void editarVenta(Venta venta){
        
        this.saveVenta(venta);
        
    }

    @Override
    public List<Producto> detalleVenta(Long id) {
        Venta venta = this.findVenta(id);
        
        List<Producto> detalleVenta = venta.getListaProductos();
        
        return detalleVenta;        
    }

    @Override
    public String ventaFecha(LocalDate fecha) {
        
        Double montoTotal = 0d;
        int totalVentas = 0;
        
        List<Venta> ventas = this.getVentas();
        
        for (Venta venta : ventas) {
            
            if (venta.getFecha_venta().isEqual(fecha)) {
                totalVentas++;
                montoTotal += venta.getMonto_total();
            }
        }
        
        return "La cantidad de ventas del día "+ fecha + 
                " fue de " + totalVentas + ", por un monto"
                + " total de $" + montoTotal + "."; 
        
    }

    @Override
    public VentaDTO mayorVenta() {
        
        List<Venta> listaVentas = this.getVentas();
        Double monto_maximo = 0d;
        Venta venta_mayor = null;
        
        for (Venta venta : listaVentas) {
            if (venta.getMonto_total() > monto_maximo) {
                monto_maximo = venta.getMonto_total();
                venta_mayor = venta;
            }
        }
        
        VentaDTO respuesta = new VentaDTO();
        
        respuesta.setCodigo_venta(venta_mayor.getCodigo_venta());
        respuesta.setCantidad_productos(venta_mayor.getListaProductos().size());
        respuesta.setNombre_cliente(venta_mayor.getCliente().getNombre());
        respuesta.setApellido_cliente(venta_mayor.getCliente().getApellido());
        
        return respuesta;
        
    }
    
    
    
}
