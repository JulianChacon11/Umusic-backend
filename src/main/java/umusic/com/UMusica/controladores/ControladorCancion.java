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
import umusic.com.UMusica.entidades.Cancion;
import umusic.com.UMusica.servicios.ICancionService;

/**
 *
 * @author julia
 */
@RestController
@RequestMapping("/api/canciones")
public class ControladorCancion {
    
    @Autowired
    private ICancionService cancionService;
    
    @GetMapping()
    public ResponseEntity<List<Cancion>> findAll() {
        return ResponseEntity.ok(cancionService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cancion> findById(@PathVariable("id") Long id) {
        return cancionService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Cancion> guardarCancion(@RequestBody Cancion cancion) {
        return new ResponseEntity<>(cancionService.guardarCancion(cancion), HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Cancion> actualizarCancion(@RequestBody Cancion cancion) {
        return cancionService.findById(cancion.getId())
                .map(c -> ResponseEntity.ok(cancionService.guardarCancion(cancion)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Cancion> eliminarCancion(Long id) {
        return cancionService.findById(id)
                .map(c -> {
                    cancionService.eliminarCancion(id);
                    return ResponseEntity.ok(c);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
