package com.h2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BestLoanRates {
    public static Map<Integer, Float> bestRates = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initValue();
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);
        System.out.println("Enter the loan term (in years)");
        int loanTermInYears = scanner.nextInt();
        if (getRates(loanTermInYears) == 0.0f) {
            System.out.println(
                "No available rates for term: "
                    + loanTermInYears + " years"
            );
        }
        System.out.println(
            "Best Available Rate: "
                + getRates(loanTermInYears)
                + "%"
        );

        scanner.close();
    }

    public static void initValue() {
        bestRates.put(1, 5.50f);
        bestRates.put(2, 3.45f);
        bestRates.put(3, 2.67f);
    }

    public static float getRates(int loanTermInYears) {
        if (!bestRates.containsKey(loanTermInYears)) {
            return 0.0f;
        }
        return bestRates.get(loanTermInYears);
    }

}
