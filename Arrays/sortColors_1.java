package Arrays;

public class sortColors_1 {
    public static void main(String[] args) {
int[] nums = {2,0,2,1,1,0};
sortColors(nums);
for(int a: nums)
    System.out.print(a+" ");
    }
    // Dutch National Flag Algorithm
    public static void sortColors(int[] nums) {
        int l = 0, m = 0, r = nums.length-1;
        while(m <= r){
            if(nums[m] == 0){
                swap(m,l,nums);
                l++;
                m++;
            }
            else if(nums[m] == 1)
                m++;
            else{
                swap(m,r,nums);
                r--;
            }
        }
    }
    static void swap(int i, int j, int[] nums){
        int c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }

}
