package br.com.falgs.newbietests.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.falgs.newbietests.model.Movie;
import br.com.falgs.newbietests.service.MovieService;
import br.com.falgs.newbietests.util.ControllerMapping;

@RestController
@RequestMapping(path = ControllerMapping.MOVIE_PATH)
public class MovieController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
    
	@Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
        LOGGER.debug("Looking for all Movies");
        return ResponseEntity.ok(movieService.findAll());
    }
}
