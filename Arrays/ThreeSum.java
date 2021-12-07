package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> out = threeSum(nums);
        System.out.println(out);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++){
            int l = i+1, r = nums.length-1;
            while(l < r){
                int sum = nums[i] + nums[l]+ nums[r];
                if(sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    if(!out.contains(list))
                        out.add(list);
                    l++;
                    r--;
                }
                else if(sum < 0)
                    l++;
                else
                    r--;
            }
        }
        return out;
    }
}
