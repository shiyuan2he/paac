package com.hsy.codebase.utils.javase.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.hsy.codebase.utils.javase.logger.SystemLogger;

public class StreamHelperTest {

	@Test
	public void test() {
		List<Integer> numbersList = Arrays.asList(1,2,3,null,9,3,1,null,0) ;
		SystemLogger.log(numbersList.stream().distinct().filter(num -> num != null).count());
		SystemLogger.log(numbersList.stream().filter(num -> num != null).collect(Collectors.toList()));
		SystemLogger.log(numbersList.stream().distinct().filter(num -> num != null).collect(Collectors.toList()));
	}
	@Test
	public void test2() {
		try{
			List<Integer> numbersList = Arrays.asList(1,2,3,9,3,1,4,5,6,7,8,9) ;
			numbersList.stream().filter((x) -> {return x % 2 == 0 ;}) //
								.map((x) -> {return x * x;}).forEach(System.out::println);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
