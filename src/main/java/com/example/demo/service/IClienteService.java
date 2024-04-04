
package com.example.demo.service;


import com.example.demo.entities.Cliente;
import java.util.List;


public interface IClienteService {
    
    //CRUD DE CLIENTE
    
    //traer todos los clientes
    public List<Cliente> getClientes();
    
    //nuevo cliente
    public void saveCliente(Cliente cliente);
    
    //borrar un cliente
    public void deleteCliente(Long id);
    
    //traer un cliente específico
    public Cliente findCliente(Long id);
    
    //editar un cliente
    public void editCliente(Cliente cliente);
    
    
}
