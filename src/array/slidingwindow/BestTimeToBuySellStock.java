package array.slidingwindow;

public class BestTimeToBuySellStock {
//Two pointer solution
//neet code solution
//*******This solution *******
    //L at 0th index , R at 1st index , calc maxProfit
    public int maxProfitSol1(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
                right++;
            } else {
                //when L > R then this flow
                left = right;
                right++;
            }
        }
        return maxProfit;
    }

    private int maxProfit(int[] prices) {
        int minP = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i <prices.length ; i++) {
            if(prices[i] < minP) {
                minP = prices[i];
            }
            else if(prices[i] - minP > maxProfit) {
                maxProfit = prices[i] - minP;
            }
        }
        return maxProfit;
    }

    private int maxProfitSol(int[] prices){
        int min = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;

        for (int val:
             prices) {
            min = Math.min(min,val);
            ans = Math.max(ans,val - min);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a= {7,1,5,3,6,4};
        BestTimeToBuySellStock bestTimeToBuySellStock = new BestTimeToBuySellStock();
        System.out.println(bestTimeToBuySellStock.maxProfit(a));
    }


}
