package org.binar.invoiceservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    @Id
    @Cascade(CascadeType.ALL)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filmCode;
    @Column(name = "film_name")
    private String filmName;
    @Column(name = "is_showing")
    private Boolean isShowing;



}
