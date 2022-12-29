package org.binar.filmservice.service;

import org.binar.filmservice.model.Film;
import org.binar.filmservice.model.Schedule;


import java.util.List;

public interface FilmService {

    //Service menambahkan film baru
    void addNewFilm(String filmName, Boolean showing);
    //Service mengupdate nama film
    void updateFilm(String newFilmName, Boolean showing, String oldFilmName);
    //Service menghapus film
    void deleteFilm(String filmName);
    //Service menampilkan film yang sedang tayang
    List<Film> showingFilm(Boolean showing);
    //Service menampilkan jadwal dari film tertentu
    List<Schedule> showingScheduleFilm(Integer filmCode);



}
