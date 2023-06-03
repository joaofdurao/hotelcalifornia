package br.com.hotelcalifornia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hotelcalifornia.model.Hotel;
import br.com.hotelcalifornia.repository.RepositorioHotel;

@RestController
@RequestMapping({ "/api/hotel" })

public class HotelController {

    @Autowired
    private RepositorioHotel repository;

    // List all
    @GetMapping
    public List<?> findAll() {
        return repository.findAll();

    }

    // FindById
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Hotel> findById(@PathVariable Long id) {
        return repository.findById(id).map(mapping -> ResponseEntity.ok().body(mapping))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create
    @PostMapping(value = { "/create" })
    // localhost:8080/api/hotel/create
    public Hotel createHotel(@RequestBody Hotel hotelCalifornia) {
        return repository.save(hotelCalifornia);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable long id) {
        return repository.findById(id)
                .map(mapping -> {
                    repository.deleteById(id);

                    return ResponseEntity.ok().body("DELETADO COM SUCESSO!");
                }).orElse(ResponseEntity.notFound().build());
    }
}
