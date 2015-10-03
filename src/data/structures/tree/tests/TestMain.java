/**
 * 
 */
package data.structures.tree.tests;

import data.structures.Queue;
import data.structures.Stack;
import data.structures.tree.Node;
import data.structures.tree.Tree;
import data.structures.tree.TreePath;

/**
 * @author Ian
 * @date Sep 25, 2015
 * @project Tree
 * @todo TODO
 */
public class TestMain {

	public static void test(){
		Stack<Integer> stack = new Stack<Integer>();
		stack.insert(1);
		stack.insert(2);
		stack.insert(3);
		stack.insert(4);
		stack.insert(5);
		
		System.out.println(stack.top());
		System.out.println(stack.toString());
		
		Queue<Integer> queue = new Queue<Integer>();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
		
		System.out.println(queue.peek());
		System.out.println(queue.toString());
		
		TreePath path = new TreePath();
		path.push(0);
		path.push(3);
		path.push(2);
		path.push(6);
		System.out.println(path.toString());
		
		path.poll();
		System.out.println(path.toString());
		
		path.reset();
		System.out.println(path.toString());
		
		Tree<Integer> tree = new Tree<Integer>();
		tree.setAnchor(null, tree, 0);
		tree.anchor.addChild(new Node<Integer>(tree.anchor, null, tree, 1));
		tree.anchor.addChild(new Node<Integer>(tree.anchor, null, tree, 2));
		tree.anchor.addChild(new Node<Integer>(tree.anchor, null, tree, 3));
		tree.anchor.addChild(new Node<Integer>(tree.anchor, null, tree, 4));
		tree.anchor.addChild(new Node<Integer>(tree.anchor, null, tree, 5));
		
		System.out.println(tree.anchor.toString());
		System.out.println(tree.anchor.childrenToString());
		System.out.println(tree.getDepth());
		System.out.println(tree.getBredth());
		System.out.println(tree.getSize());
	}
}
