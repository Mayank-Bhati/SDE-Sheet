package Recurrsion;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSums {
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        System.out.println(subsetSums(l, 2));
    }

    //    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
//        ArrayList<Integer> out = new ArrayList<>();
//        out.add(0);
//        helper(arr,0,out, N);
//        return out;
//    }
//    static void helper(ArrayList<Integer> a, int i, ArrayList<Integer> l, int n){
//        if(i >= n)
//            return ;
//        int x = a.get(i);
//        int size = l.size();
//        for(int k = 0; k < size; k++) {
//            l.add(x + l.get(k));
//        }
//        helper(a,i+1,l,n);
//    }
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {

        return helper(arr, N - 1, N);
    }

    static ArrayList<Integer> helper(ArrayList<Integer> a, int i, int n) {
        if (i < 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(0);
            return temp;
        }
        ArrayList<Integer> l = helper(a, i - 1, n);
        int k = a.get(i);
        int s = l.size();
        for (int j = 0; j < s; j++) {
            l.add(l.get(j) + k);
        }
        return l;
    }
}
