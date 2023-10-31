package Kruthik.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import Kruthik.Airthemetic;
import Kruthik.AirthemeticImpl;
import Kruthik.DivideByZeroException;

@DisplayName("Arithmetic Tests")
class AirthemeticTest {

	private Airthemetic air; // = new AirthemeticImpl();
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("Executing only once before all. . .");
	}
	//Should be static as it is called only once
	
	@AfterAll
	public static void afterAll() {
		System.out.println("Executing only once after all. . .");
	}
	
	@BeforeEach
	public void initialization() {
		//Called everytime a method is executed
		System.out.println("Initialized");
		air = new AirthemeticImpl();
	}

	@AfterEach
	public void destroying() {
		System.out.println("Destroyed");
	}
	
	@Test @DisplayName("Adding and checking results of +ve and -ve numbers")
	void testAdd() {
		assertEquals(5, air.add(2, 3));
		assertEquals(5, air.add(3, 2));
		assertEquals(5, air.add(5, 0));
		assertEquals(5, air.add(5, -0));
		assertEquals(-5, air.add(-2, -3));
		assertEquals(-5, air.add(-8, 3));
		assertEquals(-5, air.add(-5, 0));
	}

	@Test
	void testSub() {
	}

	@Test
	void testMul() {
	}
	
	static Stream<Arguments> addArgsGenerator(){
		return Stream.of(
			Arguments.of(1,2,3),
			Arguments.of(-1,-2,-3),
			Arguments.of(1,-2,-1),
			Arguments.of(2,3,5)
		);
	}
	
	//The method should be static and should be streamed
	@ParameterizedTest(name="Add with CSV {0} + {1} = {2}")
	@MethodSource(value = {"addArgsGenerator"})
	void testWithMethod(int a,int b,int c) {
		assertEquals(c,air.add(a, b));
	}
	
	@ParameterizedTest(name="Add with CSV {0} + {1} = {2}")
	@CsvFileSource(files = {"add.csv"})
	void testWithCSVFile(int a,int b,int c) {
		assertEquals(c,air.add(a, b));
	}
	
	@ParameterizedTest(name="Add with CSV {0} + {1} = {2}")
	@CsvSource(value= {"2,3,5","-2,3,1","5,-2,3","-1,-1,-2"})
	void testWithCSVParams(int a,int b,int c) {
		assertEquals(c,air.add(a, b));
	}
	
	@ParameterizedTest(name="Add with {0}")
	@ValueSource(strings = {"2,3,5","-2,3,1","5,-2,3","-1,-1,-2"})
	void testAddWithParameteres(String value) {
		String[] parts =value.split(",");
		List<Integer> values=Arrays.asList(parts).stream().map(it->Integer.parseInt(it)).collect(Collectors.toList());
		assertEquals(values.get(2),air.add(values.get(0), values.get(1)));
	}
	
	@Test
	void testDivByZero() {
		assertThrows(DivideByZeroException.class,() -> air.div(5, 0));
		//1st Argument Exception 2nd Argument function expression
	}

	@Test
	void testDiv() {
//		assertEquals(1.6666,5.0/3); //Throws error
		assertEquals(1.6666,5.0/3,0.001); //Precision provided do not throw an error
//		assertEquals(1.6666,5.0/3,"Value not in range");
		assertEquals(2, air.div(4, 2));
		assertEquals(2, air.div(-6, -3));
		try {
			assertEquals(2, air.div(4, 0));
			fail("Should have thrown DivideByZeroException");
		} 
		catch (DivideByZeroException e) {}
	}

}
