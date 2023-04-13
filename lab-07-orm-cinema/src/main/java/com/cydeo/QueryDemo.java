package com.cydeo;

import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


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
        System.out.println(accountRepository.findByCountryOrState("Brooklyn","Kentucky"));
        System.out.println(accountRepository.findByAgeLessThanEqual(35));
        System.out.println(cinemaRepository.findByName("The Godfather"));
    }
}
