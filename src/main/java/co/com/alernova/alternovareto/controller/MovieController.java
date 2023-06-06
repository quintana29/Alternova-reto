package co.com.alernova.alternovareto.controller;

import co.com.alernova.alternovareto.model.domain.Movie;
import co.com.alernova.alternovareto.model.domain.Value;
import co.com.alernova.alternovareto.model.service.MovieService;
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
@Tags({@Tag(name = "Movie controller", description = "RestController para las Apis de peliculas y series")})
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MyResponseUtility response;
    @Operation(description = "Guarda una pelicula o serie")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Información registrada exitosamente.", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))}),
            @ApiResponse(responseCode = "500", description = "Error interno", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class)) }),
            @ApiResponse(responseCode = "400", description =" Not found", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class)) })})
    @PostMapping(path ="/createMovie")
    public ResponseEntity<MyResponseUtility>createMovie(@RequestBody Movie movie){
        response = movieService.save(movie);
        return  new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }
    @Operation(description = "Obtiene todas las peliculas o series")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Información consultada exitosamente.", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))}),
            @ApiResponse(responseCode = "500", description = "Error interno", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class)) }),
            @ApiResponse(responseCode = "400", description =" Not found", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class)) })})
    @GetMapping(path = "/get/movies")
    public ResponseEntity<MyResponseUtility> getAllMovies() {
        response = movieService.getAllMovie();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }
    @Operation(description = "Obtiene una pelicula aleatoria")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Información consultada exitosamente.", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))}),
            @ApiResponse(responseCode = "500", description = "Error interno", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class)) }) })
    @GetMapping(path = "/get/random")
    public ResponseEntity<MyResponseUtility> randomMovies() {
        response = movieService.randomMovies();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }
    @Operation(description = "Obtiene peliculas en base a unos criterios, ordenadas descendientemente")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Información consultada exitosamente.", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))}),
            @ApiResponse(responseCode = "500", description = "Error interno", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class)) }) })
    @GetMapping(path = "/get/sort/{criterion}")
    public ResponseEntity<MyResponseUtility> sortByCriteria(@PathVariable(value = "criterion") String criterion) {
        response = movieService.sortByCriteria(criterion);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }
    @Operation(description = "Obtiene peliculas en base de los filtros y criterios")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Información registrada exitosamente.", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Value.class))}),
            @ApiResponse(responseCode = "500", description = "Error interno", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Value.class)) }) })
    @PostMapping(path = "/get/filter/{criterion}")
    public ResponseEntity<MyResponseUtility> filtertByCiteria(@RequestBody Value value, @PathVariable(value = "criterion") String criterion) {
        response = movieService.filterByCriteria(criterion, value);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }

}
