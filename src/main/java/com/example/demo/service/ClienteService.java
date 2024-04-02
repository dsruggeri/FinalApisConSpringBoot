
package com.example.demo.service;

import com.example.demo.entities.Cliente;
import com.example.demo.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
    
    @Autowired
    private IClienteRepository clienteRepo;
    
    
    
    @Override
    public List<Cliente> getClientes() {
        List<Cliente> listaClientes = clienteRepo.findAll();
        return listaClientes;
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {
        Cliente cliente = clienteRepo.findById(id).orElse(null);
        return cliente;
    }

    @Override
    public void editCliente(Long idOriginal, String nombreNuevo, 
            String apellidoNuevo, String dniNuevo) {
        
        Cliente cliente = this.findCliente(idOriginal);
        
        cliente.setNombre(nombreNuevo);
        cliente.setApellido(apellidoNuevo);
        cliente.setDni(dniNuevo);
        
        this.saveCliente(cliente);        
        
    }
    
    
    
}
