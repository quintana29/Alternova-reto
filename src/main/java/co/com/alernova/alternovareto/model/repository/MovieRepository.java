package co.com.alernova.alternovareto.model.repository;

import co.com.alernova.alternovareto.model.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository  extends JpaRepository<Movie, Integer> {
    @Query(value = "SELECT * FROM streaming_platform.movies WHERE name = :criterion", nativeQuery = true)
    List<Movie> filterByCriteriaName(@Param("criterion") String criterion);

    @Query(value = "SELECT * FROM streaming_platform.movies WHERE type = :criterion", nativeQuery = true)
    List<Movie> filterByCriteriaType(@Param("criterion") String criterion);

    @Query(value = "SELECT * FROM streaming_platform.movies WHERE genre = :criterion", nativeQuery = true)
    List<Movie> filterByCriteriaGenre(@Param("criterion") String criterion);


    List<Movie> findAllByOrderByName();
    List<Movie> findAllByOrderByScoreDesc();
    List<Movie> findAllByOrderByGenre();
    List<Movie> findAllByOrderByType();
}
