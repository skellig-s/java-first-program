package com.h2;

import java.util.Map;
import java.util.Scanner;

public class BestLoanRates {
    private static final float epsilon = 0.00000001f;
    public static final Map<Integer, Float> bestRates = Map.of(1, 5.50f, 2, 3.45f, 3, 2.67f);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name");
        String name = scanner.nextLine();

        System.out.printf("Hello %s\n", name);

        System.out.println("Enter the loan term (in years)");
        int loanTermInYears = scanner.nextInt();
        float bestRate = getRates(loanTermInYears);

        System.out.println((Math.abs(bestRate) < epsilon)
                ? "No available rates for term: " + loanTermInYears + " years"
                : "Best Available Rate: " + bestRate + "%"
        );

        scanner.close();
    }

    public static float getRates(int loanTermInYears) {
        return BestLoanRates.bestRates.getOrDefault(loanTermInYears, 0.0f);
    }
}
