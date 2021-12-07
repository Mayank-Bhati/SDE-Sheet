package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
//        int[] arr = twoSumBruteForce(nums, 9);
//        int[] arr = twoSumUsingMap(nums,9);
        int[] arr = twoSumUsingTwoPointer(nums,9);
        System.out.println(arr[0] + " , " + arr[1]);
    }

    public static int[] twoSumUsingTwoPointer(int[] nums, int t) {
        Arrays.sort(nums);
        int l = 0, r = nums.length-1;
        int[] out = {-1,-1};
        while(l < r){
            int sum = nums[l]+nums[r];
            if(sum == t){
                out[0] = l;
                out[1] = r;
                return out;
            }
            else if(sum < t)
                l++;
            else
                r--;
        }
        return out;
    }

        public static int[] twoSumBruteForce(int[] nums, int t) {
        int[] out = {-1, -1};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == t) {
                    out[0] = i;
                    out[1] = j;
                    return out;
                }
            }
        }
        return out;
    }

    public static int[] twoSumUsingMap(int[] nums, int t) {
        int[] out = {-1, -1};
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(t - nums[i])) {
                out[0] = m.get(t - nums[i]);
                out[1] = i;
                return out;
            } else
                m.put(nums[i], i);
        }
        return out;
    }

}
