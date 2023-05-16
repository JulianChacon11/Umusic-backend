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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author julia
 */

@Data
@Entity
@Table(name = "generos")
public class Genero implements Serializable{
    private static final long serialVersionUID = 1L ;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String descripcion;
}
