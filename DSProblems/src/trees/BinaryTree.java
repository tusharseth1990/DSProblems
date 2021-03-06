package trees;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/////ALL QUESTIONS combined Use this for learning
//BFS and DFSs of above Tree
//
//Breadth First Traversal : 1 2 3 4 5(Level order)
//
//Depth First Traversals:
//      Preorder Traversal : 1 2 4 5 3 
//      Inorder Traversal  :  4 2 5 1 3 
//      Postorder Traversal : 4 5 2 3 1

public class BinaryTree {

	Node root;
	
	public BinaryTree() {
		root =null;
	}
	public void printInOrder(Node root) {
		if(root == null) {
			return;
		}else {
			printInOrder(root.left);
			System.out.println(root.data);
			printInOrder(root.right);
		}
	}
	public void printPreOrder(Node root) {
		if(root == null) {
			return;
		}else {
			System.out.println(root.data);
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
	}
	public void printPostOrder(Node root) {
		if(root == null) {
			return;
		}else {
			printPostOrder(root.left);
			printPostOrder(root.right);
			System.out.println(root.data);
		}
	}
	public void printlevelOrder(Node root) {
		int h = height(root);
		for(int i=1;i<=h;i++) {
			printGivenLevel(root,i);
		}
	}
	public int height(Node root) {
		if(root == null)
			return 0;
		int lh = height(root.left);
		int rh = height(root.right);
		if(lh>rh) {
			return (lh+1);
		}else {
			return (rh+1);
		}
	}
	public void printGivenLevel(Node root,int level) {
		if(root == null)
			return;
		if(level == 1) {
			System.out.println(root.data);
		}
		if(level>1) {
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);

		}
	}
	//Iterative level order
	public void levelOrderUsingQueue(Node root) {
		Queue<Node> q1 = new LinkedList<>();
		q1.add(root);
		while(!q1.isEmpty()) {
			Node temp = q1.poll();
			System.out.println(temp.data);
			if(temp.left!=null) {
				q1.add(temp.left);
			}
			if(temp.right!=null) {
				q1.add(temp.right);
			}				
		}
	}
	//iterative Pre-order traversal
	public void preOrderTraversal(Node root) {
		Stack<Node> s1 = new Stack<Node>();
		if(root == null)
			return;
		s1.push(root);
		while(!s1.isEmpty()) {
			Node temp = s1.peek();
			System.out.println(temp.data);
			s1.pop();
			if(temp.right!=null) {
				s1.push(temp.right);
			}
			if(temp.left!=null) {
				s1.push(temp.left);
			}
		}
	}
	
	//iterative in-order traversal 
	public void inOrderTraversal(Node root) {
		Stack<Node> s1 = new Stack<>();
		boolean done = false;
		Node curr = root;
		while(!done) {
			if(curr!=null) {
				s1.add(curr);
				curr = curr.left;
			}
			else
			{
				if(s1.isEmpty())
					done = true;
				else {
					curr = s1.pop();
					System.out.println(curr.data);
					curr = curr.right;					
				}
			}
		}
	}
	//iterative post order traversal with 2 stacks
	public void postOrderTraversal(Node root) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		if(root == null)
			return;
		else {
			s1.push(root);
			while(!s1.isEmpty()) {
				Node temp = s1.pop();
				s2.push(temp);
				if(temp.left!=null) {
					s1.push(temp.left);
				}
				if(temp.right!=null) {
					s1.push(temp.right);
				}
			}
			while(!s2.isEmpty()) {
				Node temp = s2.pop();
				System.out.println(temp.data); 
				
			}
		}
		
	}
	
	//find max in binary tree with recursion
	public int maxInBT(Node root) {
		int max = Integer.MIN_VALUE;
		if(root!=null) {
			int lmax = maxInBT(root.left);
			int rmax = maxInBT(root.right);
			if(lmax>rmax) {
				max = lmax;
			}else {
				max = rmax;
			}
			if(root.data>max) {
				max = root.data;
			}
		}
		return max;
	}
	
	//find max in binary tree without recursion
	public int maxinBTLevelOrder(Node root) {
		int max = Integer.MIN_VALUE;
		if(root == null)
			return max;
		Queue<Node> q1 = new LinkedList<>();
		q1.add(root);
		while(!q1.isEmpty()) {
			Node temp = q1.peek();
			//max condition
			if(temp.data > max) {
				max = temp.data;
			}
			if(temp.left!=null) {
				q1.add(temp.left);			
			}
			if(temp.right!=null) {
				q1.add(temp.right);
			}
		}
		return  max;
	}
	
	//search an element in Binary tree
	public Boolean searchInBTree(Node root,int s) {
		if(root == null)
			return false;
		
		Queue<Node> q1 = new LinkedList<>();
		q1.add(root);
		while(!q1.isEmpty()) {
			Node temp = q1.peek();
			if(temp.data==s) {
				return true;
			}
			if(temp.left!=null) {
				q1.add(temp.left);
			}
			if(temp.right!=null) {
				q1.add(temp.right);
			}
		}
		return false;
	}
	//insert an element in Binary tree
	
	//size of a binary tree
	public int size(Node root) {
		int lc = (root.left == null) ? 0 : size(root.left);
		int rc = (root.right == null) ? 0 : size(root.right);
		return 1 + lc +rc;
	}
	
	//size of a binary tree without recurion
	public int sizeWithoutRecusion(Node root) {
		int c=0;
		if(root ==null)
			return 0;
		Queue<Node> q1 = new LinkedList<>();
		q1.add(root);
		while(!q1.isEmpty()) {
			Node temp = q1.peek();
			c++;
			if(temp.left!=null) {
				q1.add(temp.left);
			}
			if(temp.right!=null) {
				q1.add(temp.right);
			}
		}
		return c;
	}
	//print BT in spiral form
	public void printSpiralTraversal(Node root) {
		int h = heightForSpiral(root);
		boolean lhr = false;
		for(int i=1;i<=h;i++) {
			printGivenLevelSpiral(root,i,lhr);
			lhr=!lhr;
		}
	}
	private void printGivenLevelSpiral(Node root, int i, boolean lhr) {
		if(root == null)
			return;
		if(i==1) {
			System.out.println(root.data);
		}
		if(i>1 && lhr) {
			printGivenLevelSpiral(root.left,i-1,lhr);
			printGivenLevelSpiral(root.right,i-1,lhr);
		}
		if(i>1 && !lhr) {
			printGivenLevelSpiral(root.right,i-1,lhr);
			printGivenLevelSpiral(root.left,i-1,lhr);
		}
	}
	private int heightForSpiral(Node root) {
		if(root == null)
			return 0;
		int lh=heightForSpiral(root.left);
		int rh=heightForSpiral(root.right);
		if(lh>rh) {
			return lh+1;
		}
		else {
			return rh+1;
		}
	}

	
	//find the no of nodes in BT
	public int NoOfLeavesInBTree(Node root) {
		int c=0;
		if(root == null)
			return 0;
		Queue<Node> q1 = new LinkedList<>();
		q1.add(root);
		while(!q1.isEmpty()) {
			Node temp = q1.peek();
				if(temp.left==null && temp.right==null) {
					c++;	
				}		
				if(temp.left!=null) {
						q1.add(temp.left);
					}
			if(temp.right!=null) {
				q1.add(temp.right);			
			}			
		}
		return c;
	}
	
	//find the no of full nodes in BT
	public int fullNodesInBTree(Node root) {
		int c=0;
		if(root == null)
			return 0;
		
		Queue<Node> q1 = new LinkedList<>();
		q1.add(root);
		while(!q1.isEmpty()) {
			Node temp = q1.peek();
			if(temp.left != null && temp.right != null) {
				c++;
			}
			if(temp.left!=null) {
				q1.add(temp.left);
			}
			if(temp.right!=null) {
				q1.add(temp.right);
			}
		}
		return c;
		
	}
	
	//find the count of the nodes which are having one child
	public int HalfNodesInBTree(Node root) {
		int c=0;
		if(root ==null)
			return 0;
		Queue<Node> q1 = new LinkedList<>();
		q1.add(root);
		while(!q1.isEmpty()){
			Node temp = q1.peek();
			if((temp.left==null && temp.right!=null) || 
					(temp.left!=null && temp.right==null)) {
				c++;
			}
			if(temp.left!=null) {
				q1.add(temp.left);
			}
			if(temp.right!=null) {
				q1.add(temp.right);
			}
		}
		return c;
	}
	
	//check Two binary trees are structural identical same or not
	public boolean identicalOrNot(Node root1,Node root2)
    	{
          if(root1 ==null && root2==null)
           {
            return true;
           }
          if(root1 ==null || root2==null)
       	  {
            return false;
          }
          else if(root1 !=null && root2!=null)
          {
           return (root1.data==root2.data && identicalOrNot(root1.left,root2.left) && identicalOrNot(root1.right,root2.right));
          }
        return false;
    }
	//is tree is symmetric 
	public boolean isSymmetric(Node root) {
	    return isMirror(root, root);
	}

	// For two trees to be mirror images, the following
    // three conditions must be true
    // 1.) Their root node's key must be same
    // 2.) left subtree of left tree and right subtree
    // of right tree have to be mirror images
    // 3.) right subtree of left tree and left subtree
    // of right tree have to be mirror images
	public boolean isMirror(Node t1, Node t2) {
	    if (t1 == null && t2 == null) return true;
	    if (t1 == null || t2 == null) return false;
	    return (t1.data == t2.data)
	        && isMirror(t1.right, t2.left)
	        && isMirror(t1.left, t2.right);
	}
	//validate tree is bst or not
	  public boolean validate(Node root, Integer low, Integer high) {
	        // Empty trees are valid BSTs.
	        if (root == null) {
	            return true;
	        }
	        // The current node's value must be between low and high.
	        if ((low != null && root.data <= low) || (high != null && root.data >= high)) {
	            return false;
	        }
	        // The left and right subtree must also be valid.
	        return validate(root.right, root.data, high) && validate(root.left, low, root.data);
	    }

	    public boolean isValidBST(Node root) {
	        return validate(root, null, null);
	    }
	
	
	
	//deepest node - last node of a BT is deepest node
	public Node deepestNode(Node root) {
		Node temp = null;
		if(root ==null)
			return null;
		
		Queue<Node> q1=new LinkedList<>();
		  q1.add(root);
		while(!q1.isEmpty()) {
			 temp = q1.peek();
			if(temp.left!=null) {
				q1.add(temp.left);
			}
			if(temp.right!=null) {
				q1.add(temp.right);
			}			
		}
		return temp;
	}
	
	
	public static int heightTree(Node root) {
		if(root==null)
			return 0;
		
		return (1+ Math.max(heightTree(root.left), heightTree(root.right)));
	}
	
    //The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes
    /*
    The diameter of a tree T is the largest of the following quantities:

the diameter of T???s left subtree.
the diameter of T???s right subtree.
the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)
     */
	
	//diameter of binary tree
	public int diameterBT(Node root) {
		if(root ==null)
		return 0;
		
		int lh = heightTree(root.left);
		int rh = heightTree(root.right);
			
		int ld = diameterBT(root.left);
		int rd = diameterBT(root.right);
		
		return Math.max(lh+rh+1,Math.max(ld,rd));
	}
	//width of a binary tree
	int getMaxWidth(Node node)  
    { 
        int maxWidth = 0; 
        int width; 
        int h = height(node); 
        int i; 
   
        /* Get width of each level and compare  
           the width with maximum width so far */
        for (i = 1; i <= h; i++)  
        { 
            width = getWidth(node, i); 
            if (width > maxWidth) 
                maxWidth = width; 
        } 
   
        return maxWidth; 
    } 
   
	
/*
    The width of the binary tree is the number of nodes present in any level.
    So, the level which has the maximum number of nodes will be the
    maximum width of the binary tree.
    To solve this problem, traverse the tree level-wise and count the nodes in each level.
     */
	
    /* Get width of a given level */
    int getWidth(Node node, int level)  
    { 
        if (node == null) 
            return 0; 
   
        if (level == 1) 
            return 1; 
        else if (level > 1) 
            return getWidth(node.left, level - 1) 
                    + getWidth(node.right, level - 1); 
        return 0; 
    } 
	//TO-DO min. depth of a BT
    int minimumDepth(Node root) 
    { 
        // Corner case. Should never be hit unless the code is 
        // called on root = NULL 
        if (root == null) 
            return 0; 
  
        // Base case : Leaf Node. This accounts for height = 1. 
        if (root.left == null && root.right == null) 
            return 1; 
  
        // If left subtree is NULL, recur for right subtree 
        if (root.left == null) 
            return minimumDepth(root.right) + 1; 
  
        // If right subtree is NULL, recur for left subtree 
        if (root.right == null) 
            return minimumDepth(root.left) + 1; 
  
        return Math.min(minimumDepth(root.left), 
                        minimumDepth(root.right)) + 1; 
    } 
 // Function to find the maximum 
 // sum of a level in tree
 // using level order traversal
 static int maxLevelSum(Node root) 
 {
      
     // Base case
     if (root == null)
         return 0;
  
     // Initialize result
     int result = root.data;
  
     // Do Level order traversal keeping
     // track of number of nodes at every
     // level.
     Queue<Node> q = new LinkedList<>();
     q.add(root);
     while (!q.isEmpty()) 
     {
          
         // Get the size of queue when the
         // level order traversal for one
         // level finishes
         int count = q.size();
  
         // Iterate for all the nodes
         // in the queue currently
         int sum = 0;
         while (count-- > 0)
         {
          // Dequeue an node from queue
             Node temp = q.poll();
  
             // Add this node's value 
             // to current sum.
             sum = sum + temp.data;
  
             // Enqueue left and right children
             // of dequeued node
             if (temp.left != null)
                 q.add(temp.left);
             if (temp.right != null)
                 q.add(temp.right);
         }
  
         // Update the maximum node
         // count value
         result = Math.max(sum, result);
     }
     return result;
 }
 
 static int max_level = 0;
	
 //The left view contains all nodes that are first nodes in their levels. 
//	 A simple solution is to do level order traversal and print the first node in every level.
	
	
 // recursive function to print left view
 void leftViewUtil(Node node, int level)
 {
     // Base Case
     if (node == null)
         return;

     // If this is the first node of its level
     if (max_level < level) {
         System.out.print(" " + node.data);
         max_level = level;
     }

     // Recur for left and right subtrees
     leftViewUtil(node.left, level + 1);
     leftViewUtil(node.right, level + 1);
 }

 // A wrapper over leftViewUtil()
 void leftView()
 {
     leftViewUtil(root, 1);
 }
//class to access maximum level by reference 
class Max_level { 

  int max_level; 
}
 
 Max_level max = new Max_level(); 
 
 // Recursive function to print right view of a binary tree. 
 void rightViewUtil(Node node, int level, Max_level max_level) { 

     // Base Case 
     if (node == null)  
         return; 

     // If this is the last Node of its level 
     if (max_level.max_level < level) { 
         System.out.print(node.data + " "); 
         max_level.max_level = level; 
     } 

     // Recur for right subtree first, then left subtree 
     rightViewUtil(node.right, level + 1, max_level); 
     rightViewUtil(node.left, level + 1, max_level); 
 } 

 void rightView() 
 { 
     rightView(root); 
 } 

 // A wrapper over rightViewUtil() 
 void rightView(Node node) { 

     rightViewUtil(node, 1, max); 
 } 
//Pending questions
 //Print Bottom View of Binary Tree
 //Print a Binary Tree in Vertical Order
 //Connect Nodes at Same Level
 
	void diagonalPrint(Node root)  
	{  
	    // base case  
	    if (root == null)  
	        return;  
	    
	    // inbuilt queue of Treenode  
	    Queue<Node> q= new LinkedList<Node>();  
	    
	    // add root  
	    q.add(root);  
	    
	    // add delimiter  
	    q.add(null);  
	    
	    while (q.size()>0) {  
	        Node temp = q.peek();  
	        q.remove();  
	    
	        // if current is delimiter then insert another  
	        // for next diagonal and cout nextline  
	        if (temp == null) {  
	    
	            // if queue is empty return  
	            if (q.size()==0)  
	                return;  
	    
	            // output nextline  
	            System.out.println(); 
	    
	            // add delimiter again  
	            q.add(null);  
	        }  
	        else {  
	            while (temp!=null) {  
	                System.out.print( temp.data + " ");  
	    
	                // if left child is present   
	                // add into queue  
	                if (temp.left!=null)  
	                    q.add(temp.left);  
	    
	                // current equals to right child  
	                temp = temp.right;  
	            }  
	        }  
	    }  
	}
	void printSpiralUsingTwoStacks(Node node) 
    { 
        if (node == null) 
            return; // NULL check 
  
        // Create two stacks to store alternate levels 
        // For levels to be printed from right to left 
        Stack<Node> s1 = new Stack<Node>();  
        // For levels to be printed from left to right 
        Stack<Node> s2 = new Stack<Node>();  
  
        // Push first level to first stack 's1' 
        s1.push(node); 
  
        // Keep printing while any of the stacks has some nodes 
        while (!s1.empty() || !s2.empty()) { 
            // Print nodes of current level from s1 and push nodes of 
            // next level to s2 
            while (!s1.empty()) { 
                Node temp = s1.peek(); 
                s1.pop(); 
                System.out.print(temp.data + " "); 
  
                // Note that is right is pushed before left 
                if (temp.right != null) 
                    s2.push(temp.right); 
  
                if (temp.left != null) 
                    s2.push(temp.left); 
            } 
  
            // Print nodes of current level from s2 and push nodes of 
            // next level to s1 
            while (!s2.empty()) { 
                Node temp = s2.peek(); 
                s2.pop(); 
                System.out.print(temp.data + " "); 
  
                // Note that is left is pushed before right 
                if (temp.left != null) 
                    s1.push(temp.left); 
                if (temp.right != null) 
                    s1.push(temp.right); 
            } 
        } 
    } 
	void reverseLevelOrder(Node node)  
    { 
        int h = height(node); 
        int i; 
        for (i = h; i >= 1; i--)  
        //THE ONLY LINE DIFFERENT FROM NORMAL LEVEL ORDER 
        { 
            printGivenLevel(node, i); 
        } 
    } 
	

    // Returns maximum path sum in tree with given root 
    int findMaxSum(Node node) { 
  
        // Initialize result 
        // int res2 = Integer.MIN_VALUE; 
        Res res = new Res(); 
        res.val = Integer.MIN_VALUE; 
  
        // Compute and return result 
        findMaxUtil(node, res); 
        return res.val; 
    } 
	
 // This function returns overall maximum path sum in 'res' 
    // And returns max path sum going through root. 
    int findMaxUtil(Node node, Res res) 
    { 
  
        // Base Case 
        if (node == null) 
            return 0; 
  
        // l and r store maximum path sum going through left and 
        // right child of root respectively 
        int l = findMaxUtil(node.left, res); 
        int r = findMaxUtil(node.right, res); 
  
        // Max path for parent call of root. This path must 
        // include at-most one child of root 
        int max_single = Math.max(Math.max(l, r) + node.data, 
                                  node.data); 
  
  
        // Max Top represents the sum when the Node under 
        // consideration is the root of the maxsum path and no 
        // ancestors of root are there in max sum path 
        int max_top = Math.max(max_single, l + r + node.data); 
  
        // Store the Maximum Result. 
        res.val = Math.max(res.val, max_top); 
  
        return max_single; 
    } 
    
    /* Function to find LCA of n1 and n2. The function assumes that both 
    n1 and n2 are present in BST */
 Node lca(Node node, int n1, int n2)  
 { 
     if (node == null) 
         return null; 

     // If both n1 and n2 are smaller than root, then LCA lies in left 
     if (node.data > n1 && node.data > n2) 
         return lca(node.left, n1, n2); 

     // If both n1 and n2 are greater than root, then LCA lies in right 
     if (node.data < n1 && node.data < n2)  
         return lca(node.right, n1, n2); 

     return node; 
 }
    
 
	
 
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
  
        System.out.println("Preorder traversal of binary tree is "); 
        tree.preOrderTraversal(tree.root);
  
        System.out.println("\nInorder traversal of binary tree is "); 
        tree.inOrderTraversal(tree.root);
  
        System.out.println("\nPostorder traversal of binary tree is "); 
        tree.postOrderTraversal(tree.root);
    } 

	
}
