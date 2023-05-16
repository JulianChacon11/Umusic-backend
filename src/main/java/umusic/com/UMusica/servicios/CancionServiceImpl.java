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
import umusic.com.UMusica.entidades.Cancion;
import umusic.com.UMusica.repositorios.ICancionRepository;

/**
 *
 * @author julia
 */
@Service
public class CancionServiceImpl implements ICancionService{
    @Autowired
    private ICancionRepository cancionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cancion> findAll() {
        return cancionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cancion> findById(Long id) {
        return cancionRepository.findById(id);
    }

    @Override
    @Transactional
    public Cancion guardarCancion(Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    @Override
    @Transactional
    public void eliminarCancion(Long id) {
        cancionRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Cancion findCancion(Cancion cancion) {
        return cancionRepository.findById(cancion.getId()).orElse(null);
    }
}