package kr.or.ddit.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HomeWork19 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork19 obj = new HomeWork19();
		obj.process();
	}

	static int cnt = 0;
	Map<Integer, Integer> t = new HashMap();

	public void process() {
		while (true) {
			List<Map<String, Object>> parkList = inputData();
			System.out.println("1. 주차시간 구하기");
			System.out.println("2. 주차요금 구하기");
			System.out.println("3. 종료");
			int sel = sc.nextInt();
			// 차량별 주차 시간 구하기
			if (sel == 1)
				parkTime(parkList);
			// 요금 계산하기
			if (sel == 2)
				parkFare(parkList);
			// 종료
			if (sel == 3)
				break;
		}
	}

	private Map<String, Object> parkTime(List<Map<String, Object>> parkList) {
		Set set = new HashSet();
		for (Map<String, Object> map : parkList) {
			set.add(map.get("number"));
		}
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next()+"번");
		}
		System.out.print("차량 번호를 입력하세요 : ");
		String carNum = sc.next();
		int time = 0;
		Map<String, Object> parkTime = new HashMap<String, Object>();
		for (Map<String, Object> map : parkList) {
			if (map.get("number").equals(carNum)) {
				time += getTime(String.valueOf(map.get("time")));
			} else
				continue;
		}
		System.out.println(carNum + "번 \t 총 " + time + "분 사용");
		return parkTime;
	}

	public int getTime(String time) {
		String[] tokens = time.split(":");
		int hour = Integer.parseInt(tokens[0]);
		int min = Integer.parseInt(tokens[1]);
		int sum = hour * 60 + min;
		t.put(cnt, sum);
		int pTime = 0;
		if (cnt == 0) {
			cnt++;
			return pTime;
		} else {
			pTime = t.get(1) - t.get(0);
			cnt = 0;
		}
		return pTime;
	}

	public Map<String, Object> parkFare(List<Map<String, Object>> parkList) {
		Set set = new HashSet();
		for (Map<String, Object> map : parkList) {
			set.add(map.get("number"));
		}
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next()+"번");
		}
		// 기본 시간(분) 기본 요금(원) 단위 시간(분) 단위 요금(분)
		// 100 				5000 			10 			600
		System.out.print("차량 번호를 입력하세요 : ");
		String carNum = sc.next();
		int fare = 0;
		int time = 0;
		Map<String, Object> parkFare = new HashMap<String, Object>();
		for (Map<String, Object> map : parkList) {
			if (map.get("number").equals(carNum)) {
				time = getTime(String.valueOf(map.get("time")));
				if (time == 0) {
					continue;
				} else if (time > 100) {
					fare = fare + time / 100 * 5000 + time % 100/10 * 600;
				} else if (time <= 100) {
					fare = fare + 5000;
				}
				parkFare.put(carNum, fare);
			} else
				continue;
		}
		System.out.println(carNum + "번 \t 총 " + fare + "원 사용");
		return parkFare;
	}

	public List<Map<String, Object>> inputData() {
//		시각	차량번호	내역
//      05:34	5961		입차
//      06:00   0000		입차
//      06:34   0000		출차
//      07:59   5961		출차
//      07:59   0148		입차
//      18:59   0000		입차
//      19:09   0148		출차
//      22:59   5961		입차
//      23:00   5961		출차
//		23:00	0000		출차

		Map park1 = new HashMap();
		park1.put("time", "05:34");
		park1.put("number", "5961");
		park1.put("remark", "in");
		Map park2 = new HashMap();
		park2.put("time", "06:00");
		park2.put("number", "0000");
		park2.put("remark", "in");
		Map park3 = new HashMap();
		park3.put("time", "06:34");
		park3.put("number", "0000");
		park3.put("remark", "out");
		Map park4 = new HashMap();
		park4.put("time", "07:59");
		park4.put("number", "5961");
		park4.put("remark", "out");
		Map park5 = new HashMap();
		park5.put("time", "07:59");
		park5.put("number", "0148");
		park5.put("remark", "in");
		Map park6 = new HashMap();
		park6.put("time", "18:59");
		park6.put("number", "0000");
		park6.put("remark", "in");
		Map park7 = new HashMap();
		park7.put("time", "19:09");
		park7.put("number", "0148");
		park7.put("remark", "out");
		Map park8 = new HashMap();
		park8.put("time", "22:59");
		park8.put("number", "5961");
		park8.put("remark", "in");
		Map park9 = new HashMap();
		park9.put("time", "23:00");
		park9.put("number", "5961");
		park9.put("remark", "out");
		Map park10 = new HashMap();
		park10.put("time", "23:00");
		park10.put("number", "0000");
		park10.put("remark", "out");

		List<Map<String, Object>> parkList = new ArrayList();
		parkList.add(park1);
		parkList.add(park2);
		parkList.add(park3);
		parkList.add(park4);
		parkList.add(park5);
		parkList.add(park6);
		parkList.add(park7);
		parkList.add(park8);
		parkList.add(park9);
		parkList.add(park10);

		return parkList;

	}
}