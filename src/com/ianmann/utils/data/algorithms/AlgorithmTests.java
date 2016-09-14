/**
 * @TODO: TODO
 *
 * @author Ian
 * Created: Jul 28, 2016
 */
package com.ianmann.utils.data.algorithms;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * @TODO: TODO
 *
 * @author Ian
 * Created: Jul 28, 2016
 *
 */
public abstract class AlgorithmTests {

	public static void run() {
		runTest("testFlatListSearch");
		runTest("testSequentialTreeSearch");
		
	}
	
	static void runTest(String methodName) {
		try {
			System.out.println("Running test: " + methodName + "...");
			boolean success = (boolean) AlgorithmTests.class.getMethod(methodName, new Class[0]).invoke(null, new Object[0]);
			if (success) {
				System.out.println("  " + methodName + " test passed.");
			} else {
				System.out.println("  " + methodName + " test failed.");
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean testFlatListSearch() {
		ArrayList<Integer> data = new ArrayList<Integer>();
		data.add(1);
		data.add(2);
		data.add(3);
		data.add(4);
		data.add(5);
		data.add(6);
		data.add(7);
		data.add(8);
		data.add(9);
		data.add(10);
		data.add(11);
		data.add(12);
		data.add(13);
		int indexOf6 = FlatListSearch.binarySearch(data, 6);
		if (indexOf6 != -1) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean testSequentialTreeSearch() {
		SequentialTreeSearch<Character, ArrayList<Character>> wordSearch = new SequentialTreeSearch<>();
		
		ArrayList<Character> mother = new ArrayList<Character>();
		mother.add('m');
		mother.add('o');
		mother.add('t');
		mother.add('h');
		mother.add('e');
		mother.add('r');
		wordSearch.addData(mother, null);
		System.err.println("No errors but we haven't checked to see if the sequential tree search actually works yet.");
		return true;
	}
}
