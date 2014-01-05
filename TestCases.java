package com.adara;

import java.util.ArrayList;
import java.util.Hashtable;

public class TestCases {
	public static void main(String[] args) {
		TestCases.test1();
		TestCases.test2();
		TestCases.test3();
		TestCases.test4();
		TestCases.test5();
		TestCases.test6();
		TestCases.test7();
	}

	public static void printPercentages(ArrayList<PlacementAdMapping> pamArray) {
		Hashtable<PlacementAdMapping, Integer> testPercent = new Hashtable<PlacementAdMapping, Integer>();
		int count = 300000;
		AdCallProcessor acp = new AdCallProcessor();
		for (int i = 0; i < count; i++) {
			PlacementAdMapping p = acp.chooseAd(pamArray);
			if (p == null)
				return;
			if (testPercent.containsKey(p)) {
				testPercent.put(p, testPercent.get(p) + 1);
			} else {
				testPercent.put(p, 1);
			}
		}
		PlacementAdMapping[] keys = new PlacementAdMapping[testPercent.size()];
		testPercent.keySet().toArray(keys);
		for (int i = 0; i < keys.length; i++) {
			System.out.println((float) ((float) testPercent.get(keys[i]) / count)
							+ " " + keys[i].getCreativeId());
		}

	}

	public static void test1() {
		//This should result in the same ad being picked 100% of the time
		ArrayList<PlacementAdMapping> pamArray = new ArrayList<PlacementAdMapping>();
		pamArray.add(new PlacementAdMapping(1, 100, 10));
		System.out.println("Test 1");
		printPercentages(pamArray);
		System.out.println("");
	}

	public static void test2() {
		ArrayList<PlacementAdMapping> pamArray = new ArrayList<PlacementAdMapping>();
		//This should result in a 20%,40% and 40%
		pamArray.add(new PlacementAdMapping(1, 100, 10));
		pamArray.add(new PlacementAdMapping(1, 101, 20));
		pamArray.add(new PlacementAdMapping(1, 102, 20));
		System.out.println("Test 2");
		printPercentages(pamArray);
		System.out.println("");
	}

	public static void test3() {
		ArrayList<PlacementAdMapping> pamArray = new ArrayList<PlacementAdMapping>();
		//This should result in a 75% and 25% result
		pamArray.add(new PlacementAdMapping(1, 100, 15));
		pamArray.add(new PlacementAdMapping(1, 103, 5));
		System.out.println("Test 3");
		printPercentages(pamArray);
		System.out.println("");
	}

	public static void test4() {
		// Testing to make sure MaxValue works.
		//This should result in the same ad being picked 100% of the time
		ArrayList<PlacementAdMapping> pamArray = new ArrayList<PlacementAdMapping>();
		pamArray.add(new PlacementAdMapping(1, 100, Integer.MAX_VALUE));
		System.out.println("Test 4");
		printPercentages(pamArray);
		System.out.println("");
	}

	public static void test5() {
		// This should result in an error
		// "Error, there are no elements in the collection"
		ArrayList<PlacementAdMapping> pamArray = new ArrayList<PlacementAdMapping>();
		System.out.println("Test 5");
		printPercentages(pamArray);
		System.out.println("");
	}

	public static void test6() {
		// This should result in an error
		// Error, the weight needs to be between 1 to MAXINTEGER
		ArrayList<PlacementAdMapping> pamArray = new ArrayList<PlacementAdMapping>();
		pamArray.add(new PlacementAdMapping(1, 100, -99));
		System.out.println("Test 6");
		printPercentages(pamArray);
		System.out.println("");
	}

	public static void test7() {
		// This produces an error, I wanted to make sure to catch that error
		// Normally exceeding Integer.MAX_VALUE would be rare but I still wanted
		// to catch it
		//Should result in the error "Error, The total weights excedded Integer.MAX_VALUE"
		ArrayList<PlacementAdMapping> pamArray = new ArrayList<PlacementAdMapping>();
		pamArray.add(new PlacementAdMapping(1, 100, Integer.MAX_VALUE));
		pamArray.add(new PlacementAdMapping(1, 103, 1));
		System.out.println("Test 7");
		printPercentages(pamArray);
		System.out.println("");
	}

}
