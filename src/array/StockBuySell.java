package array;

/*
The cost of a stock on each day is given in an array, find the max profit that you can make
by buying and selling in those days. For example, if the given array
is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying on day 0,
selling on day 3. Again buy on day 4 and sell on day 6.
If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 */

public class StockBuySell {

    /*
    Approach : In this approach, we just need to find the next greater element and subtract it from the current element
    so that the difference keeps increasing until we reach a minimum.
    If the sequence is a decreasing sequence so the maximum profit possible is 0.
     */
    static int maxProfit(int arr[],int n)
    {
        // maxProfit adds up the difference between
        // adjacent elements if they are in increasing order
        int maxProfit=0;
        for(int i=1;i<n;i++)
        {
            if(arr[i]>arr[i-1])
            {
                maxProfit = maxProfit + arr[i]-arr[i-1];
            }
        }
        return maxProfit;
    }

    static int maxProfitForOneDay(int arr[])
    {
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<minPrice)
            {
                minPrice=arr[i];
            }
            else if(arr[i]-minPrice>maxProfit){
                maxProfit=arr[i]-minPrice;
        }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int price[] = { 100, 180, 260, 310, 40, 535, 695 };
        int n= price.length;
        System.out.println(maxProfit(price,n));
    }
}
