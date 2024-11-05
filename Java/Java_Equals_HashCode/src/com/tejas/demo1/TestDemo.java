package com.tejas.demo1;
import java.util.HashSet;

/*
 * In a HashSet collection:
 * 1. First, we find the hash code of the object.
 * 2. If the hash code does not exist in the set, we add the element to the set.
 * 3. If we find the same hash code, we check the equality of the objects using equals().
 *    - If equals() returns true, we do not add that object (it is considered a duplicate).
 *    - If equals() returns false, that means the objects are not equal, and we add the new object to the set.
 *
 * 
 * If two objects are equal according to equals(), they must return the same hash code.
 * However, objects with the same hashCode() may or may not be equal. This allows multiple objects to exist in the same bucket
 * , but they are further distinguished using equals().
 */


public class TestDemo {
	public static void main(String[] args) {
		
		/*
		 * HashCode is generated based on the contact number of the person.
		 * Equality is checked on name and age using the equals() method.
		 * However, this implementation violates the hashCode contract:
		 * If two Person objects are considered equal (same name and age),
		 * they MUST have the same hashCode, even if their contact numbers are different.
		 */
		Person p1 =  new Person("Tejas" ,30,8892921);
		Person p2 = new Person("Raja",25, 8892921);
		Person p3 = new Person("Tejas",30, 8892921);
		
		HashSet<Person> pSet = new HashSet<>();
		pSet.add(p1);
		pSet.add(p2);
		pSet.add(p3);
		System.out.println(pSet);
	}

}
