package org.camunda.bpm.getstarted.loanapproval.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "production_сalendar")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductionСalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long Id;

    @Column(name = "day_Of", nullable = true)
    private String dayOff;

    @Column(name = "day_of_date", nullable = false)
    private LocalDate dayOffDate;
}
