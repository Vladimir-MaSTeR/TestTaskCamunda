package org.camunda.bpm.getstarted.loanapproval.service;


import lombok.RequiredArgsConstructor;
import org.camunda.bpm.getstarted.loanapproval.model.ProductionСalendar;
import org.camunda.bpm.getstarted.loanapproval.repository.ProductionСalendarRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ProductionСalendarServiceImpl implements ProductionСalendarService {

    //    @Autowired
    private final ProductionСalendarRepository productionСalendarRepository;

    @Override
    public void addProductionСalendar(String dayOff, LocalDate dayOffDate) {
        ProductionСalendar holiday = ProductionСalendar.builder()
                .dayOff(dayOff)
                .dayOffDate(dayOffDate)
                .build();

        productionСalendarRepository.save(holiday);
    }
}
