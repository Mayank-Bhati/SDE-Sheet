package DP;

import java.util.*;

public class CombinationSum2 {
    /*
    Given a collection of candidate numbers (candidates) and a target number (target),
     find all unique combinations in candidates where the candidate numbers sum to target.

    Each number in candidates may only be used once in the combination.

    Note: The solution set must not contain duplicate combinations.
     */
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(combinationSum2(nums,30));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Arrays.sort(candidates);
        helperEff(candidates,0,target,res,l);
        List<List<Integer>> out = new ArrayList<>();
        for(List<Integer> list : res){
            out.add(list);
        }
        return out;
    }
    static void helper(int[] a, int t, int i, Set<List<Integer>> out, List<Integer> curr){
        if(t == 0){
            if(!out.contains(curr))
                out.add(curr);
            return;
        }
        if(i == -1)
            return;
        List<Integer> l = new ArrayList<>(curr);
        if(a[i] <= t ){
            l.add(a[i]);
            helper(a,t-a[i],i-1,out,l);
        }
        helper(a,t,i-1,out,curr);
    }

    static void helperEff(int[] a, int ind, int t, List<List<Integer>> out, List<Integer> curr){
        if(t == 0){
            out.add(new ArrayList<>(curr));
            return;
        }
        if(ind == a.length)
            return;
        for(int i = ind; i< a.length; i++){
            if(i > ind && a[i] == a[i-1])
                continue;
            else if(a[i] > t)
                break;
            else{
                curr.add(a[i]);
                helperEff(a,i+1,t-a[i],out,curr);
                curr.remove(curr.size()-1);
            }
        }
    }

}
