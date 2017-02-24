package doubly_linked_list;

public class dub_linked_list {
	
	int size = 0;
	Node head = null;
	Node tail = null;
	
	public Node addAtStart(int data){
		System.out.println("Adding at the begining of the list");
		
		Node n = new Node(data);
		
		if(size == 0){
			head  = n;
			tail = n;
		}else{
			n.next = head;
			head.previous = n;
			head = n; // head is the new node add at the start
		}
		++size;
		return n; // New Node
	}
	
	public Node addAtEnd(int data){
		System.out.println("Adding at the end of the list");
		
		Node n = new Node(data);
		
		if(size == 0){
			head = n;
			tail = n;
		}else{
			n.previous = tail;
			tail.next = n;
			tail = n;
		}
		++size;
		return n;
	}
	
	public Node addAfter(int d, Node prevNode){
		if(prevNode == null){
			System.out.println("New node cannot be added to a null");
			return null;
		}else if(prevNode.next == null){
			return addAtEnd(d);
		}else{
			System.out.println("Adding node after " + prevNode.data);
			Node n = new Node(d);
			
			// store the prevNode's next
			Node nextNode = prevNode.next;
			
			/*n.next = nextNode;
			prevNode.next = n;
			nextNode.previous = n;
			n.previous = prevNode;*/
			
			prevNode.next = n;
			n.previous = prevNode;
			n.next = nextNode;
			nextNode.previous = n;
			size++;
			return n;
		}
	}
	
	public Node deleteAtStart(){
		Node newHead = head.next;
		System.out.println("Deleted head = " + head.data);
		
		newHead.previous = head.previous;
		head = newHead;
		System.out.println("New Head is at "+head.data);
		return head;
		
	}
	
	public Node deleteLast(){
		Node newTail = tail.previous;
		System.out.println("Deleted tail = "+ tail.data);
		
		newTail.next = tail.next;
		tail = newTail;
		System.out.println("New tail = "+ tail.data);
		
		return tail;
	}
	
	public int searchItem(int value){
		Node temp = head;
		int index = 0;
		
		while(temp != null){
			++index;
			if(temp.data == value){
				System.out.println("Found the item");
				break;
			}
			temp = temp.next;
		}
		return index;
	}
	
	public void printList(){
		Node temp = head;
		
		//System.out.println("Doubly linked list: ");

		while(temp!=null){
			if (temp.previous == null){
				System.out.print( "head" );
			}
			System.out.print(" < == > "+ temp.data);
			temp = temp.next;
		}
		System.out.print(" <==> tail");
		System.out.println();
	}
	
	public void printListBackwards(){
		Node temp = tail;
		
		while(temp != null){
			if (temp.next == null){
				System.out.print( "tail" );
			}
			System.out.print(" < == > "+ temp.data);
			temp = temp.previous;
		}
		System.out.print(" <==> head");
		System.out.println();
	}
	
	public static void main(String[] args){
		dub_linked_list d = new dub_linked_list();
		Node x = d.addAtStart(4);
		d.printList();
		d.addAtEnd(3);
		d.printList();
		Node y = d.addAfter(9, x);
		d.printList();
		d.addAfter(11, y);
		d.printList();
		d.addAfter(15, y);
		d.printList();
		System.out.println("Searched for 15 in the list, found at index : " + d.searchItem(15));
		d.deleteAtStart();
		d.printList();
		d.deleteAtStart();
		d.printList();
		d.addAtEnd(9);
		d.addAtEnd(4);
		d.printList();
		d.deleteLast();
		d.printList();
		d.printListBackwards();
		
	}

}
