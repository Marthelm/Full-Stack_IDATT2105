package edu.ntnu.backend.model;

public class Calculation {
    private int id;
    private double num1;
    private double num2;
    private char op;
    private double sol;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Calculation(){

    }

    public Calculation(double num1, double num2, char op, double sol, String username) {
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
        this.sol = sol;
        this.username = username;
    }

    public Calculation(int id, double num1, double num2, char op, double sol, String username) {
        this.id = id;
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
        this.sol = sol;
        this.username = username;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public double getSol() {
        return sol;
    }

    public void setSol(double sol) {
        this.sol = sol;
    }

    @Override
    public String toString() {
        return "Calculation{" +
                "id=" + id +
                ", num1=" + num1 +
                ", num2=" + num2 +
                ", op=" + op +
                ", sol=" + sol +
                '}';
    }
}
