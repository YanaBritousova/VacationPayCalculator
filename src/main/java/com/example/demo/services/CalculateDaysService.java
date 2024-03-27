package com.example.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Arrays;
import java.util.List;
@Slf4j
@Component
public class CalculateDaysService {
    private List<MonthDay> holidaysList = Arrays.asList(
            MonthDay.of(1, 1),
            MonthDay.of(1, 2),
            MonthDay.of(1, 3),
            MonthDay.of(1, 4),
            MonthDay.of(1, 5),
            MonthDay.of(1, 6),
            MonthDay.of(1, 7),
            MonthDay.of(1, 8),
            MonthDay.of(2,23),
            MonthDay.of(3,8),
            MonthDay.of(5, 1),
            MonthDay.of(5, 9),
            MonthDay.of(5, 10),
            MonthDay.of(6, 12),
            MonthDay.of(12, 30),
            MonthDay.of(12, 31)
    );
    public int calculateDays(int days, LocalDate startVacation) {

        int daysOff = 0;

        LocalDate currentDay = startVacation;
        while (currentDay.isBefore(startVacation.plusDays(days ))) {
            MonthDay monthDay = MonthDay.of(currentDay.getMonth(), currentDay.getDayOfMonth());
            if (DayOfWeek.SATURDAY.equals(currentDay.getDayOfWeek())
                    || DayOfWeek.SUNDAY.equals(currentDay.getDayOfWeek()) || holidaysList.contains(monthDay)) {
                daysOff++;
                log.info(String.valueOf(currentDay));
            }
            currentDay = currentDay.plusDays(1);
        }


        days -= daysOff;
        return days;


    }

}

