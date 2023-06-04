package co.com.alernova.alternovareto.model.service;

import co.com.alernova.alternovareto.model.domain.UserMovie;
import co.com.alernova.alternovareto.model.repository.UserMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserMovieService {

    @Autowired
    private UserMovieRepository userMovieRepository;

    @Transactional
    public UserMovie save(UserMovie userMovie) {
        return userMovieRepository.save(userMovie);
    }
}
