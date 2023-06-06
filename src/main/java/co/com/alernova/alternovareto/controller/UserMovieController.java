package co.com.alernova.alternovareto.controller;

import co.com.alernova.alternovareto.model.domain.UserMovie;
import co.com.alernova.alternovareto.model.service.UserMovieService;
import co.com.alernova.alternovareto.utilities.MyResponseUtility;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
@Tags({@Tag(name = "User-Movie controller", description = "RestController para las Apis de Usuarios y Peliculas")})
public class UserMovieController {

    @Autowired
    private UserMovieService userMovieService;

    @Autowired
    private MyResponseUtility response;
    @Operation(description = "Marca como vista una serie o pelicula")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Información registrada exitosamente.", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UserMovie.class))}),
            @ApiResponse(responseCode = "500", description = "Error interno", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UserMovie.class)) }) })
    @PostMapping(path ="/mark/view/movie")
    public ResponseEntity<MyResponseUtility> markView(@RequestBody UserMovie userMovie){
        response = userMovieService.markView(userMovie);
        return  new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }
    @Operation(description = "Califica a una serie o pelicula")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Información registrada exitosamente.", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UserMovie.class))}),
            @ApiResponse(responseCode = "500", description = "Error interno", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UserMovie.class)) }) })
    @PostMapping(path ="/rate/movie")
    public ResponseEntity<MyResponseUtility> rateMovie(@RequestBody UserMovie userMovie){
        response = userMovieService.rateMovie(userMovie);
        return  new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }
}
