/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umusic.com.UMusica.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umusic.com.UMusica.entidades.Genero;
import umusic.com.UMusica.servicios.IGeneroService;

/**
 *
 * @author julia
 */

@RestController
@RequestMapping("/api/generos")
public class ControladorGenero {
    
    @Autowired
    private IGeneroService generoService;
    
    
    @GetMapping()
    public ResponseEntity<List<Genero>> findAll() {
        return ResponseEntity.ok(generoService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Genero> findById(@PathVariable("id") Long id) {
        return generoService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Genero> guardarGenero(@RequestBody Genero genero) {
        return new ResponseEntity<>(generoService.guardarGenero(genero), HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Genero> actualizarGenero(@RequestBody Genero genero) {
        return generoService.findById(genero.getId())
                .map(c -> ResponseEntity.ok(generoService.guardarGenero(genero)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Genero> eliminarGenero(Long id) {
        return generoService.findById(id)
                .map(c -> {
                    generoService.eliminarGenero(id);
                    return ResponseEntity.ok(c);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
