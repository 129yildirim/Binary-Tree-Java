import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MainClass {
	
	Node head;
	List<Node> list;
	
	public static void main(String[] args) {
		MainClass c = new MainClass();
	}
	
	public MainClass() {
		
		initializations();
		
		System.out.println("Depth First Algorithm (Recursive) ...");
		depthFirstRecursive(head);
		System.out.println();
		
		System.out.println("Depth First Algorithm (Stack) ....");
		depthFirstStack(head);
	
		
		System.out.println("Breadth First Algorithm (Queue) ...");
		breadthFirstQueue(head);
		
		
		System.out.println("include(breadth first iterative)?: " + includeWithBreadthFirstIterative(head, 25));
		
		System.out.println("include(depth first recursive)? " + includeWithDepthFirstRecursive(head, 25));
		
		
		System.out.println("sum with depth first recursive: " + sumWithDepthFirstRecursive(head));
		System.out.println("sum with breadth first iterative: " + sumWithBreadthFirstIterative(head));
		
		System.out.println("min with depth first iterative: " + minWithDepthFirstIterative(head));
		
		
		System.out.println("max path sum root to leaf depth firt recursive: "+ maxPathSumRootToLeafDFArecursive(head));
		
	}
	
	
	public int maxPathSumRootToLeafDFArecursive(Node node) {
		
		if(node == null) return 0; 
		if(node.left == null && node.right == null) return node.value;
		
		int maxSum = node.value + Math.max(maxPathSumRootToLeafDFArecursive(node.left), maxPathSumRootToLeafDFArecursive(node.right));
		
		return maxSum;
	}
	
	public int minWithDepthFirstIterative(Node head) {
		
		if(head == null) return Integer.MAX_VALUE;
		
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(head);
		
		int min = Integer.MAX_VALUE;
		while(stack.size() > 0) {
			
			Node currentNode = stack.pop();
			
			if(currentNode.value < min) {
				min = currentNode.value;
			}
			
			if(currentNode.right != null) stack.push(currentNode.right);
			if(currentNode.left != null) stack.push(currentNode.left);
			
			
		}
		
		
		
		return min;
		
	}
	
	public int sumWithBreadthFirstIterative(Node head) {
		
		if(head == null) return 0;
		
		int sum = 0;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(head);
		
		while(queue.size() > 0) {
			
			Node currentNode = queue.poll();
			
			sum += currentNode.value;
			
			if(currentNode.left != null) queue.offer(currentNode.left);
			if(currentNode.right != null) queue.offer(currentNode.right);
			
				
		}
		
		return sum;
	}
	
	public int sumWithDepthFirstRecursive(Node node) {
		if(node == null) return 0;
		
		return node.value + sumWithDepthFirstRecursive(node.left) + sumWithDepthFirstRecursive(node.right);
	}
	
	public boolean includeWithDepthFirstRecursive(Node node, int target) {
		if(node == null) return false;
		
		if(node.value == target) return true;
		
		return includeWithDepthFirstRecursive(node.left, target) || includeWithDepthFirstRecursive(node.right, target);
		
	}
	
	public boolean includeWithBreadthFirstIterative(Node head, int target) {
		if(head == null) return false;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(head);
		
		while(queue.size() > 0) {
			
			Node currentNode = queue.poll();
			
			if(currentNode.value == target)return true;
			
			if(currentNode.right != null) queue.offer(currentNode.right);
			if(currentNode.left != null) queue.offer(currentNode.left);
			
		}
		
		return false;
	}
	
	
	public void breadthFirstQueue(Node head) {
		if(head == null) return;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(head);
		
		while(queue.size() > 0) {
			Node currentNode = queue.poll();
			System.out.print(currentNode.value + ",  ");
			
			if(currentNode.left != null) queue.offer(currentNode.left);
			if(currentNode.right != null) queue.offer(currentNode.right);
		}
		System.out.println();
			
	}
	
	public void depthFirstRecursive(Node node) {
		if(node == null) return;
		
		System.out.print(node.value + ",  ");
		if(node.left != null) depthFirstRecursive(node.left);
		if(node.right != null) depthFirstRecursive(node.right);
		
	}
	public void depthFirstStack(Node head) {
		if(head == null) return;
		Stack<Node> stack = new Stack<Node>();
		
		stack.push(head);
		
		while(stack.size() > 0) {
			
			Node currentNode = stack.pop();
			System.out.print(currentNode.value + ",  ");
			
			if(currentNode.right != null) stack.push(currentNode.right);
			if(currentNode.left != null) stack.push(currentNode.left);
			
		}
		System.out.println();
		
	}
	
	/*
	 * 
	 *          100
	 * 	    /  \
	 * 	   49   51
	 *       / \   /  \
	 * 	 1  2  24  26
	 *       \         /
	 * 	  0       25
	 * 
	 * 
	 * 
	 */
	
	public void initializations() {
		list = new ArrayList<Node>();
		
		head = new Node(100);
		
		head.left = new Node(49);
		head.right = new Node(51);
		
		head.left.left = new Node(1);
		head.left.right = new Node(2);
	
		head.right.left = new Node(24);
		head.right.right = new Node(26);
		
		head.left.left.right = new Node(0);
		
		head.right.right.left = new Node(25);
	}
	
	
	

}
