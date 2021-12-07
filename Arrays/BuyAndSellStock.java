package Arrays;

public class BuyAndSellStock {
    /*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different
 day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0
     */

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfitEfficient(prices));
    }
    public static int maxProfit(int[] prices) { // Brute Force Solution
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
                int p = prices[j] - prices[i];
                if(p > max)
                    max = p;
            }
        }
        return max;
    }

    public static int maxProfitEfficient(int[] nums){
        int min = Integer.MAX_VALUE, maxp = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < min)
                min = nums[i];
            else{
                int p = nums[i]- min;
                if(p > maxp)
                    maxp = p;
            }
        }
        return maxp;
    }
}
