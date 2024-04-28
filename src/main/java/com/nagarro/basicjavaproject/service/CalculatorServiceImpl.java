package com.nagarro.basicjavaproject.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

  @Override
  public double add(double num1, double num2) {
    return num1 + num2;
  }

  @Override
  public double subtract(double num1, double num2) {
    return num1 - num2;
  }

  @Override
  public double multiply(double num1, double num2) {
    return num1 * num2;
  }

  @Override
  public double divide(double num1, double num2) throws ArithmeticException {
    if (num2 == 0) {
      throw new ArithmeticException("Division by zero");
    }
    return num1 / num2;
  }
}
