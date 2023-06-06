package co.com.alernova.alternovareto.model.service;

import co.com.alernova.alternovareto.model.domain.Movie;
import co.com.alernova.alternovareto.model.domain.UserMovie;
import co.com.alernova.alternovareto.model.repository.MovieRepository;
import co.com.alernova.alternovareto.model.repository.UserMovieRepository;
import co.com.alernova.alternovareto.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static co.com.alernova.alternovareto.utilities.ApplicationConstants.*;
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
        try {
            response = new MyResponseUtility();
            if(TRUE.equals(userMovie.getView()) && FALSE.equals(userMovie.getState_view())){
                Optional<Movie> movie = movieRepository.findById(userMovie.getId_movie());
                if(movie.isPresent()){
                    Movie newMovie = movie.get();
                    newMovie.setNumbers_view(newMovie.getNumbers_view()+1);
                    movieRepository.save(newMovie);

                    userMovie.setState_view(true);
                    response.data = userMovieRepository.save(userMovie);
                    response.status = HttpStatus.OK.value();
                    return response;
                }else
                    response.message = MOVIE_NOT_FOUND;
                response.status = HttpStatus.NOT_FOUND.value();
                return response;
            }else
                response.message = ONLY_ONCE_AS_A_VIEW;
            response.status = HttpStatus.OK.value();
            return response;

        } catch (Exception e){
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            return response;
        }


    }
    @Transactional
    public MyResponseUtility rateMovie(UserMovie userMovie) {

        try{
            response = new MyResponseUtility();
            if(FALSE.equals(userMovie.getState_score())){
                Optional<Movie> movie = movieRepository.findById(userMovie.getId_movie());
                if(movie.isPresent()){
                    Movie newMovie = movie.get();
                    newMovie.setScore((movie.get().getScore() + userMovie.getScore()) / 2);
                    movieRepository.save(newMovie);

                    userMovie.setState_score(true);
                    response.data = userMovieRepository.save(userMovie);
                    response.status = HttpStatus.OK.value();
                    return response;
                }else
                    response.message = MOVIE_NOT_FOUND;
                response.status = HttpStatus.NOT_FOUND.value();
                return response;
            }else
                response.message = ONLY_SCORE_ONCE;
            response.status = HttpStatus.OK.value();
            return response;

        }catch (Exception e){
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            return response;
        }
}
}
