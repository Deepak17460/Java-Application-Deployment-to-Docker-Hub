package com.nagarro.basicjavaproject.controller;

//import com.nagarro.controller.CalculatorController;
//import com.nagarro.basicjavaproject.controller.CalculatorController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;

import com.nagarro.basicjavaproject.service.CalculatorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Mock
    private CalculatorService calculatorService;

    @InjectMocks
    private CalculatorController calculatorController;

    private double a;
    private double b;

    @BeforeEach
    void setUp() {
        a = 3.0;
        b = 5.0;
    }

    @Test
    void testGetAddition() {
        double expectedResult = 8.0;

        when(calculatorService.add(a, b)).thenReturn(expectedResult);

        ResponseEntity<Double> responseEntity = calculatorController.getAddition(a, b);

        assertEquals(expectedResult, responseEntity.getBody());
    }

    @Test
    void testGetSubtraction() {
        double expectedResult = -2.0;

        when(calculatorService.subtract(a, b)).thenReturn(expectedResult);

        ResponseEntity<Double> responseEntity = calculatorController.getSubtraction(a, b);

        assertEquals(expectedResult, responseEntity.getBody());
    }

    @Test
    void testGetMultiplication() {
        double expectedResult = 15.0;

        when(calculatorService.multiply(a, b)).thenReturn(expectedResult);

        ResponseEntity<Double> responseEntity = calculatorController.getMultiplication(a, b);

        assertEquals(expectedResult, responseEntity.getBody());
    }

    @Test
    void testGetDivision() {
        double expectedResult = 0.6;

        when(calculatorService.divide(a, b)).thenReturn(expectedResult);

        ResponseEntity<Double> responseEntity = calculatorController.getDivision(a, b);

        assertEquals(expectedResult, responseEntity.getBody());
    }
}
