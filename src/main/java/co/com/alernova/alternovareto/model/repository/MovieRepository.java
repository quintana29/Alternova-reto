package co.com.alernova.alternovareto.model.repository;

import co.com.alernova.alternovareto.model.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository  extends JpaRepository<Movie, Integer> {
    @Query(value = "select MAX(id_peliculas) from peliculas.peliculas", nativeQuery = true)
    Integer BuscarELIdMaximoDePeliculas();

    List<Movie> findAllByOrderByName();

    List<Movie> findAllByOrderByScore();
}
