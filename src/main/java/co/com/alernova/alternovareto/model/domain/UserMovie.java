package co.com.alernova.alternovareto.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_movie")
public class UserMovie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user_movie;

    private Boolean view;

    private Float score;

    @Column(nullable = false)
    private Integer id_movie;

    @Column(nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Movie.class)
    @JoinColumn(name = "id_movie", referencedColumnName = "id_movie", insertable = false,updatable = false)
    private Movie movies;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = User.class)
    @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)
    private User users;
}
