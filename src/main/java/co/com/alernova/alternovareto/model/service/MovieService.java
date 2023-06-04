package co.com.alernova.alternovareto.model.service;

import co.com.alernova.alternovareto.model.domain.Movie;
import co.com.alernova.alternovareto.model.domain.Value;
import co.com.alernova.alternovareto.model.repository.MovieRepository;
import java.util.Collections;
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
    @Transactional
    public List<Movie> getAllMovie(){
            return movieRepository.findAll();
    }
    @Transactional
    public List<Movie> sortByCriteria(String criterion){
        switch (criterion){
            case "name":
                return movieRepository.findAllByOrderByName();
            case "genre":
                return movieRepository.findAllByOrderByGenre();
            case "type":
                return movieRepository.findAllByOrderByType();
            case "score":
                return movieRepository.findAllByOrderByScoreDesc();
            default:
                return Collections.emptyList();
        }

    }
    @Transactional
    public List<Movie> filterByCriteria(String criterion, Value value){
        switch (criterion){
            case "name":
                return movieRepository.filterByCriteriaName(value.getValue());
            case "genre":
                return movieRepository.filterByCriteriaGenre(value.getValue());
            case "type":
                return movieRepository.filterByCriteriaType(value.getValue());
            default:
                return Collections.emptyList();
        }
    }


}
