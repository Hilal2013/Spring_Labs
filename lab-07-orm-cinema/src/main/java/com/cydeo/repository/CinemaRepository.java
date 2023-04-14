package com.cydeo.repository;

import com.cydeo.entity.Account;
import com.cydeo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name

    List<Cinema> findByName(String name);
    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name

      List<Cinema> findTop3BySponsoredNameContainingOrderByNameAsc(String sponsoredName);
    //Write a derived query to list all cinemas in a specific country

    List<Cinema> findByLocationCountry(String country);
    @Query("select c from Cinema c where c.location.country=?1")
    List<Cinema> getCinemaCountry(String country);

    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findByNameOrSponsoredName(String name, String sponsoredNAme);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("select c from Cinema c where c.id=?1")
    List<Cinema> getCinemaNameId(Long id);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country

  //  @Query (value="select * from cinema where ",nativeQuery = true)
  //  List<Cinema> readCinemaLocationCountry(String country);
    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern

   // @Query (value="select * from cinema c join location l on c.id=l.id where name like lower %1% or country %1%",nativeQuery = true)
  //  List<Cinema> readCinemaNameOrCountry(String pattern);
  //  @Query (value="select * from cinema where name like  %1% or cinema.location.country %1%",nativeQuery = true)
//    List<Cinema> readCinemaNameOrCountry(String pattern);

    //Write a native query to sort all cinemas by name
    @Query (value="select * from cinema order by name desc",nativeQuery = true)
    List<Cinema> readCinemaNameSort();


    //Write a native query to distinct all cinemas by sponsored name
   // @Query (value="select distinct sponsored_name from cinema",nativeQuery = true)
  //  List<Cinema> readDistinctCinemaSponsoredName();
}
