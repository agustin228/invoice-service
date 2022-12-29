package org.binar.filmservice.model;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Schedule {
    @Id
    private Long scheduleId;
    //Relation ManyToOne with Films Entity Class (Bidirectional)
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "filmCode")
    private Film filmCode;

    @Schema(example = "12-12-2022")
    private LocalDate showDate;
    @Schema(example = "08:00")
    private LocalTime startTime;
    @Schema(example = "10:00")
    private LocalTime endTime;
    @Schema(example = "30000")
    private Long price;
}
