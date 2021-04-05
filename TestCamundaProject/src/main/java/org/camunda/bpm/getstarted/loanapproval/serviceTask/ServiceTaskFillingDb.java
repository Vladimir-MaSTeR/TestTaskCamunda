package org.camunda.bpm.getstarted.loanapproval.serviceTask;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.getstarted.loanapproval.service.ProductionСalendarService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ServiceTaskFillingDb implements JavaDelegate {

    private final DateTimeFormatter FORMATTER = DateTimeFormatter
            .ofPattern("dd.MM.yyyy", Locale.forLanguageTag("ru"));

    private final ProductionСalendarService productionСalendarService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Процесс ServiceTaskFillingDb начат");

        addDb();

        System.out.println("Процесс ServiceTaskFillingDb закончен");
    }

    public void addDb() {
        System.out.println("Заполнение базы данных: Начато");
        Map<String, String> holidays2021 = ProductionCalendarMap();

        for (Map.Entry<String, String> entry : holidays2021.entrySet()) {
            productionСalendarService.addProductionСalendar(entry.getValue(), LocalDate.parse(entry.getKey(), FORMATTER));
        }
        System.out.println("Заполнение базы данных: Закончено");
    }

    public Map<String, String> ProductionCalendarMap() {
        System.out.println("Заполнение производственного каллендаря");
        Map<String, String> result = new HashMap<>();

        result.put("01.01.2021", "Новогодние праздники");
        result.put("04.01.2021", "Новогодние праздники");
        result.put("05.01.2021", "Новогодние праздники");
        result.put("06.01.2021", "Новогодние праздники");
        result.put("07.01.2021", "Новогодние праздники");
        result.put("08.01.2021", "Новогодние праздники");
        result.put("09.01.2021", "Суббота");
        result.put("10.01.2021", "Воскресенье");
        result.put("02.01.2021", "Суббота");
        result.put("03.01.2021", "Воскресенье");
        result.put("16.01.2021", "Суббота");
        result.put("17.01.2021", "Воскресенье");
        result.put("23.01.2021", "Суббота");
        result.put("24.01.2021", "Воскресенье");
        result.put("30.01.2021", "Суббота");
        result.put("31.01.2021", "Воскресенье");

        result.put("06.02.2021", "Суббота");
        result.put("07.02.2021", "Воскресенье");
        result.put("13.02.2021", "Суббота");
        result.put("14.02.2021", "Воскресенье");
        result.put("21.02.2021", "Воскресенье");
        result.put("22.02.2021", "День защитника отечества");
        result.put("23.02.2021", "День защитника отечества");
        result.put("27.02.2021", "Суббота");
        result.put("28.02.2021", "Воскресенье");

        result.put("06.03.2021", "Суббота");
        result.put("07.03.2021", "Воскресенье");
        result.put("08.03.2021", "Международный женский день");
        result.put("13.03.2021", "Суббота");
        result.put("14.03.2021", "Воскресенье");
        result.put("20.03.2021", "Суббота");
        result.put("21.03.2021", "Воскресенье");
        result.put("27.03.2021", "Суббота");
        result.put("28.03.2021", "Воскресенье");

        result.put("03.04.2021", "Суббота");
        result.put("04.04.2021", "Воскресенье");
        result.put("10.04.2021", "Суббота");
        result.put("11.04.2021", "Воскресенье");
        result.put("17.04.2021", "Суббота");
        result.put("18.04.2021", "Воскресенье");
        result.put("24.04.2021", "Суббота");
        result.put("25.04.2021", "Воскресенье");

        result.put("01.05.2021", "Суббота");
        result.put("02.05.2021", "Воскресенье");
        result.put("03.05.2021", null);
        result.put("08.05.2021", "Суббота");
        result.put("09.05.2021", "Воскресенье");
        result.put("10.05.2021", "Празднование дня победы");
        result.put("15.05.2021", "Суббота");
        result.put("16.05.2021", "Воскресенье");
        result.put("22.05.2021", "Суббота");
        result.put("23.05.2021", "Воскресенье");
        result.put("29.05.2021", "Суббота");
        result.put("30.05.2021", "Воскресенье");

        result.put("05.06.2021", "Суббота");
        result.put("06.06.2021", "Воскресенье");
        result.put("12.06.2021", "Суббота");
        result.put("13.06.2021", "Воскресенье");
        result.put("14.06.2021", null);
        result.put("19.06.2021", "Суббота");
        result.put("20.06.2021", "Воскресенье");
        result.put("26.06.2021", "Суббота");
        result.put("27.06.2021", "Воскресенье");

        result.put("03.07.2021", "Суббота");
        result.put("04.07.2021", "Воскресенье");
        result.put("10.07.2021", "Суббота");
        result.put("11.07.2021", "Воскресенье");
        result.put("17.07.2021", "Суббота");
        result.put("18.07.2021", "Воскресенье");
        result.put("24.07.2021", "Суббота");
        result.put("25.07.2021", "Воскресенье");
        result.put("31.07.2021", "Суббота");

        result.put("31.08.2021", "Воскресенье");
        result.put("07.08.2021", "Суббота");
        result.put("08.08.2021", "Воскресенье");
        result.put("14.08.2021", "Суббота");
        result.put("15.08.2021", "Воскресенье");
        result.put("21.08.2021", "Суббота");
        result.put("22.08.2021", "Воскресенье");
        result.put("28.08.2021", "Суббота");
        result.put("29.08.2021", "Воскресенье");

        result.put("04.09.2021", "Суббота");
        result.put("05.09.2021", "Воскресенье");
        result.put("11.09.2021", "Суббота");
        result.put("12.09.2021", "Воскресенье");
        result.put("18.09.2021", "Суббота");
        result.put("19.09.2021", "Воскресенье");
        result.put("25.09.2021", "Суббота");
        result.put("26.09.2021", "Воскресенье");

        result.put("02.10.2021", "Суббота");
        result.put("03.10.2021", "Воскресенье");
        result.put("09.10.2021", "Суббота");
        result.put("10.10.2021", "Воскресенье");
        result.put("16.10.2021", "Суббота");
        result.put("17.10.2021", "Воскресенье");
        result.put("23.10.2021", "Суббота");
        result.put("24.10.2021", "Воскресенье");
        result.put("30.10.2021", "Суббота");
        result.put("31.10.2021", "Воскресенье");

        result.put("04.11.2021", null);
        result.put("05.11.2021", null);
        result.put("06.11.2021", "Суббота");
        result.put("07.11.2021", "Воскресенье");
        result.put("13.11.2021", "Суббота");
        result.put("14.11.2021", "Воскресенье");
        result.put("20.11.2021", "Суббота");
        result.put("21.11.2021", "Воскресенье");
        result.put("27.11.2021", "Суббота");
        result.put("28.11.2021", "Воскресенье");

        result.put("04.12.2021", "Суббота");
        result.put("05.12.2021", "Воскресенье");
        result.put("11.12.2021", "Суббота");
        result.put("12.12.2021", "Воскресенье");
        result.put("18.12.2021", "Суббота");
        result.put("19.12.2021", "Воскресенье");
        result.put("25.12.2021", "Суббота");
        result.put("26.12.2021", "Воскресенье");
        result.put("31.12.2021", "Новый Год");

        System.out.println("Производственный каллендарь заполнен");
        return result;
    }
}
