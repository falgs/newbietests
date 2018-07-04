package br.com.falgs.newbietests.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.falgs.newbietests.model.Movie;
import br.com.falgs.newbietests.repository.MovieRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceTest.class);

	@Autowired
	private MovieService movieService;

	@MockBean
	private MovieRepository movieRepository;

	@MockBean
	private AuditoriaService auditoriaService;

	// @Test
	public void testStub() {

		Movie fakeMovie = new Movie();
		fakeMovie.setName("Avengers: Infinity War");

		List<Movie> fakesMovies = Arrays.asList(fakeMovie);

		when(movieRepository.findAll()).thenReturn(fakesMovies);

		List<Movie> list = movieService.findAll();
		assertThat(list).containsAnyOf(fakeMovie);
	}

	@Test
	public void testMock() throws Exception {

		Movie fakeMovie = new Movie();
		fakeMovie.setName("Inception");

		movieService.save(false);

		verify(movieRepository).save(null);
	}

	// @Test
	public void testSpy() throws Exception {

		Movie fakeMovie = new Movie();
		fakeMovie.setName("Inception");

		// movieService.save(fakeMovie);

		verify(movieRepository).save(fakeMovie);

		verify(auditoriaService).registerLog(LoggerFactory.getLogger(MovieService.class), fakeMovie);

	}

}
