package org.camunda.bpm.getstarted.loanapproval.repository;


import org.camunda.bpm.getstarted.loanapproval.model.ProductionСalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface ProductionСalendarRepository extends JpaRepository<ProductionСalendar, Integer> {

    ProductionСalendar findByDayOffDate(LocalDate holidayDate);

}
