package com.tan.lamda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LamdaTests {

	public static void main(String[] args) {
		// 匿名内部�?
		// new Thread(new Runnable(){
		// public void run(){
		// System.out.println("hello");
		// }
		// }).start();
		//
		// new Thread(() -> System.out.println("hello")).start();

		// 集合迭代
		// List<String> languages = Arrays.asList("java", "scala", "python");
		// // before java8
		// for (String each : languages) {
		// System.out.println(each);
		// }
		//
		// languages.forEach(x -> System.out.println(x));
		// languages.forEach(System.out::println);

		//过滤�?
//		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
//
//		System.out.println("Languages which starts with J :");
//		filter(languages, (str) -> str.startsWith("J"));
//
//		System.out.println("Languages which ends with a ");
//		filter(languages, (str) -> str.endsWith("a"));
//
//		System.out.println("Print all languages :");
//		filter(languages, (str) -> true);
//
//		System.out.println("Print no language : ");
//		filter(languages, (str) -> false);
//
//		System.out.println("Print language whose length greater than 4:");
//		filter(languages, (str) -> str.length() > 4);
		
		
		//实现Map �? Reduce
		// applying 12% VAT on each purchase
		// Without lambda expressions:
//		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//		for (Integer cost : costBeforeTax) {
//		      double price = cost + .12*cost;
//		      System.out.println(price);
//		}
//
//		// With Lambda expression:
//		costBeforeTax.stream().map((cost) -> cost + .12*cost)
//		                      .forEach(System.out::println);
		List<Integer> costBeforeTax =Arrays.asList(100, 200, 300, 400, 500);
		double total =0;
//		for (Integer cost :costBeforeTax) {
//		 double price = cost + .12*cost;
//		 total = total + price;
//		 
//		}
//		System.out.println("Total : " + total);

		// New way:List costBeforeTax =Arrays.asList(100, 200, 300, 400, 500);
//		double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost)
//		                                    .reduce((sum, cost) -> sum + cost)
//		                                    .get();
//		System.out.println("Total : " + bill);
		
//		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
//		List<Integer> distinct = numbers.stream().map( i -> i*i).distinct()
//		                                         .collect(Collectors.toList());
//		System.out.printf("Original List : %s,  Square Without duplicates :%s %n", numbers, distinct);

//		System.out.printf("a:%s %nb:%s %nc:%s %n",1,2,3);
		
//		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
//		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x)
//		                                            .summaryStatistics();
//		System.out.println("Highest prime number in List : " + stats.getMax());
//		System.out.println("Lowest prime number in List : " + stats.getMin());
//		System.out.println("Sum of all prime numbers : " + stats.getSum());
//		System.out.println("Average of all prime numbers : " + stats.getAverage());

	}

	public static void filter(List<String> names, Predicate<String> condition) {
		for (String name : names) {
			if (condition.test(name)) {
				System.out.println(name + " ");
			}
		}
	}
}
