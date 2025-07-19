package stackandqueue;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {


    public int[] dailyTemperaturesII(int[] nums) {
        int n = nums.length;
        int[] ans  = new int[n];
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<n;++i){
            while(!stack.isEmpty() && nums[i]>stack.peek()[1]){
                int[] curr= stack.pop();
                ans[curr[0]]= i-curr[0];

            }
            stack.push(new int[]{i,nums[i]});
        }
        return ans;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int currDay = 0; currDay < temperatures.length; currDay++) {
            while (
                    !stack.isEmpty() &&
                            temperatures[currDay] > temperatures[stack.peek()]
            ) {
                int prevDay = stack.pop();
                ans[prevDay] = currDay - prevDay;
            }
            stack.add(currDay);

        }
        return ans;
    }




    public static void main(String[] args) {
        int[] temp = {30,38,30,36,35,40,28};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] result = dailyTemperatures.dailyTemperaturesII(temp);
        Arrays.stream(result).forEach(System.out::println);
    }
}
