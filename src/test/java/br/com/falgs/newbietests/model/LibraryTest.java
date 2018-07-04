package br.com.falgs.newbietests.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryTest {

	@Test
	public void testDummy() {
		Movie movie = mock(Movie.class);
		Library library = new Library();
		library.addMovie(movie);

		assertThat(library.getAmountMovies()).isGreaterThan(0);
	}
}
