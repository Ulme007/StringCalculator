package com.epost.katas.stringcalculator;


import java.util.StringTokenizer;

public class StringCalculator {

    public int add(String expression) throws Exception {
        if (expression.isEmpty()) {
            return 0;
        }
        String delimiter = ",";
        if (expression.startsWith("//")) {
            delimiter = expression.substring(2, 3);
            expression = expression.substring(4);
        }

        expression = expression.replaceAll("\n", delimiter);
        StringTokenizer stringTokenizer = new StringTokenizer(expression, delimiter);

        int sum = 0;
        String negativeNumbers = "";
        while (stringTokenizer.hasMoreTokens()) {
            int summand = Integer.parseInt(stringTokenizer.nextToken());
            if (summand < 0) {
                negativeNumbers += summand + ",";
            } else if (summand <= 1000) {
                sum += summand;
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new Exception("Negatives not allowed: " + negativeNumbers.substring(0, negativeNumbers.length() - 1));
        }
        return sum;
    }
}
