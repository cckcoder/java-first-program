package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
    private final float[] credits;
    private final float[] debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }

    private float sumOfCredits() {
        float sum = 0.0f;
        for (float c : this.credits) sum += c;
        return sum;
    }

    private float sumOfDebits() {
        float sum = 0.0f;
        for (float d : this.debits) sum += d;
        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date) {
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDayInMonth = yearMonth.lengthOfMonth();
        return totalDayInMonth - date.getDayOfMonth();
    }

    public float calculate() {
        return sumOfDebits() - sumOfCredits();
    }

    public static void main(String[] args) {
        String[] creditsAsString = args[0].split(",");
        String[] debitAsString = args[1].split(",");

        float[] credit = new float[creditsAsString.length];
        float[] debit = new float[debitAsString.length];

        for (int i = 0; i < creditsAsString.length; i++) {
            credit[i] = Float.parseFloat(creditsAsString[i]);
        }

        for (int i = 0; i < debitAsString.length; i++) {
            debit[i] = Float.parseFloat(debitAsString[i]);
        }

        SavingsCalculator calculator = new SavingsCalculator(credit, debit);
        float netSavings = calculator.calculate();
        System.out.println(
            "Net Savings = "
                + netSavings +
                ", remaining days in month = " +
                remainingDaysInMonth(LocalDate.now())
        );
    }
}
