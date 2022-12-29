package org.binar.filmservice.service;

import lombok.extern.slf4j.Slf4j;
import org.binar.filmservice.model.Film;
import org.binar.filmservice.model.Schedule;
import org.binar.filmservice.repository.FilmRepository;
import org.binar.filmservice.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class FilmServiceImpl implements FilmService{

    @Autowired
    FilmRepository filmsRepo;
    @Autowired
    ScheduleRepository schedRepo;

    /**
     * Method untuk menambahkan film baru
     * @param filmName parameter untuk nama/judul film
     * @param showing
     */
    @Override
    public void addNewFilm(String filmName, Boolean showing) {

        try {
            filmsRepo.insertFilmToDb(filmName, showing);
        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
        }
    }

    //Service Mengupdate film
    @Override
    public void updateFilm(String newFilmName, Boolean showing, String oldFilmName) {
        try {
            filmsRepo.updateFilmToDb(newFilmName, showing, oldFilmName);
        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
        }
    }

    //Service Menghapus film
    @Override
    public void deleteFilm(String filmName) {
        try {
            filmsRepo.deleteFilmFromDb(filmName);
        }catch (Exception e){
            log.error("ERROR has been found because : {}", e.getMessage());
        }

    }

    //Service Menampilkan film yang sedang tayang
    @Override
    public List<Film> showingFilm(Boolean showing) {
        try{
            List<Film> filmList = filmsRepo.findFilmByShowing(showing);
            return filmList;
        }catch (Exception e){
            log.error("ERROR has been found! because : {}", e.getMessage());
            return null;
        }

    }

    //Service Menampilkan jadwal dari film tertentu
    @Override
    public List<Schedule> showingScheduleFilm(Integer filmCode) {
        try{
            List<Schedule> schedulesList = schedRepo.findScheduleByFilmCode(filmCode);
            return schedulesList;
        } catch (Exception e){
            log.error("ERROR has been found! because : {}", e.getMessage());
            return null;
        }
    }
}
