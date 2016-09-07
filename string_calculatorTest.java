package test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class string_calculatorTest {

    @Test
    public void shouldReturn0GivenEmptyString() throws Exception {
        assertThat(string_calculator.calculate(""), is(0));
        assertThat(string_calculator.calculate(null), is(0));
    }

    @Test
    public void shouldReturnNumberGivenOneNumberString() throws Exception {
        assertThat(string_calculator.calculate("1"), is(1));
        assertThat(string_calculator.calculate("123"), is(123));
    }

    @Test
    public void shouldReturnSumGivenTwoNumbers() throws Exception {
        assertThat(string_calculator.calculate("1,2"), is(3));
        assertThat(string_calculator.calculate("123,1"), is(124));
    }

    @Test
    public void shouldReturnSumGivenMoreThanTwoNumbers() throws Exception {
        assertThat(string_calculator.calculate("0,1,456"), is(457));
    }

    @Test
    public void shouldReturnSumGivenNumbersSplitedByCommaOrNewLine() throws Exception {
        assertThat(string_calculator.calculate("0\n89"), is(89));
        assertThat(string_calculator.calculate("0\n89,1"), is(90));
    }

    @Test
    public void shouldReturnSumGivenSpecifiedDelimiter() throws Exception {
        assertThat(string_calculator.calculate(";\n0;1;1"), is(2));
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenSumGivenOneNegativeNumber() throws Exception {
        exception.expect(Exception.class);
        exception.expectMessage(containsString("negatives not allowed"));
        exception.expectMessage(containsString("-1"));
        string_calculator.calculate("-1,1");
    }

    @Test
    public void shouldThrowExceptionWhenSumGivenMoreThanOneNegativeNumbers() throws Exception {
        exception.expect(Exception.class);
        exception.expectMessage(containsString("negatives not allowed"));
        exception.expectMessage(containsString("-1, -1"));
        string_calculator.calculate("-1,-1");

        exception.expectMessage(containsString("-1, -1"));
        string_calculator.calculate("-1,2,-1");
    }

    @Test
    public void shouldIgnoreNumberBiggerThan1000WhenSum() throws Exception {
        assertThat(string_calculator.calculate("1,1000"), is(1001));
        assertThat(string_calculator.calculate("1,1001"), is(1));
    }

    @Test
    public void shouldReturnSumWhenDelimiterWithAnyLengthSurroundedByBrackets() throws Exception {
        assertThat(string_calculator.calculate("[***]\n1***2***3***"), is(6));
    }

    @Test
    public void shouldReturnSumWhenMultiDelimitersWithOneCharacterSurroundedByBrackets() throws Exception {
        assertThat(string_calculator.calculate("[*][%]\n2*5%1"), is(8));
    }

    @Test
    public void shouldReturnSumWhenMultiDelimitersWithAnyLengthSurroundedByBrackets() throws Exception {
        assertThat(string_calculator.calculate("[***][;][,]\n2;2***5,1"), is(10));
    }
}
