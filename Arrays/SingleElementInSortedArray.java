package Arrays;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,5,5};
        System.out.println(singleNonDuplicateEfficient(nums));
        System.out.println(singleNonDuplicateBrute(nums));
    }

    public static int singleNonDuplicateBrute(int[] nums) {
        int x = 0;
        for(int i = 0; i < nums.length ;i++)
            x ^= nums[i];
        return x;
    }

        public static int singleNonDuplicateEfficient(int[] nums) {
        int l = 0, r = nums.length-2;
        while(l <= r){
            int m = (l+r)>>1;
            if(nums[m] == nums[m^1])
                l = m+1;
            else
                r = m-1;
        }
        return nums[l];
    }
}
