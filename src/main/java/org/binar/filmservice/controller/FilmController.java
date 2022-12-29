package org.binar.filmservice.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.binar.filmservice.model.Film;
import org.binar.filmservice.model.Schedule;
import org.binar.filmservice.service.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmServiceImpl filmService;


    @Operation(summary = "Memperbarui nama film yang sudah terdaftar")
    @PutMapping("/update")
    public ResponseEntity updateFilm(@RequestParam("filmName") String newFilmName,
                                     @RequestParam("showing") Boolean showing,
                                     @RequestParam("filmCode") String oldFilmName) {
        try {
            filmService.updateFilm(newFilmName, showing, oldFilmName);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/new_film")
    @Operation(summary = "Menambahkan nama film baru")
    public ResponseEntity insertFilm(@RequestParam("filmName") String filmName,
                                     @RequestParam("showing") Boolean showing) {
        try {
            filmService.addNewFilm(filmName, showing);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete")
    @Operation(summary = "Menghapus film")
    public ResponseEntity deleteFilm(@RequestParam("filmName") String filmName) {

        try {
            filmService.deleteFilm(filmName);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/search_film_by_showing")
    @Operation(summary = "Menampilkan film yang sedang rilis")
    public ResponseEntity searchShowingFilm(@RequestParam("showing") Boolean showing) {
        try {
            List<Film> filmsList = filmService.showingFilm(showing);
            Map<String, List<Film>> resp = new HashMap<>();
            resp.put("Film yang sedang rilis", filmsList);
            return new ResponseEntity(resp, HttpStatus.OK);
        } catch (Exception e) {
            log.error("ERROR has been found! because {}", e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/search_schedule_by_film")
    @Operation(summary = "Menampilkan jadwal dari film tertentu")
    public ResponseEntity searchFilmSchedule(
            @RequestParam("filmCode") Integer filmCode) {
        try {
            List<Schedule> schedulesList = filmService.showingScheduleFilm(filmCode);

            Map<String, List<Schedule>> resp = new HashMap<>();
            resp.put("message", schedulesList);
            return new ResponseEntity(resp, HttpStatus.OK);
        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
