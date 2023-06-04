package co.com.alernova.alternovareto.controller;

import co.com.alernova.alternovareto.model.domain.Movie;
import co.com.alernova.alternovareto.model.domain.UserMovie;
import co.com.alernova.alternovareto.model.service.UserMovieService;
import co.com.alernova.alternovareto.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class UserMovieController {

    @Autowired
    private UserMovieService userMovieService;

    @Autowired
    private MyResponseUtility response;

    @PostMapping(path ="/create/user/movie")
    public ResponseEntity<MyResponseUtility> createMovie(@RequestBody UserMovie userMovie){
        response.data = userMovieService.save(userMovie);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
