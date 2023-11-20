package com.valtech.training.mockito;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMockTest {

	@Test
	public void test() {
		List<Integer> scores=Arrays.asList(99,101,98,105);
		
		assertThat(scores,hasSize(4));
		assertThat(scores,everyItem(greaterThan(90)));
		
		//All the methods are present in matchers
		
		//Fail
//		assertThat("",isEmptyString());
	}

}
