package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class T07EqualsHashCodeTest {
	public static void main(String[] args) {

		/*
		 * 해시함수(Hash function)는 임의의 길이 데이터를 고정된 길이의 데이터로 매핑해주는 함수이다. 해시함수에 의해 얻어지는 값은
		 * 해시값, 해시코드, 또는 간단하게 해시하고도 부른다.
		 * 
		 * HashSet, HashMap, HashTable과 같은 컬렉션 클래스를 사용할 경우에는 객체가 서로 같은지를 비교하기 위해
		 * hashCode() 와 equals() 메서드를 호출한다. 그러므로 객체가 서로 같은지를 적절히 판단하기 위해서는 두 메서드를 재정의
		 * 해주어야 한다. (객체가 추가되는 시점에 객체가 같은지 여부를 판단한다.)
		 * 
		 * -equals()는 두 객체의 내용(값)이 같은지 비교하기 위한 메서드이고, -hashCode()는 객체에 대한 해시코드를 가져오기 위한
		 * 메서드이다. => 해시테이블 작성시 사용됨.
		 * 
		 * equals()와 hashCode() 메서드에 대한 관련된 규칙(Convention)
		 * 
		 * 1. 두 객체가 같으면 반드시 같은 hashCode값을 가져야 한다.
		 * 2. 두 객체가 같으면 equals()메서드를 호출했을 때 true를 반환해야 한다.
		 * 	  즉, 객체 a, b가 같다면 a.equals(b) 와 b.equals(a) 둘다 true를 반환해야 한다.
		 * 3. 두 객체의 hashCode가 같다고 해서 두 객체가 반드시 같은 객체는 아니다.
		 * 	  하지만, 구 객체가 같으면 반드시 hashCode가 같다.
		 * 4. equals()를 재정의 할 때에는 hashCode() 도 재정의 해주어야 한다.
		 * 5. hashCode()는 기본적으로 Heap메모리에 있는 각 객체에 대한 메모리 주소 매핑 정보를 기반으로 한 정수값을 반환한다.
		 *    그러므로, 클래스에서 hashCode()를 재정의 하지 않으면 절대로 두 객체가 같은 것으로 간주될 수 없다.
		 *    
		 */

		Person p1 = new Person(1, "홍길동");
		Person p2 = new Person(1, "홍길동");
		Person p3 = new Person(1, "이순신");

		System.out.println("p1 == p2 : " + (p1 == p2));
		System.out.println("p1.equals(p2) : " + p1.equals(p2));

		Set<Person> pSet = new HashSet<Person>();

		System.out.println("add(p1) : " + pSet.add(p1));
		System.out.println("add(p2) : " + pSet.add(p2));

		System.out.println("p1, p2 등록 후 데이터 : ");
		for (Person person : pSet) {
			System.out.println(person.getId() + " : " + person.getName());
		}
		System.out.println("add(p3) : " + pSet.add(p3));

		System.out.println("p3 등록 후 데이터 : ");
		for (Person person : pSet) {
			System.out.println(person.getId() + " : " + person.getName());
		}

	}
}

class Person {
	private int id;
	private String name;

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, name);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Person other = (Person) obj;
//		return id == other.id && Objects.equals(name, other.name);
//	}

	
	
	@Override
	public boolean equals(Object obj) {

		Person p = (Person) obj;

		return this.getId() == p.getId() && this.getName().equals(p.getName());
	}

	@Override
	public int hashCode() {
		
		return (name + id).hashCode();
	}

}
