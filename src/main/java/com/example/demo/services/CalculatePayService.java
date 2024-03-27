package com.example.demo.services;

import com.example.demo.responses.CalculateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class CalculatePayService {
    private static final float midDays = 29.3F;
    private static final float ndfl = 0.13F;
    public CalculateResponse calculatePay(int days, double midSalary){

        double payWithoutNDFL = midSalary/midDays*days;

        double payWithNDFl = payWithoutNDFL*(1-0.13F);

        return new CalculateResponse("Сумма отпускных с учётом НДФЛ: ",payWithNDFl);
    }

}
