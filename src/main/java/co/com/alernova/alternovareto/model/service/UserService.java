package co.com.alernova.alternovareto.model.service;

import co.com.alernova.alternovareto.model.domain.User;
import co.com.alernova.alternovareto.model.repository.UserRepository;
import co.com.alernova.alternovareto.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private MyResponseUtility response;
    @Transactional
    public MyResponseUtility save(User user) {
        try {
            response = new MyResponseUtility();
            response.data = userRepository.save(user);
            response.status = HttpStatus.CREATED.value();
            return response;
        }catch (Exception e) {
            response.message = "Error en servidor";
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            return response;
        }
    }
    @Transactional
    public MyResponseUtility findAll() {
        try {response = new MyResponseUtility();
            response.data = userRepository.findAll();
            response.status = HttpStatus.OK.value();
            return response;
        }catch (Exception e){
            response.message = "Error en servidor";
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            return response;
        }

    }
}
