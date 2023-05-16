/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umusic.com.UMusica.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umusic.com.UMusica.entidades.Cliente;
import umusic.com.UMusica.repositorios.IClienteRepository;

/**
 *
 * @author julia
 */

@Service
public class ClienteServiceImpl implements IClienteService{
    
    @Autowired
    private IClienteRepository clienteRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }
    
    @Override
    @Transactional
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    @Override
    @Transactional
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Cliente findCliente(Cliente cliente) {
        return clienteRepository.findById(cliente.getId()).orElse(null);
    }
}
