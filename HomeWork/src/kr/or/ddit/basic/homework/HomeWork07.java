
package kr.or.ddit.basic.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class HomeWork07 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);

		RoomManagement rm = new RoomManagement();

		List<Room> roomList = rm.roomCurrent();

		while (true) {
			System.out.println("어떤 업무를 하시겠습니까?\r1. 체크인\r2. 체크아웃\r3. 객실상태\r4. 업무종료");

			int sel = sc.nextInt();
			if (sel == 1) {
				System.out.println("어느방에 체크인 하시겠습니까?");
				int roomSel = sc.nextInt();
				if (rm.roomChk(roomList, roomSel)) {
					System.out.println(roomSel + "방에는 이미 사람이 있습니다.");
					continue;

				} else {
					System.out.println("누구를 체크인 하시겠습니까?\r이름 입력 =>");

					String name = sc.next();
					Room room = new Room(roomSel, name);
					roomList.add(room);
					Collections.sort(roomList);
					rm.roomWrite(roomList);

					System.out.println("체크인 되었습니다.");
				}

			} else if (sel == 2) {
				System.out.println("어느방을 체크아웃 하시겠습니까?");

				int roomSel = sc.nextInt();
				if (rm.roomChk(roomList, roomSel)) {
					Collections.sort(roomList);
					roomList = rm.reseveDel(roomList, roomSel);
					rm.roomWrite(roomList);
					System.out.println("체크아웃 되었습니다.");

				} else {
					System.out.println(roomSel + "방에는 체크인한 사람이 없습니다.");
				}

			} else if (sel == 3) {
				roomList = rm.roomCurrent();

			} else {
				System.out.println("호텔 문을 닫았습니다.");
				break;
			}
		}
	}
}

class Room implements Serializable, Comparable<Room> {
	private int num;
	private String name;

	public Room(int num, String name) {
		this.num = num;
		this.name = name;
	}

	int getNum() {
		return num;
	}

	void setNum(int num) {
		this.num = num;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Room room) {
		return Integer.compare(this.num, room.num);
	}

	@Override
	public String toString() {
		return "Room [num=" + num + ", name=" + name + "]";
	}
}

class RoomManagement {

	public void roomWrite(List<Room> roomList) {

		ObjectOutputStream oos;

		try {
			oos = new ObjectOutputStream(
				  new BufferedOutputStream(
				  new FileOutputStream("/Users/jeongmunseong/Test/Hotel.bin")));

			for (Room room : roomList) {
				oos.writeObject(room);
			}

			oos.flush();
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Room> roomCurrent() throws IOException, ClassNotFoundException {

		List<Room> roomList = new ArrayList<Room>();

		File Hotel = new File("/Users/jeongmunseong/Test/Hotel.bin");
		if (!Hotel.isFile()) {
			Hotel = new File("/Users/jeongmunseong/Test/Hotel.bin");
		} else {

			ObjectInputStream ois = new ObjectInputStream(
									new BufferedInputStream(
									new FileInputStream("/Users/jeongmunseong/Test/Hotel.bin")));

			Object obj = null;
			try {
				while ((obj = ois.readObject()) != null) {
        	 		roomList.add((Room)obj);
				}
			} catch (IOException e) {
//				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				ois.close();

			}
			Collections.sort(roomList);
			for (Room room : roomList) {
				System.out.println(room);
			}

		}
		return roomList;
	}

	public boolean roomChk(List<Room> roomlList, int roomSel) {
		for (Room room : roomlList) {
			if (room.getNum() == roomSel) {
				return true;
			} else
				continue;
		}
		return false;
	}

	public List<Room> reseveDel(List<Room> roomList, int roomSel) {
		for (Iterator<Room> iterator = roomList.iterator(); iterator.hasNext();) {
			Room room = iterator.next();
			if(room.getNum()==roomSel) {
				iterator.remove();
			}
		}
		return roomList;
	}
}