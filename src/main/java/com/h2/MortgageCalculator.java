package com.h2;

import javax.print.attribute.standard.PrinterMoreInfoManufacturer;
import java.text.DecimalFormat;
import java.util.logging.Logger;

public class MortgageCalculator {
    private long loanAmount;
    private int termInYears;
    private float annualRate;
    private double monthlyPayment;

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;
    }

    private int getNumberOfPayments() {
        return termInYears * 12;
    }

    private float getMonthlyInterestRate() {
        float interestRate = annualRate / 100;
        return interestRate / 12;
    }

    public void calculateMonthlyPayment() {
        long P = loanAmount;
        float r = getMonthlyInterestRate();
        int n = getNumberOfPayments();
        monthlyPayment = P * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1));
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return "monthlyPayment: " + df.format(monthlyPayment);
    }

    public static void main(String[] args) {
        MortgageCalculator calculator = new MortgageCalculator(
            1000000, 30, 5.99f
        );
        calculator.calculateMonthlyPayment();
        System.out.println(calculator.toString());
    }
}
