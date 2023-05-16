/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umusic.com.UMusica.servicios;

import java.util.List;
import java.util.Optional;
import umusic.com.UMusica.entidades.Genero;

/**
 *
 * @author julia
 */
public interface IGeneroService {
    
    public List<Genero> findAll();
    
    public Optional<Genero> findById(Long id);
    
    public Genero guardarGenero(Genero genero);
    
    public void eliminarGenero(Long id);
    
    public Genero findGenero(Genero genero);
}
