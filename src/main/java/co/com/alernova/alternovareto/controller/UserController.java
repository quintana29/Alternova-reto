package co.com.alernova.alternovareto.controller;


import co.com.alernova.alternovareto.model.domain.User;
import co.com.alernova.alternovareto.model.service.UserService;
import co.com.alernova.alternovareto.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MyResponseUtility response;

    @PostMapping(path ="/createUser")
    public ResponseEntity<MyResponseUtility> createUser(@RequestBody User user){
        response.data = userService.save(user);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping(path ="/find/all/users")
    public ResponseEntity<MyResponseUtility> findAll(){
        response.data = userService.findAll();
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
