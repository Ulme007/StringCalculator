package com.epost.katas.stringcalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroForEmptyString() throws Exception {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int result = stringCalculator.add("");

        // then
        assertEquals(0, result);
    }

    @Test
    public void shouldReturnOneForOnlyOneNumberOne() throws Exception {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int result = stringCalculator.add("1");

        // then
        assertEquals(1, result);
    }

    @Test
    public void shouldReturnOneForOnlyOneNumberTwo() throws Exception {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int result = stringCalculator.add("2");

        // then
        assertEquals(2, result);
    }
}
