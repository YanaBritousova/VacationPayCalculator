package com.example.demo.controllers;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatePayControllerTest extends TestCase {
    @Autowired
    private CalculatePayController calculatePayController;

    @Test
    public void testCalculate() {
        Assertions.assertEquals(calculatePayController.calculate(30000,10, LocalDate.of(2024,3,27)).getPay(),((double)30000/29.3F*8)*(1-0.13F));
        Assertions.assertEquals(calculatePayController.calculate(30000,10, LocalDate.of(2024,5,7)).getPay(),((double)30000/29.3F*6)*(1-0.13F));

    }
}