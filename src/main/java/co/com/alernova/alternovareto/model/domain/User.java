package co.com.alernova.alternovareto.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "email", nullable = false)
    private String email;

    private String password;

    @OneToMany(mappedBy = "users")
    @JsonBackReference(value = "email")
    private List<UserMovie> user_movie;
}
