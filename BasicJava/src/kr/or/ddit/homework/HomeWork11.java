package kr.or.ddit.homework;

import java.util.Random;
import java.util.Scanner;

public class HomeWork11 {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork11 obj = new HomeWork11();
		obj.process();

	}

	public void process() {
		Deck deck = new Deck();
		deck.suffle();
		deck.printCardList();
		int cnt = 0;
		for(int i = 0;i<52;i++) {
			
		}
		Card myCard = deck.getCard(0);
		Card comCard = deck.getCard(1);
		print(myCard, comCard);
	}

	public void print(Card my, Card com) {
		// 결과값 출력
		// 내카드 ♤1 컴퓨터 ◇5
		// 결과 : lose'
		System.out.println();
		System.out.println();
		if (my.num > com.num) {
			System.out.println("내 카드 : " + my + "\t컴퓨터 카드 :" + com + "\n결과 : win");
		} else {
			System.out.println("내 카드 : " + my + "\t컴퓨터 카드 :" + com + "\n결과 : lose");
		}
	}
}

class Card {
	String type;
	int num;

	public Card(String type, int num) {
		this.type = type;
		this.num = num;

	}
	// 생성자를 이용해서 type, num 입력.

	@Override
	public String toString() {
		// type ♤◇♧♡
		// num = 1~13
		// 1-A, 11-J, 12-Q, 13-K
		String result = type+num;
		if(num==1) {
			result = type+"A";
		} else if(num==11) {
			result = type+"J";
		} else if(num==12) {
			result = type+"Q";
		} else if(num==13) {
			result = type+"K";
		}
		return "["+result+"]\t";
	}
}

class Deck {
	Card[] cardList;

	public Deck() {
		cardList = new Card[52];
		String[] type = { "♤", "◇", "♧", "♡" };
		int cnt = 0;
		for (String t : type) {
			for (int i = 1; i <= 13; i++) {
				cardList[cnt++] = new Card(t, i);
			}
		}
	}

	public void suffle() {
		// 카드 섞기
		Card[] spare = new Card[1];
		for (int i = 0; i <= 100000; i++) {
			int ran = (int) (Math.random() * cardList.length);
			spare[0] = cardList[0];
			cardList[0] = cardList[ran];
			cardList[ran] = spare[0];
		}
	}

	public void printCardList() {
		// 10개 단위로 자르기
		for (int i = 0; i < cardList.length; i++) {
			System.out.print(cardList[i] + "  ");
			if (i % 10 == 9) {
				System.out.println();
			}
		}
	}

	public Card getCard(int ran) {
		return cardList[ran];
	}
}
