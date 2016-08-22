/**
 * @TODO: TODO
 *
 * @author Ian
 * Created: Jul 28, 2016
 */
package iansLibrary.data.algorithms;

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
		testFlatListSearch();
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
		System.out.println(data);
		System.out.println("Searching for 6...");
		int indexOf6 = FlatListSearch.binarySearch(data, 6);
		if (indexOf6 != -1) {
			System.out.println("Found 6 at index: " + indexOf6);
			return true;
		} else {
			System.out.println("6 not found.");
			return false;
		}
	}
}
