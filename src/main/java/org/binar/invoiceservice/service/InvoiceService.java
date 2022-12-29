package org.binar.invoiceservice.service;

import org.binar.invoiceservice.model.Film;
import org.binar.invoiceservice.model.Schedule;
import org.binar.invoiceservice.model.Seats;
import org.binar.invoiceservice.model.UsersMovie;

/**
 * Interface service yang menghandle semua request
 * ke repository
 */
public interface InvoiceService {

     Film getFilmName(String filmName);
     Schedule getScheduleFilmByFilmName(String filmName);
     Seats getStudioSeats(Integer number, String studio);
     UsersMovie getUser(String username);


}
