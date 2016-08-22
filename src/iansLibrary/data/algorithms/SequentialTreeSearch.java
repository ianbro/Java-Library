/**
 * @TODO: TODO
 *
 * @author Ian
 * Created: Jul 26, 2016
 */
package iansLibrary.data.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import iansLibrary.data.structures.tree.Node;
import iansLibrary.data.structures.tree.Tree;
import iansLibrary.data.structures.tree.TreePath;

/**
 * <p>
 * Tree based search algorithm used for determining whether or not
 * an instance of E is present in a set of data. This algorithm assumes
 * that the E object is a compound object which is similar to other
 * instances in the data in that some instances can be broken down
 * into sub-instances which are also contained in the data. This
 * algorithm assumes that the data is sorted on each level of the tree.
 * </p>
 * 
 * <p>
 * for instance, assume a SequentialTreeSearch is instantiated where
 * E references String and S is the equivelant of Character. The data
 * might be a paragraph which is represented as a list of words (Strings).
 * Suppose the words contained in the paragraph include "spiderman", "spider",
 * and "man". "spiderman" is a compound of "spider" and "man". A partial
 * search for "spid" will return both "spider" and "spiderman" but not "man".
 * </p>
 *
 * @author Ian
 * Created: Jul 26, 2016
 *
 */
public class SequentialTreeSearch<S extends Comparable<S>, E extends List<S>> {

	/**
	 * Tree used to store the parsed data of which to search.
	 */
	private Tree<S> data;

	/**
	 * Wrapper class for iansLibrary.data.structures.tree.Node
	 * which adds a variable isEndPoint which determines if the current
	 * node marks the finish of an element in the data.
	 * @TODO: TODO
	 *
	 * @author Ian
	 * Created: Jul 26, 2016
	 *
	 */
	public class SequenceStep extends Node<S> implements Comparable<SequenceStep> {
		
		/**
		 * Determines wether or not this character marks the end of a
		 * compound in the tree's data.
		 */
		public boolean isEndPoint = false;
		
		public SequenceStep(){};
		
		public SequenceStep(Node<S> parent, Integer limit, Tree<S> hostTree, S value){
			super(parent, limit, hostTree, value);
		}
		
		public SequenceStep(Integer limit, Tree<S> hostTree, S value){
			//constructor for anchor node
			super(limit, hostTree, value);
		}
		
		/**
		 * Returns this.children as type java.util.ArrayList<SequenceStep>
		 * instead of java.util.ArrayList<Node<E>>.
		 * @return
		 */
		public ArrayList<SequenceStep> childrenAsSequenceSteps() {
			ArrayList<SequenceStep> children = new ArrayList<SequenceStep>();
			
			for (Node<S> sequenceStepNode : this.children) {
				children.add((SequenceStep) sequenceStepNode);
			}
			return children;
		}

		@Override
		public int compareTo(SequenceStep o) {
			// TODO Auto-generated method stub
			return this.value.compareTo(o.value);
		}
	}
	
	public SequentialTreeSearch(Collection<E> _data) {
		this.data = new Tree<S>();
	}
	
	public SequentialTreeSearch() {
		this.data = new Tree<S>();
	}
	
	/**
	 * returns value as a SequenceStep with the value of value.
	 * @param _value
	 * @return
	 */
	public SequenceStep wrapAsSequenceStep(S _value) {
		SequenceStep wrapper = new SequenceStep();
		wrapper.value = _value;
		return wrapper;
	}
	
	/**
	 * parses out the data into the tree for this algorithm.
	 * @param data
	 */
	public void setData(Collection<E> _data) {
		
	}
	
	/**
	 * adds a single compound to the tree as a branch if it
	 * doesn't already exist.
	 * @param _item
	 */
	public void addData(E _item, SequenceStep _startFrom) {
		SequenceStep currentStep = null;
		if (_startFrom == null) {
			currentStep = new SequenceStep(null, this.data, _item.get(0));
		} else {
			currentStep = _startFrom;
		}
		
		for (int index = currentStep.getDepth() + 1; index < _item.size(); index ++) {
			S subItem = _item.get(index);
			/*
			 * Search through the current steps children for the entry of subItem.
			 * If subItem is not found in the children, then start a new branch
			 * from currentStep.
			 */
			int indexOfSubItem = FlatListSearch.binarySearch(currentStep.childrenAsSequenceSteps(),
																this.wrapAsSequenceStep(subItem));
			if (indexOfSubItem == -1) { //target sub item not found.
				SequenceStep stepToAddTo = currentStep;
				/*
				 * Add the rest of _item starting from currentStep as a new
				 * branch.
				 */
				ListIterator<S> unusedSubItems = _item.listIterator(index);
				while(unusedSubItems.hasNext()) {
					SequenceStep toAdd = new SequenceStep(stepToAddTo, -1, this.data, unusedSubItems.next());
					stepToAddTo.addChild(toAdd);
					stepToAddTo = toAdd;
				}
				stepToAddTo.isEndPoint = true;
				break;
			} else {
				if (index == _item.size()-1) {
					// This is the end of _item as a compound of
					// S so we will mark it so.
					currentStep.isEndPoint = true;
				} else {
					// We still have more data to add.
					this.addData(_item, currentStep);
				}
			}
		}
	}
	
	/**
	 * Walks through the tree and returns the node which contains the
	 * target instance as an exact match.
	 * @param _target
	 * @return
	 */
	public ArrayList<S> searchExact(E _target) {
		return null;
	}
	
	/**
	 * Walks through the tree and returns the node which either matches
	 * the search exactly or a list of nodes that contain compounds which
	 * include the target in their makeup.
	 * @param _target
	 * @return
	 */
	public ArrayList<S> searchPartialAnywhere(E _target) {
		return null;
	}
	
	/**
	 * Walks through the tree and returns the node which either matches
	 * the search exactly or a list of nodes that contain compounds which
	 * include the target in their makeup at the beginning of the compound.
	 * @param _target
	 * @return
	 */
	public ArrayList<ArrayList<S>> searchPartialBegin(E _target) {
		return null;
	}
	
	/**
	 * Walks through the tree and returns the node which either matches
	 * the search exactly or a list of nodes that contain compounds which
	 * include the target in their makeup at the end of the compound.
	 * @param _target
	 * @return
	 */
	public ArrayList<ArrayList<S>> searchPartialEnd(E _target) {
		return null;
	}
}
