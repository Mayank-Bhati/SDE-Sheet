package Arrays;

import java.util.Arrays;
import java.util.Collections;

public class mergeSortedArrays {
    public static void main(String[] args) {
        long[] arr1 = {10, 12};
        long[] arr2 = {5, 18, 20};
        merge(arr1, arr2, 2, 3);
        for (long a : arr1)
            System.out.print(a + " ");
        for (long b : arr2)
            System.out.print(b + " ");
    }

    static void merge(long[] arr1, long[] arr2, int n, int m){
        int gap = (n + m + 1)/2;
        while(gap >= 1) {
            int l = 0, r = gap;
            while (r < n + m) {
                if (r < n && l < n) {
                    if (arr1[l] > arr1[r])
                        swap(l, r, arr1);

                } else if (l >= n) {
                    if (arr2[l - n] > arr2[r - n])
                        swap(l, r, arr2);
                } else {
                    if (arr1[l] > arr2[r - n]) {
                        long t = arr1[l];
                        arr1[l] = arr2[r - n];
                        arr2[r - n] = t;
                    }
                }
                l++;
                r++;
            }
            if(gap == 1)
                return;
            gap = (gap+1)/2;
        }
    }
//    public static void merge(long arr1[], long arr2[], int n, int m) {
//        int gap = (n + m + 1) / 2;
//        while (gap >= 1) {
//            int i = 0, j = i + gap;
//            while (j < n + m) {
//                if (i < n && j < n) {
//                    if (arr1[i] > arr1[j])
//                        swap(i, j, arr1);
//                } else if (i >= n && j >= n) {
//                    if (arr2[i - n] > arr2[j - n])
//                        swap(i - n, j - n, arr2);
//                } else if (arr1[i] > arr2[j - n]) {
//                    long c = arr1[i];
//                    arr1[i] = arr2[j - n];
//                    arr2[j - n] = c;
//                }
//                i++;
//                j++;
//            }
//            int old = gap;
//            gap = (gap + 1) / 2;
//            if (gap == old)
//                return;
//        }
//    }

    //    public static void merge(long arr1[], long arr2[], int n, int m) {
//        for(int i = 0; i < n; i++){
//            if(arr1[i] > arr2[0]){
//                long c = arr1[i];
//                arr1[i] = arr2[0];
//                arr2[0] = c;
//                for(int j = 1; j < m; j++){
//                    if(arr2[j] < arr2[j-1])
//                        swap(j-1,j,arr2);
//                    else
//                        break;
//                }
//            }
//        }
//    }
//
    private static void swap(int i, int j, long[] arr2) {
        long c = arr2[i];
        arr2[i] = arr2[j];
        arr2[j] = c;
    }


//    public static void merge(long arr1[], long arr2[], int n, int m) {
//        long[] out = new long[n + m];
//        int i = 0, j = 0, k = 0;
//        while (i < n && j < m && k < n + m) {
//            if (arr1[i] <= arr2[j]) {
//                out[k] = arr1[i];
//                i++;
//                k++;
//            } else {
//                out[k] = arr2[j];
//                k++;
//                j++;
//            }
//        }
//        while (i < n && k < n + m) {
//            out[k] = arr1[i];
//            i++;
//            k++;
//        }
//        while (j < m && k < n + m) {
//            out[k] = arr2[j];
//            j++;
//            k++;
//        }
//        k = 0;
//        for (int a = 0; a < n; a++) {
//            arr1[a] = out[k];
//            k++;
//        }
//        for (int b = 0; b < m; b++) {
//            arr2[b] = out[k];
//            k++;
//        }
//    }
}
