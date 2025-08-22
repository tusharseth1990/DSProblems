package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumCost {

    static void getMinimumCostAfterInsertion(ArrayList<Integer> ls)
    {
        int max=Integer.MIN_VALUE;
        int currMax=0;
        int index=0;
        for(int i=0;i<ls.size()-1;i++)
        {
            currMax=Math.abs(ls.get(i)-ls.get(i+1));
            max=Math.max(currMax,max);
            index=i;
        }
        ls.add(ls.size(),0);
        int average=(ls.get(index)+ls.get(index-1))/2;
        System.out.println("element in index is "+ls.get(index+1));
        for(int i=ls.size()-1;i>=index+1;i--)
        {
            ls.set(i,ls.get(i-1));
        }
        ls.set(index,average);
        System.out.println(ls.toString());
        int cost=0;
        for(int i=0;i<ls.size()-1;i++)
        {
            int temp=Math.abs(ls.get(i)-ls.get(i+1));
            cost =cost+ temp*temp;
        }
        System.out.println("cost is "+ cost);
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls= new ArrayList<>(Arrays.asList(4,4,1,7,4));
        getMinimumCostAfterInsertion(ls);
    }
}
