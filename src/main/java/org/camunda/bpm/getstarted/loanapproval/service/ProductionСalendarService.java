package org.camunda.bpm.getstarted.loanapproval.service;

import java.time.LocalDate;

public interface ProductionСalendarService {

    void addProductionСalendar(String dayOff, LocalDate dayOffDate);
}
