package Recurrsion;

import java.util.*;

public class AllPermutationsOfArray {
    public static void main(String[] args) {
//        System.out.println(permute(new int[] {1,2,3}));
        System.out.println(permuteString("ABC"));
    }

    public static List<String> permuteString(String s){
        List<String> out = new ArrayList<>();
        helperString(s,"",out);
        return out;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
//        List<Integer> l = new ArrayList<>();
//        Map<Integer,Boolean> m = new HashMap<>();
        helperEff(nums,0,out);
        return out;
    }

    private static void helperString(String s, String ans,List<String> l){
        if(s.length() == 0){
            l.add(ans);
            return;
        }
        for(int i = 0; i < s.length(); i++){
            helperString(s.substring(0,i)+s.substring(i+1),ans+s.charAt(i),l);
        }
    }

    private static void helper(int[] nums, Map<Integer, Boolean> m, List<Integer> l, List<List<Integer>> out) {
        if(l.size() == nums.length){
            out.add(new ArrayList<>(l));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!m.getOrDefault(nums[i],false)){
                l.add(nums[i]);
                m.put(nums[i],true);
                helper(nums,m,l,out);
                l.remove(l.size()-1);
                m.put(nums[i],false);
            }
        }
    }
    private static void helperEff(int[] nums, int ind, List<List<Integer>> out) {
        if(ind == nums.length){
            List<Integer> l = new ArrayList<>();
            for(int i : nums)
                l.add(i);
            out.add(l);
            return;
        }
        for(int i = ind; i < nums.length; i++){
            swap(nums,i,ind);
            helperEff(nums,ind+1,out);
            swap(nums,i,ind);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }
}
