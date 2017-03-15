package com.epost.katas.stringcalculator;

import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

    @Test
    public void shouldReturnThreeForNumberOneAndTwo() throws Exception {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int result = stringCalculator.add("1,2");

        // then
        assertEquals(3, result);
    }

    @Test
    public void shouldReturnSixForNumberOneAndTwoANDThree() throws Exception {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int result = stringCalculator.add("1,2,3");

        // then
        assertEquals(6, result);
    }

    @Test
    public void shouldReturnSixForNumberOneAndTwoANDThreeWithNewline() throws Exception {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int result = stringCalculator.add("1\n2,3");

        // then
        assertEquals(6, result);
    }

    @Test
    public void shouldReturnThreeForCustomDelimiterAndOneTwo() throws Exception {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int result = stringCalculator.add("//;\n1;2");

        // then
        assertEquals(3, result);
    }

    @Test
    public void shouldReturnOneForCustomDelimiterAndOne() throws Exception {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int result = stringCalculator.add("//;\n1");

        // then
        assertEquals(1, result);
    }

    @Test
    public void shouldReturnZeroForCustomDelimiter() throws Exception {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int result = stringCalculator.add("//;\n");

        // then
        assertEquals(0, result);
    }


    @Test
    public void shouldThrowExceptionAndErrorMessageWithNumbersWhenNumberNegative() throws Exception {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        Exception exception = null;

        // when
        try {
            stringCalculator.add("-1");
            fail();
        } catch (Exception ex) {
            exception = ex;
        }

        // then
        assertNotNull(exception);
        assertEquals("Negatives not allowed: -1", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionAndErrorMessageWithTwoNumbersWhenNumbersNegative() throws Exception {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        try {
            // when
            stringCalculator.add("-1,-2");
            fail();
        } catch (Exception ex) {
            // then
            assertEquals("Negatives not allowed: -1,-2", ex.getMessage());
        }
    }

    @Test
    public void shouldThrowExceptionAndErrorMessageWithOneNegativeAndOnePositiveNumber() throws Exception {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        try {
            // when
            stringCalculator.add("-3,1,-2");
            fail();
        } catch (Exception ex) {
            // then
            assertEquals("Negatives not allowed: -3,-2", ex.getMessage());
        }
    }

    @Test
    public void shouldIgnoreNumberBiggerOT() throws Exception {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int result = stringCalculator.add("2,1001");

        // then
        assertEquals(2, result);
    }

    @Test
    public void shouldWorksWithDelimiterWithAnyLength() throws Exception {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int result = stringCalculator.add("//[***]\n1***2***3");

        // then
        assertEquals(6, result);
    }

    @Test
    public void shouldWorkWithMultipleDelimitersWithAnyLength() throws Exception {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int result = stringCalculator.add("//[*][%]\n1*2%3");

        // then
        assertEquals(6, result);
    }
}
