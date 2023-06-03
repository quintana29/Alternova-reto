package co.com.alernova.alternovareto.model.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_movie;
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

    //@NotNull
    //@Column( unique = true)
    private Float score;

    }
