package co.com.alernova.alternovareto.controller;

import co.com.alernova.alternovareto.model.domain.Movie;
import co.com.alernova.alternovareto.model.service.MovieService;
import co.com.alernova.alternovareto.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MyResponseUtility response;

    @PostMapping(path ="/createMovie")
    public ResponseEntity<MyResponseUtility>createMovie(@RequestBody Movie movie){
        response.data = movieService.save(movie);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/movie")
    public ResponseEntity<MyResponseUtility> getAllMovies() {
        response.data = movieService.getAllMovie();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/get/random")
    public ResponseEntity<MyResponseUtility> randomMovies() {
        Random random = new SecureRandom();
        List<Movie> movies = movieService.getAllMovie();
        int index = random.nextInt(movies.size());
        response.data = movies.get(index);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/get/sort/name")
    public ResponseEntity<MyResponseUtility> sortByName() {
        response.data = movieService.sortByName();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/get/sort/score")
    public ResponseEntity<MyResponseUtility> sortByScore() {
        response.data = movieService.sortByScore();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}