package br.com.falgs.newbietests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.falgs.newbietests.model.Library;
import br.com.falgs.newbietests.model.Movie;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(LibraryTest.class);

	@Test
	public void testDummy() {
		Movie movie = mock(Movie.class);
		Library library = new Library();
		library.addMovie(movie);
		library.addMovie(null);

		LOGGER.info("Amount of movies: {}", library.getAmountMovies());
		assertThat(library.getAmountMovies()).isGreaterThan(0);
	}

}
