package org.binar.invoiceservice.repository;


import org.binar.invoiceservice.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Interface repository untuk menghandle semua request ke table schedule di database
 * @author Agustinus Banjarnahor
 */
@Transactional
@Repository
public interface SchedulesRepository extends JpaRepository<Schedule, Long> {

    @Query(value = "select start_time, end_time, show_date where film_code=?1", nativeQuery = true)
    public List<Schedule> findScheduleByFilmCode(Integer filmCode);

    @Query(value = "select * from schedules sc inner join films f on f.film_code = sc.film_code where film_name = :filmName", nativeQuery = true)
    Schedule getFilmSchedule(@Param("filmName")String filmName);


}
