package org.binar.filmservice.repository;

import org.binar.filmservice.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(value = "select start_time, end_time, show_date where film_code=?1", nativeQuery = true)
    public List<Schedule> findScheduleByFilmCode(Integer filmCode);

    @Query(value = "select * from schedules sc inner join films f on f.film_code = sc.film_code where film_name = :filmName", nativeQuery = true)
    Schedule getFilmSchedule(@Param("filmName")String filmName);

}
