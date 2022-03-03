package edu.ntnu.assignment4.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Calculation {

    List<String> calculations = new ArrayList<>();

    public List<String> getCalculations() {
        return calculations;
    }

    public void setCalculations(List<String> calculations) {
        this.calculations = calculations;
    }

    public double calculate(double num1,double num2,char op){
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '/':
                return num1 / num2;
            case '*':
                return num1 * num2;
            default:
                return 0;
        }
    }
}
