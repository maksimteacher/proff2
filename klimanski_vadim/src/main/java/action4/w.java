package action4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class w {

	public static void main(String[] args) {
		Map<String, Person> people = new HashMap<String, Person>();

	    Person jim = new Person("Jim", 25);
	    Person scott = new Person("Scott", 28);
	    Person anna = new Person("Anna", 23);

	    people.put(jim.getName(), jim);
	    people.put(scott.getName(), scott);
	    people.put(anna.getName(), anna);

	    // not yet sorted
	    List<Person> peopleByAge = new ArrayList<Person>(people.values());

	    Collections.sort(peopleByAge, new Comparator<Person>() {

	        public int compare(Person o1, Person o2) {
	            return o1.getAge() - o2.getAge();
	        }
	    });

	    for (Person p : peopleByAge) {
	        System.out.println(p.getName() + "\t" + p.getAge());
	    }
	}
	static class Person{
		private String name;
		private int age;
		public Person(String string, int i) {
		
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}

				
	}
	}

