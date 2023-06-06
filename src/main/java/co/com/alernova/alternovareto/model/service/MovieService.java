package co.com.alernova.alternovareto.model.service;

import co.com.alernova.alternovareto.model.domain.Movie;
import co.com.alernova.alternovareto.model.domain.Value;
import co.com.alernova.alternovareto.model.repository.MovieRepository;

import java.security.SecureRandom;

import co.com.alernova.alternovareto.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

import static co.com.alernova.alternovareto.utilities.ApplicationConstants.*;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    private MyResponseUtility response;

    @Transactional
    public MyResponseUtility save(Movie movie) {
        try {
            response = new MyResponseUtility();
            response.data = movieRepository.save(movie);
            response.status = HttpStatus.CREATED.value();
            return response;
        }catch (Exception e){
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            return response;
        }

    }
    @Transactional
    public MyResponseUtility getAllMovie(){
        try {
            response = new MyResponseUtility();
            response.data = movieRepository.findAll();
            response.status = HttpStatus.OK.value();
            return response;
        } catch (Exception e){
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            return response;
        }

    }
    @Transactional
    public MyResponseUtility randomMovies(){
        try {
            response = new MyResponseUtility();
            Random random = new SecureRandom();
            List<Movie> movies = movieRepository.findAll();
            int index = random.nextInt(movies.size());
            response.data = movies.get(index);
            response.status = HttpStatus.OK.value();
            return response;
        } catch (Exception e){
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            return response;
        }

    }
    @Transactional
    public MyResponseUtility sortByCriteria(String criterion){
        response = new MyResponseUtility();
        try {
            switch (criterion){
                case NAME:
                    response.data = movieRepository.findAllByOrderByName();
                    response.status = HttpStatus.OK.value();
                    return response;
                case GENRE:
                    response.data = movieRepository.findAllByOrderByGenre();
                    response.status = HttpStatus.OK.value();
                    return response;
                case TYPE:
                    response.data = movieRepository.findAllByOrderByType();
                    response.status = HttpStatus.OK.value();
                    return response;
                case SCORE:
                    response.data = movieRepository.findAllByOrderByScoreDesc();
                    response.status = HttpStatus.OK.value();
                    return response;
                default:
                    response.message = CRITERIUM_DOES_NOT_EXIST;
                    return response;
            }

        } catch (Exception e){
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            return response;
        }


    }
    @Transactional
    public MyResponseUtility filterByCriteria(String criterion, Value value){
        response = new MyResponseUtility();
        try {
            switch (criterion){
                case NAME:
                    response.data = movieRepository.filterByCriteriaName(value.getValue());
                    response.status = HttpStatus.OK.value();
                    return response;
                case GENRE:
                    response.data = movieRepository.filterByCriteriaGenre(value.getValue());
                    response.status = HttpStatus.OK.value();
                    return response;
                case TYPE:
                    response.data = movieRepository.filterByCriteriaType(value.getValue());
                    response.status = HttpStatus.OK.value();
                    return response;
                default:
                    response.message = CRITERIUM_DOES_NOT_EXIST;
                    return response;
            }
        } catch (Exception e){
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            return response;
        }

    }


}
