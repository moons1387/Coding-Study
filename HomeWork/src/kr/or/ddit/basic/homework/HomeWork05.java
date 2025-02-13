package kr.or.ddit.basic.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeWork05 {
	public static int cnt = 1;
	public static boolean flag = true;
	static Horse[] horses = { new Horse("A "), new Horse("B "), new Horse("C "), new Horse("D "), new Horse("E "),
			new Horse("F "), new Horse("G "), new Horse("H "), new Horse("I "), new Horse("J ") };

	public static void main(String[] args) {
		List<Horse> horseList = new ArrayList<Horse>();

		LaneDate lD = new LaneDate();

		for (int i = 0; i < 10; i++) {
			horseList.add(horses[i]);
		}

		for (Horse h : horseList) {
			h.start();
		}
		lD.start();
		for (Horse h : horseList) {
			try {
				h.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		HomeWork05.flag = false;
		Collections.sort(horseList);
		
		for (Horse horse : horseList) {
			System.out.println(horse);
		}
	}
}

class Asc implements Comparator<Horse> {
	@Override
	public int compare(Horse h1, Horse h2) {
		return h1.getName().compareTo(h2.getName());
	}
}

class Horse extends Thread implements Comparable<Horse> {
	private String name;
	private String lane;
	private int rank;

	public Horse(String name) {
		this.name = name;
	}

	public String getNameHorse() {
		return name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	@Override
	public int compareTo(Horse h) {
		return Integer.compare(this.rank, h.getRank());
	}

	public void run() {

		for (int i = 0; i < 50; i++) {
			int time = (int) (Math.random() * 250);
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String lane2 = "==================================================";
			String lane = "--------------------------------------------------";
			String laneRun = lane2.substring(0, i) + '>' + lane.substring(i + 1);
			this.setLane(laneRun);
//			System.out.println(name + laneRun);
		}
		this.setRank(HomeWork05.cnt++);
	}

	@Override
	public String toString() {
		return "Horse [name= " + name + ", rank= " + rank + "]";
	}
}

class LaneDate extends Thread {
	List<Horse> list = new ArrayList<Horse>();

	@Override
	public void run() {
		for (Horse h : HomeWork05.horses) {
			list.add(h);
		}
		Collections.sort(list, new Asc());
		while (HomeWork05.flag) {
			for (Horse horse : list) {
				System.out.println(horse.getNameHorse() + horse.getLane());
			}
			System.out.println();
			System.out.println();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}