package com.cydeo.repository;

import com.cydeo.entity.Genre;
import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
   Optional<MovieCinema>  readById(Long Id);

    //Write a derived query to count all movie cinemas with a specific cinema id
    int countByCinemaId(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id
    int countByMovieId(Long id);
    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema>  findByDateTimeGreaterThan(LocalDateTime time);

    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findTop3ByOrderByMoviePriceDesc();
 //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findByMovieName(String nameMovie);
    //Write a derived query to list all movie cinemas in a specific location name
    List<MovieCinema> findByCinemaLocationName(String nameLocation);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("select mc from MovieCinema mc where mc.dateTime>?1 ")
    List<MovieCinema> getDateTimeGreaterThan(@Param("date")LocalDateTime date);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "SELECT COUNT(*) FROM movie_cinema WHERE cinema_id = ?1",nativeQuery = true)
         int countMovies(@Param("id")Long id);

    //Write a native query that returns all movie cinemas by location name

    @Query(value = "SELECT * FROM movie_cinema mc JOIN cinema c ON mc.cinema_id = c.id JOIN location l ON c.location_id = l.id WHERE l.name = ?1 ",nativeQuery = true)
    List<MovieCinema> getAllMoviesLocation(@Param("locationName")String locationName);
}
