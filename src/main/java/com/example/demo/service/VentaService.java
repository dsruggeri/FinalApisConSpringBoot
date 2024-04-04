
package com.example.demo.service;

import com.example.demo.entities.Cliente;
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
    
}
