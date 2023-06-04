package co.com.alernova.alternovareto.model.service;

import co.com.alernova.alternovareto.model.domain.Movie;
import co.com.alernova.alternovareto.model.domain.UserMovie;
import co.com.alernova.alternovareto.model.repository.MovieRepository;
import co.com.alernova.alternovareto.model.repository.UserMovieRepository;
import co.com.alernova.alternovareto.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static java.lang.Boolean.*;

@Service
public class UserMovieService {

    @Autowired
    private UserMovieRepository userMovieRepository;

    @Autowired
    private MovieRepository movieRepository;

    private MyResponseUtility response;

    @Transactional
    public MyResponseUtility markView(UserMovie userMovie) {
         response = new MyResponseUtility();
        if(TRUE.equals(userMovie.getView()) && FALSE.equals(userMovie.getState_view())){
            Optional<Movie> movie = movieRepository.findById(userMovie.getId_movie());
            if(movie.isPresent()){
                Movie newMovie = movie.get();
                newMovie.setNumbers_view(newMovie.getNumbers_view()+1);
                movieRepository.save(newMovie);

                userMovie.setState_view(true);
                response.data = userMovieRepository.save(userMovie);
                return response;
            }else
                response.message = "película no encontrada";
            return response;
        }else
            response.message = "Solo se puede marcar una vez como vista";
        return response;

    }
    @Transactional
    public MyResponseUtility rateMovie(UserMovie userMovie) {
       response = new MyResponseUtility();
        if(FALSE.equals(userMovie.getState_score())){
            Optional<Movie> movie = movieRepository.findById(userMovie.getId_movie());
            if(movie.isPresent()){
                Movie newMovie = movie.get();
                newMovie.setScore((movie.get().getScore() + userMovie.getScore()) / 2);
                movieRepository.save(newMovie);

                userMovie.setState_score(true);
                response.data = userMovieRepository.save(userMovie);
                return response;
            }else
                response.message = "película no encontrada";
            return response;
        }else
            response.message = "Solo se puede puntuar una vez";
        return response;

    }
}
