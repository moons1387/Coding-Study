
package kr.or.ddit.basic.homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class HomeWork03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, String> roomMap = new HashMap<Integer, String>();

		while (true) {
			System.out.println("어떤 업무를 하시겠습니까?" + 
								"\r1. 체크인" + "\r2. 체크아웃" + 
								"\r3. 객실상태" + "\r4. 업무종료");
			int sel = sc.nextInt();
			
			if (sel == 1) {
				
				System.out.println("어느방에 체크인 하시겠습니까?");
				
				int roomSel = sc.nextInt();
				
				if (roomMap.containsKey("roomSel")) {
					System.out.println(roomSel + "방에는 이미 사람이 있습니다.");
					continue;
					
				} else {
					System.out.println("누구를 체크인 하시겠습니까?\r이름 입력 =>");
					String name = sc.next();
					roomMap.put(roomSel, name);
					System.out.println("체크인 되었습니다.");
				}
				
			} else if (sel == 2) {

				System.out.println("어느방을 체크아웃 하시겠습니까?");
				
				int roomSel = sc.nextInt();
				
				if (roomMap.containsKey(roomSel)) {
					roomMap.remove(roomSel);
					System.out.println("체크아웃 되었습니다.");
					
				} else {
					System.out.println(roomSel + "방에는 체크인한 사람이 없습니다.");
				}

			} else if (sel == 3) {
				Set<Map.Entry<Integer, String>> entrySet = roomMap.entrySet();
				
				Iterator entryIt = entrySet.iterator();
				
				while (entryIt.hasNext()) {
					Map.Entry entry = (Map.Entry) entryIt.next();
					System.out.println("방번호 : " + entry.getKey() + " | 투숙객 : " + entry.getValue());
				}
				
			} else {
				System.out.println("호텔 문을 닫았습니다.");
				break;
			}
		}
	}
}
