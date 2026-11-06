package com.example.lab.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    private final CalculatorService service = new CalculatorService();

    @Test
    void addNegativeAndPositive() {
        assertEquals(0, service.add(-5, 5));
    }

    @Test
    void addTwoNegatives() {
        assertEquals(-10, service.add(-3, -7));
    }

    @Test
    void addLargeNumbers() {
        assertEquals(2000000, service.add(1000000, 1000000));
    }
}