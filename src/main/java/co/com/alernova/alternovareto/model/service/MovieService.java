package co.com.alernova.alternovareto.model.service;

import co.com.alernova.alternovareto.model.domain.Movie;
import co.com.alernova.alternovareto.model.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    //@Transactional(readOnly = true)
    public List<Movie> getAllMovie(){
        return movieRepository.findAll();
    }
    public List<Movie> sortByName(){
        return movieRepository.findAllByOrderByName();
    }

    public List<Movie> sortByScore(){
        return movieRepository.findAllByOrderByScore();
    }
}
