/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umusic.com.UMusica.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author julia
 */
@Data
@Entity
@Table(name = "canciones")
public class Cancion implements Serializable{
    
    private static final long serialVersionUID = 1L ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    private String titulo;


    private Integer id_artista;

    @NotEmpty
    private String duracion;

    @NotEmpty
    private String album;


    private Integer id_genero;

    @NotEmpty
    private String url;

    private String imagen;
}
