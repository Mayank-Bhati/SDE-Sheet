package Arrays;

public class RemoveDuplicatesFromSortedArray {
    // here not only, we have to return new length but we need to change array also
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
    }
    public static int removeDuplicates(int[] nums) {
        int k = 0;
        if(nums.length == 0)
            return 0;
        else
            nums[k] = nums[0];
        k++;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
