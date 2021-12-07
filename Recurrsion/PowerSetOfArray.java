package Recurrsion;

import java.util.*;

public class PowerSetOfArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(subsetsWithDup(nums));
    }

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        return helper(nums,nums.length-1);
    }

    private static List<List<Integer>> helper(int[] nums, int i) {
        if(i == -1){
            List<List<Integer>> out = new ArrayList<>();
            out.add(new ArrayList<>());
            return out;
        }
        List<List<Integer>> out = helper(nums,i-1);
        int s = out.size();
        for(int k = 0; k < s; k++){
            List<Integer> l = new ArrayList<>(out.get(k));
            l.add(nums[i]);
            out.add(l);
        }
        return out;
    }

//    static public List<List<Integer>> subsetsWithDup(int[] nums) {
//        Set<List<Integer>> out = new HashSet<>();
//        helper(nums, 0, out, new ArrayList<Integer>());
//        List<List<Integer>> res = new ArrayList<>();
//        for(List<Integer> l : out)
//            res.add(l);
//        return res;
//    }
//
//    static void helper(int[] nums, int i, Set<List<Integer>> out, List<Integer> l) {
//        if (i == nums.length) {
//            Collections.sort(l);
//                out.add(l);
//            return;
//        }
//        helper(nums, i + 1, out, l);
//        ArrayList<Integer> temp  =new ArrayList<>(l);
//        temp.add(nums[i]);
//        helper(nums, i + 1, out, temp);
//    }

}
