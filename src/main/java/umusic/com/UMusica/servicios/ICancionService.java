/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umusic.com.UMusica.servicios;

import java.util.List;
import java.util.Optional;
import umusic.com.UMusica.entidades.Cancion;

/**
 *
 * @author julia
 */

public interface ICancionService {
    
    public List<Cancion> findAll();

    public Optional<Cancion> findById(Long id);

    public Cancion guardarCancion(Cancion cancion);

    public void eliminarCancion(Long id);

    public Cancion findCancion(Cancion cancion);
}
