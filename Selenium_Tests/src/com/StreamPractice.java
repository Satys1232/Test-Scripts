package com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {

	public static void main(String[] args) {
//		List<String> sentences = Arrays.asList("hello world", "Hello price Info The First Version");
//		List<String> words = sentences.stream().flatMap(sentence-> Arrays.stream(sentence.split(" "))).collect(Collectors.toList());
//		System.out.println(words);
		
		class Employee {
            private String name;
            private String department;

            public Employee(String name, String department) {
                this.name = name;
                this.department = department;
            }

//            public String getName() {
//                return name;
//            }

            public String getDepartment() {
                return department;
            }

            @Override
            public String toString() {
                return name + " (" + department + ")";
            }
        }
		List<Employee> employees = Arrays.asList(
	            new Employee("Suresh", "IT"),
	            new Employee("Priya", "HR"),
	            new Employee("Sunita", "IT"),
	            new Employee("Rahul", "Finance"),
	            new Employee("Sneha", "IT")
	        );
		List<Employee> itEmployees = employees.stream().filter(emp->"IT".equals(emp.getDepartment())).collect(Collectors.toList());
		System.out.println("------IT EMPLOYEES-----");
		itEmployees.forEach(System.out::println);
	}
}