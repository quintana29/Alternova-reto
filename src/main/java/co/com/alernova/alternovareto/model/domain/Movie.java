package co.com.alernova.alternovareto.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@Table(name = "movies")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_movie;

    @NotEmpty(message = "no puede estar vacio")
    @Size(min = 3, max =40 , message = "El tamaño debe de estar entre 4 y 12")
    @Column(nullable=false)
    private String name;

    @NotEmpty(message = "no puede estar vacio")
    private String genre;

    @NotEmpty(message = "no puede estar vacio")
    @Column(nullable=false, unique = true)
    private String type;

    //@NotEmpty(message = "no puede estar vacio")
    private Integer numbers_view;

    @Range(min = 1, max = 5)
    private Float score;

    @OneToMany(mappedBy = "movies")
    @JsonBackReference(value = "id_movie")
    private List<UserMovie> user_movie;

    }
