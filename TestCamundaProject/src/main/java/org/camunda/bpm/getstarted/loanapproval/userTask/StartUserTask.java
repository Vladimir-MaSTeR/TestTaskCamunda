package org.camunda.bpm.getstarted.loanapproval.userTask;


import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.getstarted.loanapproval.model.ProductionСalendar;
import org.camunda.bpm.getstarted.loanapproval.repository.ProductionСalendarRepository;
import org.camunda.bpm.getstarted.loanapproval.utils.ConvertDateTimeUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class StartUserTask implements TaskListener {

    private static final Long N_DAYS_PLUS_TO_DATE = 6L;
    private final ProductionСalendarRepository productionСalendarRepository;

    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("Процесс StartUserTask стартовал");

        Date startProcessDate = delegateTask.getCreateTime();
        LocalDateTime localDateTime = ConvertDateTimeUtils
                .convertToLocalDateTime(startProcessDate)
                .plusDays(N_DAYS_PLUS_TO_DATE);

        LocalDateTime localDateTimeToNewTime = ConvertDateTimeUtils.getWorkTime(localDateTime);

        LocalDateTime localDateTimeResult = checkDate(localDateTimeToNewTime);
        Date resultDate = ConvertDateTimeUtils.convertToDate(localDateTimeResult);

        delegateTask.setDueDate(resultDate);
        System.out.println("Процесс StartUserTask закончен");
    }

    private LocalDateTime checkDate(LocalDateTime localDateTime) {
        System.out.println("Проверка даты: Начата");
        LocalDateTime result = localDateTime;
        ProductionСalendar productionСalendar = productionСalendarRepository.findByDayOffDate(result.toLocalDate());

        if (Objects.isNull(productionСalendar)) {
            System.out.println("Проверка даты: Закончена - конечная дата сформирована = " + result.toString());
            return result;
        }

        System.out.println("Проверка даты: Дата найдена");
        return result = checkDate(result.plusDays(1L));
    }
}
