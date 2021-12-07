package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class mergeIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] out = merge(arr);
        for(int[] ar : out){
            for(int a : ar){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> l = new ArrayList<>();
        int s = intervals[0][0], e = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] > e){
                int[] arr = new int[2];
                arr[0] = s;
                arr[1] = e;
                l.add(arr);
                s = intervals[i][0];
                e = intervals[i][1];
            }
            else{
                s = Math.min(s,intervals[i][0]);
                e = Math.max(e,intervals[i][1]);
            }
        }
        int[] arr = new int[2];
        arr[0] = s;
        arr[1] = e;
        l.add(arr);
        int[][] out = new int[l.size()][];
        int i = 0;
        for(int[] a : l){
            out[i] = a;
            i++;
        }
        return out;
    }







//    public static int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
//        ArrayList<int[]> out = new ArrayList<>();
//        int s = intervals[0][0], e = intervals[0][1];
//        for(int i = 0; i < intervals.length; i++){
//            if(intervals[i][0] <= e)
//                e = Math.max(e,intervals[i][1]);
//            else{
//                int[] arr = new int[2];
//                arr[0] = s;
//                arr[1] = e;
//                out.add(arr);
//                s = intervals[i][0];
//                e = intervals[i][1];
//            }
//        }
//        int[] arr = new int[2];
//        arr[0] = s;
//        arr[1] = e;
//        out.add(arr);
//        int[][] res = new int[out.size()][2];
//        for(int i = 0; i < res.length; i++){
//            for(int j = 0; j < 2; j++){
//                res[i][j] = out.get(i)[j];
//            }
//        }
//        return res;
//    }

}
