package com.example.lab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab.service.CalculatorService;

@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/ms1/add")
    public String add(@RequestParam int a, @RequestParam int b) {
        return "MS 1.1 - Additon = " + calculatorService.add(a, b);
    }
}