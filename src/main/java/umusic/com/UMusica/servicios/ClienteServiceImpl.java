/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umusic.com.UMusica.servicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umusic.com.UMusica.entidades.Cliente;
import umusic.com.UMusica.entidades.LoginDTO;
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
    
    @Override
    public int login(LoginDTO clienteDTO) {
        int c = clienteRepository.findByUserNameAndPassword(clienteDTO.getUsername(), clienteDTO.getPassword());
        return c;
    }
    
    @Override
    public ResponseEntity<?> ingresar(LoginDTO clienteDTO) {
        Map<String, Object> response = new HashMap<>();
        Cliente cliente = null;
        try{
            cliente = clienteRepository.findByUserAndPassword(clienteDTO.getUsername(), clienteDTO.getPassword());
            
            if(cliente == null){
                response.put("Cliente", null);
                response.put("Mensaje", "Alerta:Usuario o Password incorrectos");
                response.put("statusCode", HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            
            }else {
                response.put("Usuario", cliente);
                response.put("Mensaje", "Datos correctos");
                response.put("statusCode", HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }catch (Exception e){
            response.put("Usuario", null);
            response.put("Mensaje", "Ha ocurrido un error");
            response.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
