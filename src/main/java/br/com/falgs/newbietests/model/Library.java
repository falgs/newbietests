package br.com.falgs.newbietests.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Library {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private boolean individual;
	
	@Transient
	private List<Movie> movies;
	
	public void addMovie(Movie movie) {
		if (movies == null) {
			movies = new ArrayList<>();
		}
		
		if (movie != null) {
			movies.add(movie);
		}
	}
	
	public Integer getAmountMovies() {
		return movies != null ? movies.size() : 0;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isIndividual() {
		return individual;
	}

	public void setIndividual(boolean individual) {
		this.individual = individual;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(name).append(individual).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Library library = (Library) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(obj)).append(individual, library.individual)
				.append(id, library.id).append(name, library.name).isEquals();
	}
}
