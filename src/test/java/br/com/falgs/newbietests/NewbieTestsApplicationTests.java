package br.com.falgs.newbietests;

import java.util.Arrays;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;

import br.com.falgs.newbietests.controller.MovieController;
import br.com.falgs.newbietests.model.Movie;
import br.com.falgs.newbietests.repository.MovieRepository;
import br.com.falgs.newbietests.service.MovieService;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(MovieController.class)
public class NewbieTestsApplicationTests {

	    @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private MovieService movieService;

	    @MockBean
	    private MovieRepository movieRepository;

	    @Test
	    public void findAll() throws Exception {

	        Movie fakeMovie = new Movie();
	        fakeMovie.setName("jhoeller");

	        List<Movie> fakesMovies = Arrays.asList(fakeMovie);

	        when(movieRepository.findAll()).thenReturn(fakesMovies);

	        when(movieService.findAll()).thenReturn(fakesMovies);

	        mockMvc.perform(get("/api/v1/private/movie")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$", hasSize(1)))
	                .andExpect(jsonPath("$[0].name", is(fakeMovie.getName())));
	    }

}
