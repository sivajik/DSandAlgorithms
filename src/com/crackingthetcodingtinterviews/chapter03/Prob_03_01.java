package com.crackingthetcodingtinterviews.chapter03;

public class Prob_03_01 {
	public static void main(String[] args) throws Exception {
		FixedMultiStack f = new FixedMultiStack(10);
		f.push(0, 20);
		f.push(0, 21);
		f.push(0, 21);
		f.push(0, 22);
		
		f.push(1, 31);
		f.push(1, 32);
		
		f.push(2, 41);
		f.push(2, 42);
		f.push(2, 43);
		
		System.out.println(f.pop(0));
		System.out.println(f.pop(1));
		System.out.println(f.pop(2));
	}
}

class FixedMultiStack {
	int numOfStacks = 3;
	int stackCapacity;
	int[] values;
	int[] sizes;

	public FixedMultiStack(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackCapacity * numOfStacks];
		sizes = new int[numOfStacks];
	}

	public void push(int stackNum, int value) {
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}

	public int pop (int stackNum) {
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNum]--;
		return value;
	}
	
	public boolean isEmppty(int stackNum) {
		return sizes[stackNum] == 0;
	}
	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}
}