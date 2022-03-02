package edu.ntnu.assignment4.model;

public class Equation {
    private double num1;
    private double num2;
    private char op;
    private double solution;

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public double getSolution() {
        return solution;
    }

    public void setSolution(double solution) {
        this.solution = solution;
    }

    @Override
    public String toString() {
        return this.num1  + " " + this.op + " " + this.num2 + " = " + this.solution;
    }
}
