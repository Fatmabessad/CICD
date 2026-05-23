package com.lab;
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    // A slightly "messy" method so SonarQube has something to analyze
    public void unusedMethod() {
        int unusedVariable = 10;
        System.out.println("This method is never used and violates clean code rules!");
    }
}
