package com.example.demo.controllers;


import com.example.demo.services.CalculateDaysService;
import com.example.demo.services.CalculatePayService;
import com.example.demo.responses.CalculateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@Validated
@Slf4j
public class CalculatePayController {
    private CalculateDaysService calculateDaysService;
    private CalculatePayService calculatePayService;

    public CalculatePayController(CalculateDaysService calculateDaysService, CalculatePayService calculatePayService) {
        this.calculateDaysService = calculateDaysService;
        this.calculatePayService = calculatePayService;
    }


    @GetMapping("/calculate")
    public CalculateResponse calculate(@RequestParam(value = "salary") double midSalary, @RequestParam(value="days") int days
            , @RequestParam(value = "startVacation", required = false) @DateTimeFormat(pattern="dd.MM.yyyy")LocalDate startVacation) {

        int  paidDays = days;
        if (startVacation != null) {
           paidDays = calculateDaysService.calculateDays(days,startVacation);
           log.info("cdays");
           log.info(String.valueOf(paidDays));
        }
        return calculatePayService.calculatePay(paidDays,midSalary);
    }
}
