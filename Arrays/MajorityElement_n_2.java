package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement_n_2 {
    public static void main(String[] args) {
        int[] nums = {2,1,2,1,2,2,1,2};
        System.out.println(majorityElementEfficient(nums));
        System.out.println(majorityElementUsingMap(nums));
        System.out.println(majorityElementUsingSorting(nums));
    }

    public static int majorityElementEfficient(int[] nums) {
        int count = 0, ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(count == 0)
                ans = nums[i];
            if(nums[i] == ans)
                count++;
            else
                count--;
        }
        return ans;
    }

        public static int majorityElementUsingSorting(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

        public static int majorityElementUsingMap(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
            if(m.get(nums[i]) > nums.length/2)
                return nums[i];
        }
        return -1;
    }
}
