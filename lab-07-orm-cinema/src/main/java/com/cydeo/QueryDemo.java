package com.cydeo;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Component
public class QueryDemo implements CommandLineRunner {
    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;


      private final GenreRepository genreRepository;
  private final MovieCinemaRepository movieCinemaRepository;
    private final MovieRepository movieRepository;
    private final  TicketRepository ticketRepository;
   private  final UserRepository userRepository;

    public QueryDemo(AccountRepository accountRepository, CinemaRepository cinemaRepository, GenreRepository genreRepository, MovieCinemaRepository movieCinemaRepository, MovieRepository movieRepository, TicketRepository ticketRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.genreRepository = genreRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.movieRepository = movieRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----------ACCOUNT-----------");
     //   System.out.println(accountRepository.findByCountryOrState("Brooklyn","Kentucky"));
      //  System.out.println(accountRepository.findByAgeLessThanEqual(35));
      //  System.out.println(accountRepository.findByAgeBetween(28,47));
      //  System.out.println(accountRepository.findByAddressStartsWith("262"));
      //  System.out.println(accountRepository.findByOrderByAgeDesc());
     //   System.out.println(accountRepository.getAccountAdmin());//no admin
     //   System.out.println(accountRepository.getAccountSortAge());
      //  System.out.println(accountRepository.readAccountAllAgeHigher(35));
      //  System.out.println(accountRepository.readAccountAgeLowerValue(35));
      //  System.out.println(accountRepository.readAccountContainsNameAddressCountryStateCity("a"));

        System.out.println("-----------CINEMA-----------");
     //  System.out.println(cinemaRepository.findByName("Hall 1 - VILLAGE 7"));
     //System.out.println(cinemaRepository.findTop3BySponsoredNameContainingOrderByNameAsc("MySpace"));
     //   System.out.println(cinemaRepository.getCinemaCountry("United States"));
      //  System.out.println(cinemaRepository.findByLocationCountry("United States"));
        //System.out.println(cinemaRepository.readCinema("S"));
      //  System.out.println(cinemaRepository.readCinemaLocationCountry("United States"));
      //  System.out.println(cinemaRepository.readCinemaNameOrSponsoredName("S"));
       // System.out.println(cinemaRepository.readCinemaNameSort());
     //   System.out.println(cinemaRepository.readDistinctCinemaSponsoredName("MySpace"));

        System.out.println("-----------Genre-----------");
     //   System.out.println(genreRepository.getAllGenres());
     //   System.out.println(genreRepository.getGenresContainingName("Comedy"));

        System.out.println("-----------MOVIECINEMA-----------");
    //    System.out.println(movieCinemaRepository.countByCinemaId(1L));
   //     System.out.println(movieCinemaRepository.readById(3l));
     //   System.out.println(movieCinemaRepository.getAllMoviesLocation("AMC Empire 2"));
     //   System.out.println(movieCinemaRepository.findByDateTimeGreaterThan(LocalDateTime.of(2022,12,7,20,00,00)));
     //   System.out.println(movieCinemaRepository.findTop3ByMoviePrice());
     //   System.out.println(movieCinemaRepository.findTop3ByOrderByMoviePriceDesc());
     //   System.out.println(movieCinemaRepository.countMovies(3l));//1
    //    System.out.println(movieCinemaRepository.getAllMoviesLocation("AMC Empire 25"));

        System.out.println("-----------MOVIE-----------");

   //     System.out.println(movieRepository.findByName("The Gentleman"));
     //   System.out.println(movieRepository.findByPriceBetweenOrderByPrice(new BigDecimal(15),new BigDecimal(28)));
     //   System.out.println(movieRepository.findByDurationIn(List.of(113,135)));
     //   System.out.println(movieRepository.findByStateAndType(MovieState.DRAFT, MovieType.REGULAR));
      //  System.out.println(movieRepository.getByPriceBetween(new BigDecimal(15),new BigDecimal(28)));
     //   System.out.println(movieRepository.getMovieName());
     //   System.out.println(movieRepository.readMovieName("Tenet"));
     //   System.out.println(movieRepository.readByPriceBetween(new BigDecimal(15),new BigDecimal(28)));
      //  System.out.println(movieRepository.getMoviesDurationRange(113,142));
     //   System.out.println(movieRepository.listTopMovies());

        System.out.println("-----------TICKET-----------");

      //  System.out.println(ticketRepository.countByUserAccountId(3l));//4
      //  System.out.println(ticketRepository.findByUserAccountEmail("'bernard@email.com"));
      //  System.out.println(ticketRepository.countByMovieCinemaId(1l));//5
      //  System.out.println(ticketRepository.findByDateTimeBetween(LocalDateTime.of(2020,12,05,20,00),LocalDateTime.of(2020,12,07,21,30)));//5
   //     System.out.println(ticketRepository.getTicketUser(3l));
   //     System.out.println(ticketRepository.getTicketsDatesBetween(LocalDateTime.of(2020,12,05,20,00),LocalDateTime.of(2020,12,07,21,30)));
      //  System.out.println(ticketRepository.countUserAccountId(3l));
    //    System.out.println(ticketRepository.retrieveAllBySearchCriteria("a"));
        System.out.println("-----------USER-----------");

     //   System.out.println(userRepository.findByEmail("johnnie@email.com"));
     //   System.out.println(userRepository.findByAccountAgeGreaterThan(35));
     //   System.out.println(userRepository.getUserMail("johnnie@email.com"));

    }
}
