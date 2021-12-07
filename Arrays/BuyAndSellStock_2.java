package Arrays;

public class BuyAndSellStock_2 {
    /*
    You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock
 at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.


     */
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
//        System.out.println(maxProfitBrute(prices));
//        System.out.println(maxProfitEfficient1(prices));
        System.out.println(maxProfitEfficient2(prices));
    }

    public static int maxProfitBrute(int[] nums) {
        return util(nums, 0);
    }

    static int util(int[] nums, int start) {
        if (start >= nums.length)
            return 0;
        int max = 0;
        for (int i = start; i < nums.length; i++) {
            int maxp = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    int p = util(nums, j + 1) + (nums[j] - nums[i]);
                    if (p > maxp)
                        maxp = p;
                }
            }
            if (maxp > max)
                max = maxp;
        }
        return max;
    }

    public static int maxProfitEfficient1(int[] nums) {
        int n = nums.length, p = 0, i = 0, valley = 0, peak = 0;
        while (i < n - 1) {
            while (i < n - 1 && nums[i] >= nums[i + 1])
                i++;
            valley = i;
            while (i < n - 1 && nums[i] <= nums[i + 1])
                i++;
            peak = i;
            p += nums[peak] - nums[valley];
        }
        return p;
    }
    /*
      7
                             6
                 5
                                    4
                       3

          1

     */

    public static int maxProfitEfficient2(int[] nums) {
        int p = 0;
        for(int i = 1; i < nums.length; i++){
            int diff = nums[i] - nums[i-1];
            if(diff > 0)
                p += diff;
        }
        return p;
    }

}
