package ch12_collection.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {

	public static void main(String[] args) {
		// LinkedList vs ArrayList
		List<String> listArray = new ArrayList<>();
		List<String> listLinkedList = new LinkedList<>();

		ArrayList<String> list1 = new ArrayList<>();
		LinkedList<String> list2 = new LinkedList<>();

		long startTime, endTime;

		startTime = System.nanoTime(); // 현재 시간을 나노초로 변환해서 반환
		for (int i = 0; i < 10000; i++) {
			listArray.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("listArray 걸린 시간 : " + (endTime-startTime) + "ns");
		
		startTime = System.nanoTime(); // 현재 시간을 나노초로 변환해서 반환
		for (int i = 0; i < 10000; i++) {
			listLinkedList.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("listLinkedList 걸린 시간 : " + (endTime-startTime) + "ns");
		
		System.out.println("------------------------------------------------------");
		
		startTime = System.nanoTime(); // 현재 시간을 나노초로 변환해서 반환
		for (int i = 0; i < 10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("listArray 걸린 시간 : " + (endTime-startTime) + "ns");
		
		startTime = System.nanoTime(); // 현재 시간을 나노초로 변환해서 반환
		for (int i = 0; i < 10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("listLinkedList 걸린 시간 : " + (endTime-startTime) + "ns");
		

	}

}
