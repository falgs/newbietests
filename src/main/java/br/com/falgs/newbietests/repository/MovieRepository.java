package br.com.falgs.newbietests.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.falgs.newbietests.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
