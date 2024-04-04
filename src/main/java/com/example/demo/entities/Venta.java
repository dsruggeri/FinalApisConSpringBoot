
package com.example.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;
    
    private LocalDate fecha_venta;
    private Double monto_total;

    @ManyToMany
    @JoinTable(
        name = "venta_lista_productos",
        joinColumns = @JoinColumn(name = "codigo_venta"),
        inverseJoinColumns = @JoinColumn(name = "codigo_producto")
    )
    private List<Producto> listaProductos;    
    
    @ManyToOne
    private Cliente cliente;
            
    
}
