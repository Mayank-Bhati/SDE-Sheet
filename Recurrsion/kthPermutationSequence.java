package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class kthPermutationSequence {
    /*
    The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.



Example 1:

Input: n = 3, k = 3
Output: "213"
     */
    public static void main(String[] args) {
        System.out.println(getPermutation(3,3));
    }
    public static String getPermutation(int n, int k) {
        List<Integer> l = new ArrayList<>();
        String out = "";
        k -= 1;
        int f = 1;
        for(int i = 1; i <= n; i++){
            f *= i;
            l.add(i);
        }
        while(l.size() > 0){
            f /= l.size();
            int ind = k/f;
            out += l.get(ind);
            k %= f;
            l.remove(ind);
        }
        return out;
    }
}
