/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umusic.com.UMusica.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author julia
 */
@Data
@Entity
@Table(name = "usuarios")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L ;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String apellido;
    
    @Email
    @NotEmpty
    private String email;
    
    @NotEmpty
    private String telefono;
    
    private Date fecha_nacimiento;
    
    @NotEmpty
    private String genero;
    
    @NotEmpty
    private String nacionalidad;
    
    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;
    
    private Integer id_rol;
}
