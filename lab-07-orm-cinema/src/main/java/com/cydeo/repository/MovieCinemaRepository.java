package com.cydeo.repository;

import com.cydeo.entity.Genre;
import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id



    List<MovieCinema> readById(Long Id);

    //Write a derived query to count all movie cinemas with a specific cinema id
    int countByCinemaId(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id

    int countByMovieId(Long id);
    //Write a derived query to list all movie cinemas with higher than a specific date

    List<MovieCinema>  findByDateTimeGreaterThan(LocalDateTime time);

    //Write a derived query to find the top 3 expensive movies


  //    List<Movie> findTop3ByMoviePrice();


    //Write a derived query to list all movie cinemas that contain a specific movie name


    //Write a derived query to list all movie cinemas in a specific location name


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    //@Query(value="select count(*) from  movie_cinema where cinema.id = ?1",nativeQuery = true)
     //    int countMovies(Long id);

    //Write a native query that returns all movie cinemas by location name


   // @Query(value="select * from movie_cinema mc join cinema c on mc.id=c.id join location l on c.id=l.id where c.l.name=?1",nativeQuery = true)
   // List<MovieCinema> getAllMoviesLocation(String locationName);
}
