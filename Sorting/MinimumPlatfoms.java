package Sorting;

import java.util.*;

public class MinimumPlatfoms {
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr,dep,arr.length));
    }
    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int a = 1, d = 0, max = 1, curr = 1;
        while(a < arr.length){
            if(arr[a] > dep[d]){
                a++;
                d++;
            }
            else{
                curr++;
                a++;
            }
            if(curr > max)
                max = curr;
        }
        return max;
    }

//    static class MyComparator implements Comparator<Train>{
//
//        @Override
//        public int compare(Train o1, Train o2) {
//            if(o1.arrival != o2.arrival)
//                return o1.arrival - o2.arrival;
//            else
//                return o1.pos - o2.pos;
//        }
//    }
//
//    static class Train{
//        int pos, arrival, departure;
//        Train(int p, int arr, int dep){
//            this.arrival = arr;
//            this.pos = p;
//            this.departure = dep;
//        }
//    }
}
