package Arrays;

import java.util.Arrays;
import java.util.Collections;

public class nextPermutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        nextPermutation(arr);
        for(int a : arr)
            System.out.print(a+" ");
    }
    public static void nextPermutation(int[] nums) {
        int n = nums.length, ind1 = -1, ind2 = n-1;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]) {
                ind1 = i;
                break;
            }
        }
        if(ind1 < 0){
            reverse(nums,0);
            return;
        }
        for(int i = n-1; i >= 0; i--){
            if(nums[i] > ind1) {
                ind2 = i;
                break;
            }
        }
        swap(nums,ind1,ind2);
        reverse(nums,ind1+1);
    }

    private static void reverse(int[] nums, int i) {
        int l = i, r = nums.length-1;
        while(l < r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }


    //    public static void Arrays.nextPermutation(int[] nums) {
//        int n = nums.length;
//        int i = n-2;
//        for(i = n-2; i >= 0; i--) {
//            if (nums[i] < nums[i + 1])
//                break;
//        }
//        if(i > 0) {
//            for (int j = n - 1; j > i; j--) {
//                if (nums[j] > nums[i]) {
//                    swap(nums, i, j);
//                }
//            }
//        }
//        int l = i+1, r = n-1;
//        while(l < r){
//            swap(nums,l,r);
//            l++;
//            r--;
//        }
//    }
    static void swap(int[] arr, int i, int j){
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
