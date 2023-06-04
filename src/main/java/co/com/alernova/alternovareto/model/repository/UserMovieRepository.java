package co.com.alernova.alternovareto.model.repository;

import co.com.alernova.alternovareto.model.domain.UserMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMovieRepository extends JpaRepository<UserMovie, Integer> {
}
