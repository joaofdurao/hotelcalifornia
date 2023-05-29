package br.com.hotelcalifornia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hotelcalifornia.model.Hotel;

public interface RepositorioHotel extends JpaRepository<Hotel, Long> {
    

}
