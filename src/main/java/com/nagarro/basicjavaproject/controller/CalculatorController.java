package com.nagarro.basicjavaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nagarro.basicjavaproject.service.CalculatorService;


@RestController
@RequestMapping("/calc")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;
    
    @GetMapping("/addition")
    public ResponseEntity<Double> getAddition(
            @RequestParam double a,
            @RequestParam double b) {
        double result = calculatorService.add(a, b);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/subtraction")
    public ResponseEntity<Double> getSubtraction(
            @RequestParam double a,
            @RequestParam double b) {
        double result = calculatorService.subtract(a, b);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/multiplication")
    public ResponseEntity<Double> getMultiplication(
            @RequestParam double a,
            @RequestParam double b) {
        double result = calculatorService.multiply(a, b);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/division")
    public ResponseEntity<Double> getDivision(
            @RequestParam double a,
            @RequestParam double b) {
        double result = calculatorService.divide(a, b);
        return ResponseEntity.ok(result);
    }
}
