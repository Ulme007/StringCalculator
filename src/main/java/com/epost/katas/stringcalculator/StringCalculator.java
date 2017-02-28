package com.epost.katas.stringcalculator;


import java.util.StringTokenizer;

public class StringCalculator {

    public int add(String expression) {
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
        while (stringTokenizer.hasMoreTokens()) {
            String value = stringTokenizer.nextToken();
            int summand = Integer.parseInt(value);
            sum = summand + sum;

        }
        return sum;
    }
}
