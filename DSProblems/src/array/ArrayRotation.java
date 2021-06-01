package array;
//Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7

//output    arr[] = [3, 4, 5, 6, 7, 1, 2]

public class ArrayRotation {

	void rotateByOne(int a[]) {
		int temp = a[0];
		int i;
		for(i=0;i<a.length-1;i++) {
			a[i]= a[i+1];
		}
		a[i]=temp;
	}
	
	void rotationByDiff(int a[],int d) {
		for(int i=0;i<d;i++) {
			rotateByOne(a);
		}
	}
	public static void main(String[] args) {
ArrayRotation ar =  new ArrayRotation();
	}

}
