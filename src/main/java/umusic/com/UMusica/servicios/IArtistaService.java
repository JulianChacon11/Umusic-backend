/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umusic.com.UMusica.servicios;

import java.util.List;
import java.util.Optional;
import umusic.com.UMusica.entidades.Artista;

/**
 *
 * @author julia
 */
public interface IArtistaService {
    
    public List<Artista> findAll();
    
    public Optional<Artista> findById(Long id);
    
    public Artista guardarArtista(Artista artista);
    
    public void eliminarArtista(Long id);
    
    public Artista findArtista(Artista artista);
}
