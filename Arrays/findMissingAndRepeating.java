package Arrays;

import java.util.ArrayList;

public class findMissingAndRepeating {
    public static void main(String[] args) {
        int[] arr = {3, 1, 3};
        int[] res = findTwoElement(arr, 3);
        System.out.println(res[0] + " " + res[1]);
    }

    static int[] findTwoElement(int[] arr, int n){
        int[] res = new int[2];
        int xor = 0;
        for(int i = 1; i <= n; i++)
            xor ^= i;
        for(int a : arr)
            xor ^= a;
        int k = setBit(xor);
        int set = 0, unset = 0;
        for(int i = 1; i <= n; i++) {
            if(compareBit(i,k) == 0)
                unset ^= i;
            else
                set ^= i;
        }
        for(int a : arr){
            if(compareBit(a,k) == 0)
                unset ^= a;
            else
                set ^= a;
        }
        boolean setRep = false;
        for(int a : arr){
            if(a == set) {
                res[0] = set;
                setRep = true;
                break;
            }
            else if(a == unset){
                res[0] = unset;
                break;
            }
        }
        res[1] = (setRep)?unset:set;
        return res;
    }

    static int compareBit(int x, int i){
        return (x & (1 << i)) ;
    }
    static int setBit(int x){
        for(int i = 0; i < 32; i++){
            if((x & (1 << i)) != 0)
                return i;
        }
        return -1;
    }
//    static int[] findTwoElement(int arr[], int n) {
//        boolean X = false;
//        int[] out = new int[2];
//        float s = (n * (n + 1)) / 2;
//        for (int i = 0; i < n; i++)
//            s -= arr[i];
//        System.out.println(s);
//        float sq = (n * (n + 1) * (2 * n + 1)) / 6;
//        for (int i = 0; i < n; i++)
//            sq = sq - (arr[i] * arr[i]);
//        System.out.println(sq);
//        int x = (int)((sq / (2 * s)) + (s / 2));
//        System.out.println(x);
//        int y = (int)((sq / (2 * s)) - (s / 2));
//        System.out.println(y);
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == y) {
//                break;
//            } else if (arr[i] == x) {
//                X = true;
//                break;
//            }
//        }
//        if (X) {
//            out[0] = x;
//            out[1] = y;
//        } else {
//            out[0] = y;
//            out[1] = x;
//        }
//        return out;
//    }






//    int[] findTwoElement(int arr[], int n) {
//        int mis = -1, rep = -1;
//        boolean[] vis = new boolean[n];
//        for(int i = 0; i < n; i++){
//            if(vis[arr[i]-1] == false)
//                vis[arr[i]-1] = true;
//            else
//                rep = arr[i];
//        }
//        for(int i = 0; i < n; i++){
//            if(vis[i] == false)
//                mis = i+1;
//        }
//        int[] out = new int[2];
//        out[0] = rep;
//        out[1] = mis;
//        return out;
//    }
}
