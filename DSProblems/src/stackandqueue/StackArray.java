package stackandqueue;

public class StackArray {

	static final int MAX = 1000;
	
	int top;
	
	int a[] = new int[MAX];
	
	StackArray() {
		top = -1;
	}
	
	Boolean isEmpty() {
		if(top<0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	void push(int x) {
		if(top>=MAX-1) {
			System.out.println("Overflow");
		}
		else {
			a[++top]=x;		
			System.out.println(x+"element is pushed successfully");
		}
	
	}
	
	void pop() {
		if(top<0) {
			System.out.println("Underflow");
		}
		else {
			int y = a[top--];
			System.out.println("poped element is ="+y);
		}
	}
	
	int peek() {
		if(top<0) {
			return -1;
		}else {
			return a[top];
		}
	}
	public static void main(String[] args) {
	StackArray s = new StackArray();
	s.push(10);
	s.push(20);
	s.push(15);
	s.pop();
	boolean empty =s.isEmpty();
	System.out.println(empty);
	int last =s.peek();
	System.out.println(last);

	}

}
