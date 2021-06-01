package array;
//Let the array be arr[] = [1, 2, 3, 4, 5, 6, 7], d =2 and n = 7
//A = [1, 2] and B = [3, 4, 5, 6, 7]
//
//Reverse A, we get ArB = [2, 1, 3, 4, 5, 6, 7]
//Reverse B, we get ArBr = [2, 1, 7, 6, 5, 4, 3]
//Reverse all, we get (ArBr)r = [3, 4, 5, 6, 7, 1, 2]
//
//rotate(arr[], d, n)
//reverse(arr[], 1, d) ;
//reverse(arr[], d + 1, n);
//reverse(arr[], 1, n);
public class ReversalAlgoRotateArray {

	static void leftRotate(int arr[], int d) 
    { 
  
        if (d == 0) 
            return; 
        int n = arr.length; 
        rvereseArray(arr, 0, d - 1); 
        rvereseArray(arr, d, n - 1); 
        rvereseArray(arr, 0, n - 1); 
    } 
  
    /*Function to reverse arr[] from index start to end*/
    static void rvereseArray(int arr[], int start, int end) 
    { 
        int temp; 
        while (start < end) { 
            temp = arr[start]; 
            arr[start] = arr[end]; 
            arr[end] = temp; 
            start++; 
            end--; 
        } 
    } 
  
    /*UTILITY FUNCTIONS*/
    /* function to print an array */
    static void printArray(int arr[]) 
    { 
        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " "); 
    } 
  
    /* Driver program to test above functions */
    public static void main(String[] args) 
    { 
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 }; 
        int n = arr.length; 
        int d = 2; 
  
        // in case the rotating factor is 
        // greater than array length 
        d = d % n; 
        leftRotate(arr, d); // Rotate array by d 
        printArray(arr); 
    } 

}
