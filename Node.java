package doubly_linked_list;

public class Node {
	int data;
	Node next, previous;
	
	// Constructor
	public Node(int d){
		next = null;
		previous = null;
		data = d;
	}
}
