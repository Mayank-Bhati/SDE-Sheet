package Arrays;

import java.util.*;

public class MajorityElement_n_3 {
    /*\
    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 2, 3, 2, 3};
//        System.out.println(majorityElement(nums));
//        System.out.println(majorityElementBySorting(nums));
        System.out.println(majorityElementEfficient(nums));
    }

    /*
    number of majority elements can be k-1 at max for (n/k) condition.
     */

    public static List<Integer> majorityElementEfficient(int[] nums) {
        List<Integer> l = new ArrayList<>();
        int m1 = Integer.MIN_VALUE, m2 = Integer.MAX_VALUE, c1 = 0, c2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == m1)
                c1++;
            else if(nums[i] == m2)
                c2++;
            else if(c1 == 0) {
                m1 = nums[i];
                c1++;
            }
            else if(c2 == 0) {
                m2 = nums[i];
                c2++;
            }
            else{
                c1--;
                c2--;
            }
        }
        int f1 = 0, f2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == m1)
                f1++;
            else if(nums[i] == m2)
                f2++;
        }
        if(f1 > nums.length/3)
            l.add(m1);
        if(f2 > nums.length/3)
            l.add(m2);
        return l;
    }

        public static List<Integer> majorityElementBySorting(int[] nums) {
        List<Integer> l = new ArrayList<>();
        Arrays.sort(nums);
        int c = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                c++;
                if (c > nums.length / 3 && (!l.contains(nums[i])))
                    l.add(nums[i]);
            } else
                c = 1;
        }
        return l;
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> l = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
            if (m.get(nums[i]) > nums.length / 3 && (!l.contains(nums[i])))
                l.add(nums[i]);
        }
        return l;
    }
}
