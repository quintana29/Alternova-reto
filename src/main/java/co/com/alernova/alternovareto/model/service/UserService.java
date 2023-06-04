package co.com.alernova.alternovareto.model.service;

import co.com.alernova.alternovareto.model.domain.User;
import co.com.alernova.alternovareto.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
