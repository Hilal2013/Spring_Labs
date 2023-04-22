package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    int countByUserAccountId(Long id);

    //Write a derived query to list all tickets by specific email
    List<Ticket> findByUserAccountEmail(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
    int countByMovieCinemaId(Long id);

    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findByDateTimeBetween(LocalDateTime start, LocalDateTime end);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
@Query("select t from Ticket t where t.userAccount.id=?1")
    List<Ticket> getTicketUser( @Param("id")Long id);
    //Write a JPQL query that returns all tickets between a range of dates
@Query("select t from Ticket t where t.dateTime between ?1 and ?2")
    List<Ticket> getTicketsDatesBetween(@Param("startDate")LocalDateTime startDate,@Param("endDate") LocalDateTime endDate);
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
   @Query(value="select count(*) from ticket t join user_account u on t.user_acoount_id=u.id where u.id=?1",nativeQuery = true)
    int countUserAccountId(@Param("id")Long id);


    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value=" select count(*) from ticket  where datetime between ?1 and ?2", nativeQuery = true)
    int countTicketsUserDate(@Param("startDate")LocalDateTime startDate,@Param("endDate")LocalDateTime endDate);

    //Write a native query to distinct all tickets by movie name

@Query(value="select distinct m.name  from ticket t join movie_cinema mc on t.movie_cinema_id=mc.id join movie m on  ",nativeQuery = true)
    List<Ticket> distinctTicketsMovieName();
    //Write a native query to find all tickets by user email
    @Query(value="select * from ticket t join user_account u on t.user_acoount_id=u.id where u.username=?1",nativeQuery = true)
    List<Ticket> getTicketsUserEmail(@Param("username")String username);

    //Write a native query that returns all tickets
    @Query(value="select * from ticket",nativeQuery = true)
    List<Ticket> getAllTickets();
    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name

    @Query(value=" select * from ticket t join user_account u on t.user_acoount_id=u.id " +
            "join account_details a on u.accoun_details_id=a.id join movie_cinema mc on t.movie_cinema_id=mc.id join movie m on mc.movie_id=m.id where u.username ILIKE concat('%',?1,'%')" +
            "OR a.name account_details OR m.name account_details ILIKE concat('%',?1,'%') ",nativeQuery = true)
    List<Ticket> allTicketsContainsValue(@Param("pattern") String pattern);
}
