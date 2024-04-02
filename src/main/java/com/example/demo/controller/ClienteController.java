
package com.example.demo.controller;

import com.example.demo.entities.Cliente;
import com.example.demo.service.IClienteService;
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
public class ClienteController {
    
    @Autowired
    private IClienteService clienteService;
    
    //crear cliente
    @PostMapping("/clientes/crear")
    public String createCliente(@RequestBody Cliente cliente){
        clienteService.saveCliente(cliente);
        return "Cliente creado con éxito";
    }
    
    //traer todos los clientes
    @GetMapping("/clientes/traer")
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }
    
    //traer un cliente en particular
    @GetMapping("/clientes/{id}")
    public Cliente getCliente(@PathVariable Long id){
        return clienteService.findCliente(id);
    }
    
    //eliminar un cliente
    @DeleteMapping("/clientes/eliminar/{id}")
    public String deleteCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);
        return "Cliente borrado de la base de datos.";
        
    }
    
    //editar un cliente
    @PutMapping("/clientes/editar/{idOriginal}")
    public Cliente editarCliente(@PathVariable Long idOriginal,
            
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "apellido") String nuevoApellido,
            @RequestParam(required = false, name = "dni") String nuevoDni){
        
        clienteService.editCliente(idOriginal, nuevoNombre, 
                nuevoApellido, nuevoDni);
        
        Cliente cliente = clienteService.findCliente(idOriginal);
        
        
        return cliente;
    }
    
    
}
            
    
    
    
    
    
    
    

