package br.com.hotelcalifornia;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.hotelcalifornia.model.Hotel;
import br.com.hotelcalifornia.repository.RepositorioHotel;

@SpringBootApplication
public class HotelcaliforniaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelcaliforniaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(RepositorioHotel repository){
		return args ->{
			repository.deleteAll();
			LongStream.range(1, 9).mapToObj(i ->{

				Hotel hotel = new Hotel();
				hotel.setNome("Cliente" + i);
				hotel.setEndereco("Olinda");
				hotel.setCapacid((long) 1500);
				return hotel;
			})
			.map(m->repository.save(m))
			.forEach(System.out::println);
		};
	}
}