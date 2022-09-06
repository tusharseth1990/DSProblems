package array.slidingwindow;

public class BestTimeToBuySellStock {

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
