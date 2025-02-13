package kr.or.ddit.basic;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;

public class T06WildCardTest {
	
	// 장바구니에 담긴 항목조회를 위한 메서드
	public static void displayCarItemInfo(Cart<?> cart) {
		System.out.println("= 장바구니 항목 리스트 =");
		for (Object obj : cart.getItemList()) {
			System.out.println(obj);
		}
		System.out.println("-----------------------------------");
	}
	public static void displayCarItemInfo2(Cart<? extends Drink> cart) {
		System.out.println("= 장바구니 항목 리스트 =");
		for (Object obj : cart.getItemList()) {
			System.out.println(obj);
		}
		System.out.println("-----------------------------------");
	}
	public static void displayCarItemInfo3(Cart<? super Meat> cart) {
		System.out.println("= 음식류 장바구니 항목 리스트 =");
		for (Object obj : cart.getItemList()) {
			System.out.println(obj);
		}
		System.out.println("-----------------------------------");
	}
	
	public static void main(String[] args) {

		Cart<Food> foodCart = new Cart<>();
		foodCart.addItem(new Meat("돼지고기", 5000));
		foodCart.addItem(new Meat("소고기", 50000));
		foodCart.addItem(new Juice("망고쥬스", 3000));
		foodCart.addItem(new Coffee("커피", 4500));	
		
		Cart<Meat> meatCart = new Cart<>();
		meatCart.addItem(new Meat("돼지고기", 5000));
		meatCart.addItem(new Meat("소고기", 50000));
//		meatCart.addItem(new Juice("망고쥬스", 3000));
//		meatCart.addItem(new Coffee("커피", 4500));	
		
		Cart<Drink> drinkCart = new Cart<>();
//		drinkCart.addItem(new Meat("돼지고기", 5000));
//		drinkCart.addItem(new Meat("소고기", 50000));
		drinkCart.addItem(new Juice("망고쥬스", 3000));
		drinkCart.addItem(new Coffee("커피", 4500));
		
		//////////////////////////////////////////////////////
		
		displayCarItemInfo(foodCart);
		displayCarItemInfo(meatCart);
		displayCarItemInfo(drinkCart);
		
//		displayCarItemInfo2(foodCart);
//		displayCarItemInfo2(meatCart);
		displayCarItemInfo2(drinkCart);
		
		displayCarItemInfo3(foodCart);
		displayCarItemInfo3(meatCart);
//		displayCarItemInfo3(drinkCart);
	}
}

class Food {
	private String name;
	private int price;

	public Food(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return this.name + "(" + this.price + "원)";
	}
}

class Meat extends Food {

	public Meat(String name, int price) {
		super(name, price);
	}

}

class Drink extends Food {

	public Drink(String name, int price) {
		super(name, price);
	}

}

class Juice extends Drink {

	public Juice(String name, int price) {
		super(name, price);
	}

}

class Coffee extends Drink {

	public Coffee(String name, int price) {
		super(name, price);
	}

}

class Cart<T> {
	private List<T> itemList;

	public Cart() {
		itemList = new ArrayList<>();
	}

	public List<T> getItemList() {
		return itemList;
	}

	public void addItem(T item) {
		itemList.add(item);
	}
}