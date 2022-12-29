package org.binar.filmservice.repository;

import org.binar.filmservice.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    @Modifying
    @Query(value = "insert into films (film_name, showing) values (?1, ?2)", nativeQuery = true)
    void insertFilmToDb(String filmName, Boolean showing);

    //Service showingFilm
    @Query(value = "select film_name from films where showing = :showing", nativeQuery = true)
    List<Film> findFilmByShowing(@Param("showing") Boolean showing);

    //Service deleteFilm
    @Modifying
    @Query(value = "delete from films f where f.film_name = :filmName", nativeQuery = true)
    void deleteFilmFromDb(@Param("filmName") String filmName);

    //Service updateFilm
    @Modifying
    @Query(value = "update films set film_name = :filmName, showing = :showing where film_code = :filmName", nativeQuery = true)
    void updateFilmToDb(@Param("filmName") String newfilmName, @Param("showing") Boolean showing, @Param("filmName") String oldfilmName);

    @Query(value = "select * from films where film_name = :filmName", nativeQuery = true)
    List<Film> getFilmName(@Param("filmName") String filmName);
}
