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
import umusic.com.UMusica.entidades.Artista;
import umusic.com.UMusica.repositorios.IArtistaRepository;

/**
 *
 * @author julia
 */
@Service
public class ArtistaServiceImpl implements IArtistaService{
    
    @Autowired
    private IArtistaRepository artistaRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Artista> findAll() {
        return artistaRepository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Artista> findById(Long id) {
        return artistaRepository.findById(id);
    }
    
    @Override
    @Transactional
    public Artista guardarArtista(Artista artista) {
        return artistaRepository.save(artista);
    }
    
    @Override
    @Transactional
    public void eliminarArtista(Long id) {
        artistaRepository.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Artista findArtista(Artista artista) {
        return artistaRepository.findById(artista.getId()).orElse(null);
    }
    
}
