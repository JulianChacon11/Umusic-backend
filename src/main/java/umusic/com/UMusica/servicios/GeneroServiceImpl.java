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
import umusic.com.UMusica.entidades.Genero;
import umusic.com.UMusica.repositorios.IGeneroRepository;

/**
 *
 * @author julia
 */

@Service
public class GeneroServiceImpl implements IGeneroService{
    
    @Autowired
    private IGeneroRepository generoRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Genero> findAll() {
        return generoRepository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Genero> findById(Long id) {
        return generoRepository.findById(id);
    }
    
    @Override
    @Transactional
    public Genero guardarGenero(Genero genero) {
        return generoRepository.save(genero);
    }
    
    @Override
    @Transactional
    public void eliminarGenero(Long id) {
        generoRepository.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Genero findGenero(Genero genero) {
        return generoRepository.findById(genero.getId()).orElse(null);
    }
}
