package Arrays;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3,1};
        System.out.println(searchEfficient(nums,1));
    }

    public static int searchEfficient(int[] nums, int t) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == t)
                return m;
           if(nums[l] <= nums[m]){
               if(t >= nums[l] && t <= nums[m])
                   r = m-1;
               else
                   l = m+1;
           }
           else{
               if(t >= nums[m] && t <= nums[r])
                   l = m+1;
               else
                   r = m-1;
           }
        }
        return -1;
    }

    static public int search(int[] nums, int t) {
        if(nums.length == 1)
            return (nums[0] == t)?0:-1;
        int p = pivot(nums);
        // System.out.println(p);
        int ans = binarySearch(nums,t,0,p);
        if(ans != -1)
            return ans;
        else if(p < nums.length-1)
            return binarySearch(nums,t,p+1,nums.length-1);
        else
            return -1;
    }
    static int binarySearch(int[] arr, int t, int l, int r){
        while (l <= r){
            int m = (l+r)/2;
            if(t > arr[m])
                l = m+1;
            else if(t < arr[m])
                r = m-1;
            else
                return m;
        }
        return -1;
    }
    static int pivot(int[] nums){
        int l = 0, r = nums.length-1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(m < r && nums[m] > nums[m+1])
                return m;
            else if(m > l && nums[m] < nums[m-1])
                return m-1;
            else if(nums[l] >= nums[m])
                r = m-1;
            else
                l = m+1;
        }
        return l;
    }
}
