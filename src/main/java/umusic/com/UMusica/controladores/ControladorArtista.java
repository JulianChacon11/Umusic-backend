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
import umusic.com.UMusica.entidades.Artista;
import umusic.com.UMusica.servicios.IArtistaService;


/**
 *
 * @author julia
 */
@RestController
@RequestMapping("/api/artistas")
public class ControladorArtista {
    
    @Autowired
    private IArtistaService artistaService;
    
    
    @GetMapping()
    public ResponseEntity<List<Artista>> findAll() {
        return ResponseEntity.ok(artistaService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Artista> findById(@PathVariable("id") Long id) {
        return artistaService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Artista> guardarArtista(@RequestBody Artista artista) {
        return new ResponseEntity<>(artistaService.guardarArtista(artista), HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Artista> actualizarArtista(@RequestBody Artista artista) {
        return artistaService.findById(artista.getId())
                .map(c -> ResponseEntity.ok(artistaService.guardarArtista(artista)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Artista> eliminarArtista(Long id) {
        return artistaService.findById(id)
                .map(c -> {
                    artistaService.eliminarArtista(id);
                    return ResponseEntity.ok(c);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
