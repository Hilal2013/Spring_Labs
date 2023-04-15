package com.cydeo;

import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;



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
      //  System.out.println(accountRepository.findByAddressContaining("an"));
       // System.out.println(accountRepository.findByAddressContainingIgnoreCase("loch"));
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
       // System.out.println(cinemaRepository.readCinemaNameSort());
       // System.out.println(cinemaRepository.readDistinctCinemaSponsoredName());

        System.out.println("-----------Genre-----------");
     //   System.out.println(genreRepository.getAllGenres());
     //   System.out.println(genreRepository.getGenresContainingName("Comedy"));

        System.out.println("-----------MOVIECINEMA-----------");
        System.out.println(movieCinemaRepository.countByCinemaId(1L));
        System.out.println(movieCinemaRepository.readById(3l));


     //   System.out.println(movieCinemaRepository.findByDateTimeGreaterThan(LocalDateTime.of(2022,12,7,20,00,00)));

      //  System.out.println(movieCinemaRepository.findTop3ByMoviePrice());

      //  System.out.println(movieCinemaRepository.countMovies(3l));

        System.out.println(ticketRepository.countByUserAccountId(3l));

    }
}
