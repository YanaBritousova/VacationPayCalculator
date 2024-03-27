package com.example.demo.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CalculateResponse {
    private String message;
    private double pay;


}
