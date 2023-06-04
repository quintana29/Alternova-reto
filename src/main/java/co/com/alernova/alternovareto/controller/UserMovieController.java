package co.com.alernova.alternovareto.controller;

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

    @PostMapping(path ="/mark/view/movie")
    public ResponseEntity<MyResponseUtility> markView(@RequestBody UserMovie userMovie){
        response = userMovieService.markView(userMovie);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping(path ="/rate/movie")
    public ResponseEntity<MyResponseUtility> rateMovie(@RequestBody UserMovie userMovie){
        response = userMovieService.rateMovie(userMovie);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
