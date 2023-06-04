package co.com.alernova.alternovareto.model.repository;

import co.com.alernova.alternovareto.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
