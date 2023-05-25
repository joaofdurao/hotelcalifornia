package br.com.hotelcalifornia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hotelcalifornia.model.Hotel;

@Repository
public interface RepositorioHotel extends JpaRepository<Hotel, Long> {
    
    // void findById(Long id);
    // void removeById(Long id);

}
