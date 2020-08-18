package com.recusion;

import java.util.ArrayList;
import java.util.List;

public class Prob02_SortArrayUsingRecursion {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(6);
		list.add(0);
		list.add(3);
		list.add(1);
		list.add(4);
		sort(list);
		System.out.println(list);

		List<Integer> list1 = new ArrayList<>();
		list1.add(0);
		list1.add(1);
		list1.add(5);
		insert(list1, 2);
		System.out.println(list1);

	}

	private static void sort(List<Integer> list) {
		if (list.size() == 1) {
			return;
		}
		int lastValue = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		sort(list.subList(0, list.size()));
		insert(list, lastValue);
		return;
	}

	// 0 1 5 6
	private static void insert(List<Integer> list, int lastValue) {
		if (list.size() == 0 || list.get(list.size() - 1) <= lastValue) {
			list.add(lastValue);
			return;
		}

		int lv = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		insert(list.subList(0, list.size()), lastValue);
		list.add(lv);
	}

}
