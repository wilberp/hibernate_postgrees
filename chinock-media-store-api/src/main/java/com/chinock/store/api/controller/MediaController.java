package com.chinock.store.api.controller;

import com.chinock.store.api.exception.ResourceNotFoundException;
import com.chinock.store.api.model.ArtistModel;
import com.chinock.store.api.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private ArtistRepository repository;

    public void setArtistController(ArtistRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all-artists")
    public Iterable<ArtistModel> allArtists(){
        return repository.findAll();
    }

    @GetMapping("/find-artist/{id}")
    public ArtistModel artistById(@PathVariable("id")  Integer id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Artista não encontrado"));
    }

    @GetMapping("/find-artist-by-name/{name}")
    public Iterable<ArtistModel> findArtistbyName(@PathVariable("name")  String name){
        return repository.findByNameStartsWith(name);
    }

    @PostMapping("/create-artist")
    public ArtistModel saveArtist(@RequestBody ArtistModel artist){
        ArtistModel artistr = repository.save(artist);
        return  repository.findById(artistr.getArtistId()).orElseThrow(() -> new RuntimeException("não achou o cadastro de artista"));
    }

    @PutMapping("/update-artist")
    public ArtistModel updateArtist(@RequestBody ArtistModel artist){
        ArtistModel artistr = repository.save(artist);
        return  repository.findById(artistr.getArtistId()).orElseThrow(() -> new RuntimeException("não achou o cadastro de artista"));
    }

    @DeleteMapping("/delete-artist/{id}")
    public ResponseEntity<?> deleteArtistById(@PathVariable("id")  Integer id) {
        ArtistModel artistModel = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("não achou o cadastro  artista ID"));
        if (artistModel != null) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return null;
    }
}
