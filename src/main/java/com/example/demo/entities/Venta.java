
package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Venta {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo_venta;
    
    private LocalDate fecha_venta;
    private Double monto_total;

    @OneToMany
    private List<Producto> listaProductos;    
    
    @OneToOne
    private Cliente cliente;
            
    
}
