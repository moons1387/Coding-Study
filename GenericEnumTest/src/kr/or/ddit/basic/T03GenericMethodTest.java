package kr.or.ddit.basic;

class Util {

	/**
	 * 제너릭 메서드<T, R> R method(T t)
	 * 
	 * => 파라미터 타입 또는 리턴타입으로 타입글자를 가지는 메서드 
	 * 선언방법 : 리턴타입 앞에 < > 기호를 추가하고 타입글자를 지정한 후 사용한다.
	 */
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		return keyCompare && valueCompare;
	}
}

/**
 * 멀티타입<K, V>를 가지는 제너릭 클래스
 * 
 * @param <K>
 * @param <V>
 */
class Pair<K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	// 키와 값 출력하기
	public <K, V> void displayAll(K key, V val) {
		System.out.println(key.toString() + " : "+ val.toString());	
	}
		
}

public class T03GenericMethodTest {
	
	public static void main(String[] args) {
		
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "홍길동");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "홍길동");
		
		boolean result = Util.<Integer, String>compare(p1, p2);
		
		if(result) {
			System.out.println("두 객체는 논리적으로 동일한 객체임.");
		} else {
			System.out.println("두 객체는 논리적으로 동일한 객체가 아님.");
		}
		
		
		////////////////////////////////////////////////////////////////////
		
		Pair<String, String> p3 = new Pair<String, String>("001", "홍길동");
		Pair<String, String> p4 = new Pair<String, String>("002", "홍길동");
		
		result = Util.<String, String>compare(p3, p4);
		
		if(result) {
			System.out.println("두 객체는 논리적으로 동일한 객체임.");
		} else {
			System.out.println("두 객체는 논리적으로 동일한 객체가 아님.");
		}
		
		p3.displayAll("키", 180); 
		
	}
}