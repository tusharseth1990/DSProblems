package linkedlistproblems;

import java.util.HashSet;
import java.util.Stack;

public class LinkedList {
	Node head;
	class Node {
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
		
	}
	
	public void addAtBeg(int x) {
		Node n = new Node(x);
		n.next = head;
		head = n;
	}

	public void append(int x) {
		Node new_node = new Node(x);
		if(head == null){
			head = new Node(x);
			return;
		}
		new_node.next = null;

		Node last = head;
		while(last.next !=null){
			last = last.next;
		}
		last.next = new_node;
		return;
	}

	public void insertAfter(int x,Node prev) {
		if (prev == null) 
	    { 
	        System.out.println("The given previous node cannot be null"); 
	        return; 
	    } 
		Node new_node = new Node(x); 
	    new_node.next = prev.next; 
	    prev.next = new_node;
	}
	
	public void deleteNode(int k) {
		Node temp = head, prev = null;
		if(temp == null)
			return;
		if(temp!=null && temp.data == k) {
			head = temp.next;
		}
		while(temp!=null && temp.data != k) {
			prev = temp;
			temp = temp.next;
		}
		prev = temp.next;
	}
	public void deletePos(int position) {

        // If linked list is empty 
        if (head == null) 
            return; 
  
        // Store head node 
        Node temp = head; 
  
        // If head needs to be removed 
        if (position == 0) 
        { 
            head = temp.next;   // Change head 
            return; 
        } 
  
        // Find previous node of the node to be deleted 
        for (int i=0; temp!=null && i<position-1; i++) 
            temp = temp.next; 
  
        // If position is more than number of nodes 
        if (temp == null || temp.next == null) 
            return; 
  
        // Node temp->next is the node to be deleted 
        // Store pointer to the next of node to be deleted 
        Node next = temp.next.next; 
  
        temp.next = next;  // Unlink the deleted node from list 
	}
	public int getCount() 
    { 
        Node temp = head; 
        int count = 0; 
        while (temp != null) 
        { 
            count++; 
            temp = temp.next; 
        } 
        return count; 
    } 
	public int countRec(Node node) {
		if(head == null)
			return 0;
		
		return 1+ countRec(node.next);
	}
	 public boolean search(Node head, int x) 
	    { 
	        Node current = head;    //Initialize current 
	        while (current != null) 
	        { 
	            if (current.data == x) 
	                return true;    //data found 
	            current = current.next; 
	        } 
	        return false;    //data not found 
	    } 
	 public void nthFromEnd(int n) {
		 Node slow_pt=head, fast_pt = head;
		 int count =0;
		 while(count<n) {
			 fast_pt=fast_pt.next;
		 
			 count++;
			 }
		 
		 while(fast_pt!=null) {
			 fast_pt=fast_pt.next;
			 slow_pt=slow_pt.next;
		 }
		 System.out.println(slow_pt.data);
	 }
//	 METHOD 1 (Use a Stack)
//
//	 A simple solution is to use a stack of list nodes. This mainly involves three steps.
//	 Traverse the given list from head to tail and push every visited node to stack.
//	 Traverse the list again. For every visited node, pop a node from stack and compare data of popped node with currently visited node.
//	 If all nodes matched, then return true, else false.
	 boolean isPalindrome(Node head) 
	    { 
	  
	        Node slow = head; 
	        boolean ispalin = true; 
	        Stack<Integer> stack = new Stack<Integer>(); 
	  
	        while (slow != null) { 
	            stack.push(slow.data); 
	            slow = slow.next; 
	        } 
	  
	        while (head != null) { 
	  
	            int i = stack.pop(); 
	            if (head.data == i) { 
	                ispalin = true; 
	            } 
	            else { 
	                ispalin = false; 
	                break; 
	            } 
	            head = head.next; 
	        } 
	        return ispalin; 
	    } 
	 
//	 METHOD 2 (By reversing the list)
//	 This method takes O(n) time and O(1) extra space.
//	 1) Get the middle of the linked list.
//	 2) Reverse the second half of the linked list.
//	 3) Check if the first half and second half are identical.
//	 4) Construct the original linked list by reversing the second half again and attaching it back to the first half
//	 
	 
	 /* Function to print middle of linked list */
	    void printMiddle() 
	    { 
	        Node slow_ptr = head; 
	        Node fast_ptr = head; 
	        if (head != null) 
	        { 
	            while (fast_ptr != null && fast_ptr.next != null) 
	            { 
	                fast_ptr = fast_ptr.next.next; 
	                slow_ptr = slow_ptr.next; 
	            } 
	            System.out.println("The middle element is [" + 
	                                slow_ptr.data + "] \n"); 
	        } 
	    } 
	    
	     boolean detectLoop(Node h) 
	    { 
	        HashSet<Node> s = new HashSet<Node>(); 
	        while (h != null) { 
	            // If we have already has this node 
	            // in hashmap it means their is a cycle 
	            // (Because you we encountering the 
	            // node second time). 
	            if (s.contains(h)) 
	                return true; 
	  
	            // If we are seeing the node for 
	            // the first time, insert it in hash 
	            s.add(h); 
	  
	            h = h.next; 
	        } 
	  
	        return false; 
	    } 
	     void detectLoop() 
	     { 
	         Node slow_p = head, fast_p = head; 
	         int flag = 0; 
	         while (slow_p != null && fast_p != null && fast_p.next != null) { 
	             slow_p = slow_p.next; 
	             fast_p = fast_p.next.next; 
	             if (slow_p == fast_p) { 
	                 flag = 1; 
	                 break; 
	             } 
	         } 
	         if (flag == 1) 
	             System.out.println("Loop found"); 
	         else
	             System.out.println("Loop not found"); 
	     } 
	     
	      int countNodes( Node n)  
	     {  
	     int res = 1;  
	     Node temp = n;  
	     while (temp.next != n)  
	     {  
	         res++;  
	         temp = temp.next;  
	     }  
	     return res;  
	     }  
	     // remove duplicates from a sorted linked list 
	      void removeDuplicates() 
	      { 
	          /*Another reference to head*/
	          Node curr = head; 
	    
	          /* Traverse list till the last node */
	          while (curr != null) { 
	               Node temp = curr; 
	              /*Compare current node with the next node and  
	              keep on deleting them until it matches the current  
	              node data */
	              while(temp!=null && temp.data==curr.data) { 
	                  temp = temp.next; 
	              } 
	              /*Set current node next to the next different  
	              element denoted by temp*/
	              curr.next = temp; 
	              curr = curr.next; 
	          } 
	      } 
	      
	      
	     /* This function detects and counts loop  
	     nodes in the list. If loop is not there  
	     in then returns 0 */
	      int countNodesinLoop( Node list)  
	     {  
	         Node slow_p = list, fast_p = list;  
	       
	         while (slow_p !=null && fast_p!=null && fast_p.next!=null)  
	         {  
	             slow_p = slow_p.next;  
	             fast_p = fast_p.next.next;  
	       
	             /* If slow_p and fast_p meet at some point  
	             then there is a loop */
	             if (slow_p == fast_p)  
	                 return countNodes(slow_p);  
	         }  
	       
	         /* Return 0 to indeciate that ther is no loop*/
	         return 0;  
	     } 
	      
	   // Returns true if the loop is removed from the linked 
	      // list else returns false. 
	      static boolean removeLoop(Node h) 
	      { 
	          HashSet<Node> s = new HashSet<Node>(); 
	          Node prev = null; 
	          while (h != null) { 
	              // If we have already has this node 
	              // in hashmap it means their is a cycle and we 
	              // need to remove this cycle so set the next of 
	              // the previous pointer with null. 
	    
	              if (s.contains(h)) { 
	                  prev.next = null; 
	                  return true; 
	              } 
	    
	              // If we are seeing the node for 
	              // the first time, insert it in hash 
	              else { 
	                  s.add(h); 
	                  prev = h; 
	                  h = h.next; 
	              } 
	          } 
	    
	          return false; 
	      } 
	      
	      
	    /* Function to remove duplicates from a 
	       unsorted linked list */
	    static void removeDuplicate(Node head)  
	    { 
	        // Hash to store seen values 
	        HashSet<Integer> hs = new HashSet<>(); 
	      
	        /* Pick elements one by one */
	        Node current = head; 
	        Node prev = null; 
	        while (current != null)  
	        { 
	            int curval = current.data; 
	              
	             // If current value is seen before 
	            if (hs.contains(curval)) { 
	                prev.next = current.next; 
	            } else { 
	                hs.add(curval); 
	                prev = current; 
	            } 
	            current = current.next; 
	        } 
	  
	    } 
	    
	    //Program to move last element to front in a given linked list
	    void moveToFront() 
	    { 
	        /* If linked list is empty or it contains only 
	           one node then simply return. */
	           if(head == null || head.next == null)  
	              return; 
	  
	        /* Initialize second last and last pointers */
	        Node secLast = null; 
	        Node last = head; 
	  
	        /* After this loop secLast contains address of  
	           second last  node and last contains address of  
	           last node in Linked List */
	        while (last.next != null)   
	        { 
	           secLast = last; 
	           last = last.next;  
	        } 
	  
	        /* Set the next of second last as null */
	        secLast.next = null; 
	  
	        /* Set the next of last as head */
	        last.next = head; 
	  
	        /* Change head to point to last node. */
	        head = last; 
	    }                  
	  
	 // Java program to pairwise swap elements of a linked list 
	    void pairWiseSwap() 
	    { 
	        Node temp = head; 
	  
	        /* Traverse only till there are atleast 2 nodes left */
	        while (temp != null && temp.next != null) { 
	  
	            /* Swap the data */
	            int k = temp.data; 
	            temp.data = temp.next.data; 
	            temp.next.data = k; 
	            temp = temp.next.next; 
	        } 
	    } 
	    
	  /*  Function to swap Nodes x and y in linked list by 
	       changing links */
	    public void swapNodes(int x, int y) 
	    { 
	        // Nothing to do if x and y are same 
	        if (x == y) return; 
	  
	        // Search for x (keep track of prevX and CurrX)
	        Node prevX = null, currX = head; 
	        while (currX != null && currX.data != x) 
	        { 
	            prevX = currX; 
	            currX = currX.next; 
	        } 
	  
	        // Search for y (keep track of prevY and currY) 
	        Node prevY = null, currY = head; 
	        while (currY != null && currY.data != y) 
	        { 
	            prevY = currY; 
	            currY = currY.next; 
	        } 
	  
	        // If either x or y is not present, nothing to do 
	        if (currX == null || currY == null) 
	            return; 
	  
	        // If x is not head of linked list 
	        if (prevX != null) 
	            prevX.next = currY; 
	        else //make y the new head 
	            head = currY; 
	  
	        // If y is not head of linked list 
	        if (prevY != null) 
	            prevY.next = currX; 
	        else // make x the new head 
	            head = currX; 
	  
	        // Swap next pointers 
	        Node temp = currX.next; 
	        currX.next = currY.next; 
	        currY.next = temp; 
	    } 
	  
	    Node reverse(Node node) 
	    { 
	        Node prev = null; 
	        Node current = node; 
	        Node next = null; 
	        while (current != null) { 
	            next = current.next; 
	            current.next = prev; 
	            prev = current; 
	            current = next; 
	        } 
	        node = prev; 
	        return node; 
	    } 
	    
	    Node reverseKNodes(Node head, int k)
	    {
	        if(head == null)
	          return null;
	        Node current = head;
	        Node next = null;
	        Node prev = null;
	 
	        int count = 0;
	 
	        /* Reverse first k nodes of linked list */
	        while (count < k && current != null) {
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	            count++;
	        }
	 
	        /* next is now a pointer to (k+1)th node
	           Recursively call for the list starting from
	           current. And make rest of the list as next of
	           first node */
	        if (next != null)
	            head.next = reverseKNodes(next, k);
	 
	        // prev is now head of input list
	        return prev;
	    }
	    
	    
	 // function to find the intersection of two node 
	    public static Node YNode(Node n1, Node n2) 
	    { 
	        // define hashset 
	        HashSet<Node> hs = new HashSet<Node>(); 
	        while (n1 != null) { 
	            hs.add(n1); 
	            n1 = n1.next; 
	        } 
	        while (n2 != null) { 
	            if (hs.contains(n2)) { 
	                return n2; 
	            } 
	            n2 = n2.next; 
	        } 
	        return null; 
	    } 
	    //sort 0,1,2 in L.L
	    void sortList() 
	    { 
	       // initialise count of 0 1 and 2 as 0 
	       int count[] = {0, 0, 0};  
	         
	       Node ptr = head; 
	         
	       /* count total number of '0', '1' and '2' 
	        * count[0] will store total number of '0's 
	        * count[1] will store total number of '1's 
	        * count[2] will store total number of '2's  */
	       while (ptr != null)  
	       { 
	            count[ptr.data]++; 
	            ptr = ptr.next; 
	       } 
	  
	       int i = 0; 
	       ptr = head; 
	  
	       /* Let say count[0] = n1, count[1] = n2 and count[2] = n3 
	        * now start traversing list from head node, 
	        * 1) fill the list with 0, till n1 > 0 
	        * 2) fill the list with 1, till n2 > 0 
	        * 3) fill the list with 2, till n3 > 0  */
	        while (ptr != null)  
	        { 
	            if (count[i] == 0) 
	                i++; 
	            else 
	            { 
	               ptr.data= i; 
	               --count[i]; 
	               ptr = ptr.next; 
	            } 
	         } 
	    }    
	    
	    public Node addTwoNumbers(Node l1, Node l2) {
	    	Node dummyHead = new Node(0);
	    	Node p = l1, q = l2, curr = dummyHead;
	        int carry = 0;
	        while (p != null || q != null) {
	            int x = (p != null) ? p.data : 0;
	            int y = (q != null) ? q.data : 0;
	            int sum = carry + x + y;
	            carry = sum / 10;
	            curr.next = new Node(sum % 10);
	            curr = curr.next;
	            if (p != null) p = p.next;
	            if (q != null) q = q.next;
	        }
	        if (carry > 0) {
	            curr.next = new Node(carry);
	        }
	        return dummyHead.next;
	    }
	    
	  //  Add two numbers represented by linked lists
	    Node addTwoLists(Node first, Node second) 
	    { 
	        // res is head node of the resultant list 
	        Node res = null; 
	        Node prev = null; 
	        Node temp = null; 
	        int carry = 0, sum; 
	  
	        // while both lists exist 
	        while (first != null || second != null) { 
	            // Calculate value of next 
	            // digit in resultant list. 
	            // The next digit is sum 
	            // of following things 
	            // (i)  Carry 
	            // (ii) Next digit of first 
	            // list (if there is a next digit) 
	            // (ii) Next digit of second 
	            // list (if there is a next digit) 
	            sum = carry + (first != null ? first.data : 0) 
	                  + (second != null ? second.data : 0); 
	  
	            // update carry for next calulation 
	            carry = (sum >= 10) ? 1 : 0; 
	  
	            // update sum if it is greater than 10 
	            sum = sum % 10; 
	  
	            // Create a new node with sum as data 
	            temp = new Node(sum); 
	  
	            // if this is the first node then set 
	            // it as head of the resultant list 
	            if (res == null) { 
	                res = temp; 
	            } 
	  
	            // If this is not the first 
	            // node then connect it to the rest. 
	            else { 
	                prev.next = temp; 
	            } 
	  
	            // Set prev for next insertion 
	            prev = temp; 
	  
	            // Move first and second pointers 
	            // to next nodes 
	            if (first != null) { 
	                first = first.next; 
	            } 
	            if (second != null) { 
	                second = second.next; 
	            } 
	        } 
	  
	        if (carry > 0) { 
	            temp.next = new Node(carry); 
	        } 
	  
	        // return head of the resultant list 
	        return res; 
	    } 
	    
	    public Node mergeTwoLists(Node l1, Node l2) {
	        if (l1 == null) {
	            return l2;
	        }
	        else if (l2 == null) {
	            return l1;
	        }
	        else if (l1.data < l2.data) {
	            l1.next = mergeTwoLists(l1.next, l2);
	            return l1;
	        }
	        else {
	            l2.next = mergeTwoLists(l1, l2.next);
	            return l2;
	        }

	    }
	    
	    public Node mergeTwoListsReducingSpaceComplexity(Node l1, Node l2) {
	        // maintain an unchanging reference to node ahead of the return node.
	    	Node prehead = new Node(-1);

	    	Node prev = prehead;
	        while (l1 != null && l2 != null) {
	            if (l1.data <= l2.data) {
	                prev.next = l1;
	                l1 = l1.next;
	            } else {
	                prev.next = l2;
	                l2 = l2.next;
	            }
	            prev = prev.next;
	        }

	        // At least one of l1 and l2 can still have nodes at this point, so connect
	        // the non-null list to the end of the merged list.
	        prev.next = l1 == null ? l2 : l1;

	        return prehead.next;
	    }
	    
	    public Node oddEvenList(Node head) {
	        if (head == null) return null;
	        Node odd = head, even = head.next, evenHead = even;
	        while (even != null && even.next != null) {
	            odd.next = even.next;
	            odd = odd.next;
	            even.next = odd.next;
	            even = even.next;
	        }
	        odd.next = evenHead;
	        return head;
	    }
	    
	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.append(5);
		l1.append(5);
		l1.append(5);
		l1.append(52);
		l1.append(15);
		l1.append(15);
		l1.append(7);	
		l1.append(5);		
	}

}
