import java.util.*;

public class OrderedList implements OrderedStructure {

    private static class Node {

      	private Comparable value;
      	private Node previous;
      	private Node next;

      	private Node ( Comparable value, Node previous, Node next ) {
      	    this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}
    }

    private Node head;

    public OrderedList() {
    	head = new Node(null,null,null);
		head.next = head;
		head.previous = head;
    }

    public int size() {
    	if(head.next == head){
			return 0;
		}
    	int size = 1;
		Node n = head.next;
    	while(n.next != head) {
    		size++;
    		n = n.next;
    	}
    	return size;
    }

    public Object get( int pos ) {
		if(pos>size() || pos<0){
			throw new IndexOutOfBoundsException();
		}
        int index = 0;
		if(pos == 0){
			return head.next.value;
		}
        Node current = head.next;
        while(index != pos) {	
        	current = current.next;
			index++;
        }
        return current.value;
    }

    public boolean add( Comparable o ) {
		if(o == null){
			throw new NullPointerException();
		}
		//Adds element to list if it is the first element
       if(head.next == head){
		   Node newNode = new Node(o,head,head);
		   head.previous = newNode;
		   head.next = newNode;
		   return true;
	   }
	   // Will add element to front of the list
	   else if(head.next.value.compareTo(o)>=0){
		   Node newNode = new Node(o,head,head.next);
		   head.next = newNode;
		   head.next.previous = newNode;
		   return true;
	   }
	   else{
		   Node n = head;
		   while(n.next != head && n.next.value.compareTo(o)<0){
			   n = n.next;
		   }
		   
		   Node newNode = new Node(o,n,n.next);
		   //adds element to the end of the list
		   if(n.next == head){
			   head.previous = newNode;
			   n.next = newNode;
		   }
		   //General Case
		   else{
			   n.next.previous = newNode;
			   n.next = newNode;
		   }
		   return true;
	   }
	   
    }

    public void remove( int pos ) {
		if(pos>size() || pos<0){
			throw new IndexOutOfBoundsException();
		}
		Node temp;
    	if(pos == 0){
			temp = head.next;
			head.next = head.next.next;
			head.next.next.previous = head;
			temp = null; // Scrubs from memory
		}
		else{
			Node n = head.next;
			int index = 0;
			while(n.next.next != head && index < pos-1){
				n = n.next;
				index++;
			}
			if(n.next.next == head){
				temp = n.next;
				temp = null;
				n.next = head;
				head.previous = n;
			}
			else{
				temp = n.next;
				n.next = n.next.next;
				n.next.next.previous = n;
				temp = null;
			}
		}
		
    }

	// 1 loop and iterate through the present list in the class checking if the current.next node is smaller in value
    public void merge(OrderedList other) {
		for(int i=0;i<other.size();i++){
			add((Comparable)other.get(i));
		}
		
		
    }  
}