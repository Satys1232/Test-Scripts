package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class Test1 {
	public static void main(String[] args) {
		Test1 t = new Test1();
		t.assignment();
		}

	public void regular() {
		int count = 0;
		ArrayList<String> names = new ArrayList<String>();
		names.add("Animesh");
		names.add("Abhijeet");
		names.add("Don");
		names.add("Aheshya");
		names.add("Akhini");
		for (String name : names) {
			String actualName = name;
			if (actualName.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}

	public void streamsTouch() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Animesh");
		names.add("Abhijeet");
		names.add("Don");
		names.add("Aheshya");
		names.add("Akhini");
		long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);
		long d = Stream.of("Animesh", "Abhijeet", "Don", "Aheshya", "Akhini").filter(s -> s.startsWith("A")).count(); // This
																														// will
																														// not
																														// execute
																														// as
																														// we
																														// are
																														// returning
																														// false
																														// but
																														// it
																														// expects
																														// true.
		System.out.println(d);
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
	}

	public void streamStraight() {
		Stream.of("Animesh", "Abhijeet", "Don", "Aheshya", "Akhini").filter(s -> s.startsWith("A")).limit(1)
				.forEach(s -> System.out.println(s));
		// WE CAN USE .limit to ACTUALLY LIMIT THE SEARCH INTERMEDIATORY OPERATION
		// OUTPUT.
	}

	public void streamMap() {

		// print names which has last letter as 'a' with upperCase.
		// Stream.of("Animesh", "Abhijeetsha", "Don", "Aheshya", "Akhini").filter(s ->
		// s.endsWith("a"))
		// .map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		// SO OUR REQUIREMENT IS WE HAVE TO PRINT NAMES WITH FIRST LETTER AS 'S' WITH
		// UPPERCASE AND SORTED.
		String[] people = { "Satya", "Abhisekh", "Rekha", "Susli", "Animesh" };
		List<String> peoples = Arrays.asList(people);
		peoples.stream().filter(s -> s.startsWith("S")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
		peoples.stream().filter(s -> s.startsWith("S")).map(s -> s.toUpperCase()).sorted()
				.forEach(s -> System.out.println(s));
	}

	public void streamMergeArrayList() {
		String[] indian = { "Anika", "Kavya", "Riya", "Saanvi", "Ishita" };
		List<String> indianGirls = Arrays.asList(indian);
		String[] foreign = { "Aanya", "Sohpia", "Zoolie", "Olivia", "jenifer" };
		List<String> foreignGirls = Arrays.asList(foreign);
		Stream<String> indoForeignGirls = Stream.concat(indianGirls.stream(), foreignGirls.stream());
		// indoForeignGirls.sorted().forEach(s->System.out.println(s));
		// indoForeignGirls.filter(s->s.equalsIgnoreCase("Riya")).forEach(s->System.out.println(s));
		boolean flag = indoForeignGirls.anyMatch(s -> s.equalsIgnoreCase("Zoolie"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}

	public void streamCollect() {
		String[] indian = { "Anika", "Kavya", "Riya", "Saanvi", "Ishita" };
		List<String> indianGirls = Arrays.asList(indian);
		String[] foreign = { "Aanya", "Sohpia", "Zoolie", "Olivia", "jenifer" };
		List<String> foreignGirls = Arrays.asList(foreign);
		Stream<String> indoForeignGirls = Stream.concat(indianGirls.stream(), foreignGirls.stream());
		Set<String>ifgSLowerCased = indoForeignGirls.filter(s -> s.startsWith("S")).sorted().map(s->s.toLowerCase()).collect(Collectors.toSet());
        //ifgSLowerCased.stream().forEach(s->System.out.println(s));
		System.out.println(ifgSLowerCased.iterator().next());
	}
	public void assignment()
	{
		//List<Integer> num = Arrays.asList(1 , 1 , 3 , 4, 5 , 4 , 7 , 8 , 7 , 9);
	    // we need to find unique number in the list.
		//num.stream().distinct().forEach(a->System.out.println(a));
		//distinct() results the one which are unique means it will not print repeated number.\
		//num.stream().sorted().forEach(a->System.out.println(a));
		//print the 3rd indexed element after sorting.
		//System.out.println(num.stream().sorted().collect(Collectors.toList()).get(2));
        //List<Integer>numbers =num.stream().sorted().collect(Collectors.toList());
        //System.out.println(numbers.get(2));
		//num.stream().sorted().skip(2).findFirst().ifPresent(System.out::println);
		// These are the methods how we can get the first element.
		
		
		}
}