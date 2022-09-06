package array.twopointers;

public class TrappingWater {

    static int maxWater(int[] height){
        int left = 0;
        int right = height.length-1;

        int l_max = 0;
        int r_max = 0;

        int result = 0;

        while(left <=right){

            if(r_max<=l_max){
                result = result + Math.max(0,r_max - height[right]);
                r_max = Math.max(r_max,height[right]);
                right = right - 1;
            }
            else {
                result = result + Math.max(0,l_max-height[left]);
                l_max = Math.max(l_max,height[left]);
                left = left+1;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        TrappingWater.maxWater(arr);
    }
}
