package br.com.falgs.newbietests;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.falgs.newbietests.model.Movie;
import br.com.falgs.newbietests.repository.MovieRepository;

@SpringBootApplication
public class NewbieTestsApplication {

	private final static Logger LOGGER = LoggerFactory.getLogger(NewbieTestsApplication.class);
	
	public static void main(String[] args) {
		LOGGER.debug("Starting the application...");
		SpringApplication.run(NewbieTestsApplication.class, args);
	}
	
	@Bean //remover ao gerar projeto final
    CommandLineRunner init(MovieRepository movieRepository) {
        LOGGER.debug("Populando dados para testes...");
        return (evt) -> Arrays.asList(
                "jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
                .forEach(
                        a -> {
                        	Movie movieSave = new Movie();
                        	movieSave.setName(a);
                            movieRepository.save(movieSave);
                        });
    }
}
