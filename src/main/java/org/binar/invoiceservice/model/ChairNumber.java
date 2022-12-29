package org.binar.invoiceservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

//Composite Key Field Chair Number
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChairNumber implements Serializable {
//Composite key
    @Schema(example = "A")
    private String studio;
    @Schema(example = "20")
    private Integer number;






}
