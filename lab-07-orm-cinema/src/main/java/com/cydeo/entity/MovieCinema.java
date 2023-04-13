package com.cydeo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class MovieCinema extends BaseEntity{

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;//we need here foreignkey//at many side
    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;
    @Override
    public String toString() {
        return "MovieCinema{" +
                "dateTime=" + dateTime +
                '}';
    }

}