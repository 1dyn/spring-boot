package com.example.sprintcalculator.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class Calculator {

    private final ICalculator iCalculator;

    public Calculator(ICalculator iCalculator) {
        this.iCalculator = iCalculator;
    }

    public int sum(int x, int y) {
        this.iCalculator.init();
        return this.iCalculator.sum(x, y);
    }

    public int minus(int x, int y) {
        this.iCalculator.init();
        return this.iCalculator.minus(x, y);
    }

}
