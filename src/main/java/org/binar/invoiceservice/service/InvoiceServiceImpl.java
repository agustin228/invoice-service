package org.binar.invoiceservice.service;

import lombok.extern.slf4j.Slf4j;
import org.binar.invoiceservice.model.Film;
import org.binar.invoiceservice.model.Schedule;
import org.binar.invoiceservice.model.Seats;
import org.binar.invoiceservice.model.UsersMovie;
import org.binar.invoiceservice.repository.FilmRepository;
import org.binar.invoiceservice.repository.SchedulesRepository;
import org.binar.invoiceservice.repository.SeatsRepository;
import org.binar.invoiceservice.repository.UsersMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Kelas implementasi invoice service yang menghandle semua request
 * ke repository
 * @author Agustinus
 */
@Slf4j
@Service
public class InvoiceServiceImpl implements  InvoiceService {

    @Autowired
    FilmRepository filmRepo;
    @Autowired
    UsersMovieRepository userRepo;
    @Autowired
    SchedulesRepository schedRepo;
    @Autowired
    SeatsRepository seatRepo;


    @Override
    public Film getFilmName(String filmName) {
        return filmRepo.getFilmName(filmName).get(0);
    }

    @Override
    public Schedule getScheduleFilmByFilmName(String filmName) {
        return schedRepo.getFilmSchedule(filmName);
    }

    @Override
    public Seats getStudioSeats(Integer number, String studio) {
        return seatRepo.getChairNumber(number, studio);
    }

    @Override
    public UsersMovie getUser(String username) {
        try{
            UsersMovie consumer =  userRepo.getUsername(username);
            return consumer;
        }catch (Exception e){
            log.error("ERROR has been found! because : {}", e.getMessage());
            return null;
        }
    }
}
