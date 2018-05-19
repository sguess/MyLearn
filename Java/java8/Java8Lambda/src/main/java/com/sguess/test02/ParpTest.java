package com.sguess.test02;

public class ParpTest {
	public static void main(String[] args) {
		Parp<Person> parp=(person)->{System.out.println(person.name);};
		Person p=new Person();
		p.name="Jerry";
		parp.sayHello(p);
	}
}
interface Parp<T>{
	public void sayHello(T t);
}
class Person{
	public String name;
}
