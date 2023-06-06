package co.com.alernova.alternovareto.controller;


import co.com.alernova.alternovareto.model.domain.User;
import co.com.alernova.alternovareto.model.service.UserService;
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
@Tags({@Tag(name = "User controller", description = "RestController para las Apis de usuarios") })
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MyResponseUtility response;
    @Operation(description = "Guarda un nuevo usuario")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Información registrada exitosamente.", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "500", description = "Error interno", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) }) })
    @PostMapping(path ="/createUser")
    public ResponseEntity<MyResponseUtility> createUser(@RequestBody User user){
        response = userService.save(user);
        return  new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }
    @Operation(description = "Optiene a todos los usuarios")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Información consultada exitosamente.", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = MyResponseUtility.class))}),
            @ApiResponse(responseCode = "500", description = "Error interno", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = MyResponseUtility.class)) }) })
    @GetMapping(path ="/find/all/users")
    public ResponseEntity<MyResponseUtility> findAll(){
        response = userService.findAll();
        return  new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }

}
