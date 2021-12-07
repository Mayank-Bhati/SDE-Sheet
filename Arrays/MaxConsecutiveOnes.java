package Arrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int l = 0, max = 0;
        boolean prevIsOne = false;
        for(int i = 0; i < nums.length; i++){
            if(prevIsOne){
                if(nums[i] == 1) {
                    l++;
                }
                else{
                    l = 0;
                    prevIsOne = false;
                }
            }
            else{
                if(nums[i] == 1){
                    l++;
                    prevIsOne = true;
                }
            }
            if(l > max)
                max = l;
        }
        return max;
    }
}
