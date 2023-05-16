/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umusic.com.UMusica.servicios;

import java.util.List;
import java.util.Optional;
import umusic.com.UMusica.entidades.Cliente;

/**
 *
 * @author julian
 */
public interface IClienteService {
    
    public List<Cliente> findAll();
    
    public Optional<Cliente> findById(Long id);
    
    public Cliente guardarCliente(Cliente cliente);
    
    public void eliminarCliente(Long id);
    
    public Cliente findCliente(Cliente cliente);
    
}
