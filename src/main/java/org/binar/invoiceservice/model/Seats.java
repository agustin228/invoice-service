package org.binar.invoiceservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Kelas untuk memodelkan table/entity seats
 * @author Agustinus
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Seats {
    @EmbeddedId
    private ChairNumber chairNumber;
    @Schema(example = "Studio A")
    private String studioName;


}
