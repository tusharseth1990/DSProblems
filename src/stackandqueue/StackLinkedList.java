package stackandqueue;

public class StackLinkedList {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	Node head;
	
	Boolean isEmpty() {
		if(head == null) {
			return true;
		}
		else return false;
	}
	
	void push(int x) {
		Node n = new Node(x);
		if(head==null) {
			head = n;
		}
		else {
			Node temp = head;
			head = n;
			n.next=temp;
		}
	}
	
	void pop() {
		if(head==null) {
			System.out.println("Underflow");
		}else {
			int x = head.data;
			System.out.println("element which got poped ="+x);
			head = head.next;
		}
	}
	
	int peek() {
		if(head==null) {
			return -1;
		}else {
			return head.data;
		}
	}
	
	public static void main(String[] args) {
		StackLinkedList s = new StackLinkedList();
		s.push(10);
		s.push(30);
		s.push(20);
		s.pop();
	
	}

}
