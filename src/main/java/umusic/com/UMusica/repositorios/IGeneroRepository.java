/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umusic.com.UMusica.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import umusic.com.UMusica.entidades.Genero;

/**
 *
 * @author julia
 */
public interface IGeneroRepository extends JpaRepository<Genero,Long> {
    
}
