package br.com.falgs.newbietests.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Movie {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private Integer year;

	@Column
	private Integer length;

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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(year).append(length).append(id).append(name).toHashCode();
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
		Movie movie = (Movie) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(year, movie.year).append(length, movie.length)
				.append(id, movie.id).append(name, movie.name).isEquals();
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", year=" + year + ", length=" + length + "]";
	}

}
