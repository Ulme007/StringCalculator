package com.epost.katas.stringcalculator;


import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String DEFAULT_DELIMITER = ",";

    public int add(String expression) throws Exception {
        if (expression.isEmpty()) {
            return 0;
        }
        String delimiter = DEFAULT_DELIMITER;
        if (hasDelimiter(expression)) {
            delimiter = getDelimiter(expression);
            expression = extractExpression(expression);
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

    private boolean hasDelimiter(String expression) {
        return expression.startsWith("//");
    }

    private String extractExpression(String expression) {
        return expression.substring(expression.indexOf("\n")+1, expression.length());
    }

    private String getDelimiter(String expression) {
        Pattern p = Pattern.compile( "//\\[?(.+)\\]?" );
        Matcher m = p.matcher( expression );
        String delimiter = null;

        if(m.find()) {
            delimiter = m.group(1);
        }
        return delimiter;
    }
}
