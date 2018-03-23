package br.com.falgs.newbietests.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.falgs.newbietests.model.Movie;
import br.com.falgs.newbietests.repository.MovieRepository;

@Service
public class MovieService {

    private final static Logger LOGGER = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    private MovieRepository movieRepository;

	@Autowired
	private AuditoriaService auditoriaService;

    public List<Movie> findAll() {
        LOGGER.debug("Looking for all Movies");
        return movieRepository.findAll();
    }

	public void save(Movie movie) {
		LOGGER.debug("Saving Movie");
		auditoriaService.registerLog(LOGGER, movie);
		movieRepository.save(movie);
	}

}
