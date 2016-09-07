package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
public class OddEvenTest {
	private OddEven oddeven;

	@Before
	public void setUp() throws Exception {
		oddeven = new OddEven();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_print_odd_for_odd_number (){
		assertThat(oddeven.print(1), is("odd"));
	}

	@Test
	public void should_print_even_for_even_number (){
		assertThat(oddeven.print(4), is("even"));
	}
	
	@Test
	public void should_print_prime_for_prime_number (){
		assertThat(oddeven.print(2), is("2"));
		assertThat(oddeven.print(3), is("3"));
	}
	@Test
    public void should_print_given_specified_range() {
        assertThat(oddeven.print(1, 10), is("odd, 2, 3, even, 5, even, 7, even, odd, even"));
    }

}
