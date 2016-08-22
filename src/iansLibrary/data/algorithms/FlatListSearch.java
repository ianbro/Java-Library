/**
 * @TODO: TODO
 *
 * @author Ian
 * Created: Jul 27, 2016
 */
package iansLibrary.data.algorithms;

import java.util.HashMap;
import java.util.List;

/**
 * <p>Includes various searching algorithms</p>
 *
 * @author Ian
 * Created: Jul 27, 2016
 *
 */
public abstract class FlatListSearch {

	/**
	 * Executes a binary search on the list of data provided for the target.
	 * The definition of a binary search can be found here:
	 * <br><br>
	 * {@link http://www.tutorialspoint.com/data_structures_algorithms/binary_search_algorithm.htm}
	 * @param data
	 * @param target - item to search for
	 * @return
	 */
	public static <E extends Comparable<E>> int binarySearch(List<E> data, E target) {
		/*
		 * This method is not the core of the logic. This is a wrapper
		 * method for calling binSearchNextComparison with an initial
		 * upper and lower bound and key.
		 */
		int upperIndex = data.size()-1;
		int lowerIndex = 0;
		int keyIndex = (upperIndex + lowerIndex)/2;
		
		int indexOfTarget = binSearchNextComparison(data, target, upperIndex, lowerIndex, keyIndex);
		if (indexOfTarget == -1) {
			return -1;
		} else {
			return indexOfTarget;
		}
	}
	
	/**
	 * Executes the binary search method recursively.
	 * 
	 * @param data - list of data to search through
	 * @param target - instance expected and searched for
	 * @param upper - upper limit of the binary search's current scope
	 * @param lower - lower limit of the binary search's current scope
	 * @param key - index of the element to which to compare the target.
	 * @return
	 * <ul>
	 * 		<li>-1 if target cannot be found</li>
	 * 		<li>the index of where the target was found</li>
	 * </ul>
	 */
	private static <E extends Comparable<E>> int binSearchNextComparison(List<E> data, E target,
												int upper, int lower, int key) {
		/*
		 * *****************
		 * If the key, upper limit or lower limit are equal to target, then
		 * just return that.
		 * *****************
		 */
		if (target.compareTo(data.get(upper)) == 0) {
			return upper;
		} else if (target.compareTo(data.get(lower)) == 0) {
			return lower;
		} else if (target.compareTo(data.get(key)) == 0) {
			return key;
		}
		/*
		 * *****************
		 * If the binary search has finished and the target is not found,
		 * return null.
		 * *****************
		 */
			/*
			 * If upper and lower are 2 or less indexes away from eachother, then
			 * we know that the search is on it's last comparison.
			 */
		else if (upper - lower <= 2) {
			/*
			 * We know that none of the upper, lower or key are equal to the
			 * target because we checked this above
			 */
			return -1;
		}
		/*
		 * *****************
		 * Otherwise, proceed with the comparisons
		 * *****************
		 */
		else if (target.compareTo(data.get(key)) > 0) {
			lower = key;
			key = (lower + upper)/2;
		} else if (target.compareTo(data.get(key)) < 0) {
			upper = key;
			key = (lower + upper)/2;
		}
		/*
		 * TODO:
		 * Add check in here for if the search returns no results.
		 * Otherwise, it will just loop endlessly
		 */
		return binSearchNextComparison(data, target, upper, lower, key);
	}
}
