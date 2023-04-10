package com.cydeo.entity;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Movie extends BaseEntity{

    private String name;
    @Enumerated(EnumType.STRING)
    private MovieState state;
    @Enumerated(EnumType.STRING)
    private MovieType type;
    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;
    private BigDecimal price;
    private Integer duration;
    @Column(columnDefinition = "text")//you can put as much as character
    private String summary;
    @ManyToMany
    @JoinTable(name = "MovieGenreRel",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genreList;

}
