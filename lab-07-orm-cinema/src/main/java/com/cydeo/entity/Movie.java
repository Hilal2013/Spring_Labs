package com.cydeo.entity;

import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private State state;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime releaseDate;
    private BigDecimal price;
    private Integer duration;
    private String summary;
    @OneToMany(mappedBy = "movie")
    private List<MovieCinema> movieCinemaList;
    @ManyToMany
    @JoinTable(name = "MovieGenreRel",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList;
    public Movie(String name, State state, Type type, LocalDateTime releaseDate, BigDecimal price, Integer duration, String summary) {
        this.name = name;
        this.state = state;
        this.type = type;
        this.releaseDate = releaseDate;
        this.price = price;
        this.duration = duration;
        this.summary = summary;
    }
}
