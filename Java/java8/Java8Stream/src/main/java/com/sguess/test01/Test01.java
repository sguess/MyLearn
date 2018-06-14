package com.sguess.test01;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<Student> getStudentList() {
		Student stuA = new Student(1, "A", "M", 184);
		Student stuB = new Student(2, "B", "G", 163);
		Student stuC = new Student(3, "C", "M", 175);
		Student stuD = new Student(4, "D", "G", 158);
		Student stuE = new Student(5, "E", "M", 170);
		Student stuF = new Student(5, "E", "M", 170);
		List<Student> list = new ArrayList<>();
		list.add(stuA);
		list.add(stuB);
		list.add(stuC);
		list.add(stuD);
		list.add(stuE);
		list.add(stuF);
		return list;
	}

	List<Student> list;

	@Before
	public void before() {
		list = getStudentList();
	}

//	@Test
	public void fun1() {
		List<Student> list = getStudentList();
		list.stream().filter(student -> student.getSex().equals("G"))
				.forEach(stud -> System.out.println(stud.toString()));

	}

//	@Test
	public void fun2() {
		List<Student> list = getStudentList();
		Predicate<? super Student> predicate = student -> student.getSex().equals("G");
		Consumer<? super Student> action = student -> System.out.println(student.toString());
		list.stream().filter(predicate).forEach(action);
	}

//	@Test
	public void fun3() {
		List<Student> list = getStudentList();
		Predicate<? super Student> predicate = student -> student.getSex().equals("G");
	}

//	@Test
	public void fun4() {
		System.out.println(list.stream().count());
		Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
		Stream<String> stringStream = Stream.of("taobao");
		// System.out.println(integerStream.count() + "," + stringStream.count());
		long count = integerStream.filter(n -> n.intValue() > 1).count();
		System.out.println(count);

	}

//	@Test
	public void fun5() {
		Stream<Double> s0 = Stream.generate(new Supplier<Double>() {
			@Override
			public Double get() {
				return Math.random();
			}
		});
//		System.out.println(s0.count());
		Stream<Double> s1 = Stream.generate(() -> Math.random());
		Stream<Double> s2 = Stream.generate(Math::random);
//		System.out.println(s1.count());
//		System.out.println(s2.count());
	}
	

	@Test
	public void fun6() {
		long c1 = list.stream().count();
		long c2 = list.stream().distinct().count();
		System.out.println(c1+","+c2);
		Stream<Integer> int1 = Stream.of(1,2,3,4,1,2);
		Stream<Integer> int2 = int1.distinct();
		System.out.println(int2.count());
		long c3 = Stream.of(1,2,3,4,5,6,1,2).filter(num->num>1).distinct().count();
		System.out.println(c3);
	}

}
