package Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,3,5,6,8};
        int[] nums2 = {1,2,5,7};
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int l = 0, h = n1;
        while(l <= h){
            int cut1 = (l+h)>>1;
            int cut2 = (n1+n2+1)/2 - cut1;
            int left1 = (cut1 == 0)?Integer.MIN_VALUE:nums1[cut1-1];
            int left2 = (cut2 == 0)?Integer.MIN_VALUE:nums2[cut2-1];
            int right1 = (cut1 == n1)?Integer.MAX_VALUE:nums1[cut1];
            int right2 = (cut2 == n2)?Integer.MAX_VALUE:nums2[cut2];
            if(left1 <= right2 && left2 <= right1){
                if((n1+n2)%2 == 0)
                    return (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
                else
                    return Math.max(left1,left2);
            }
            else if(left1 > right2)
                h = cut1-1;
            else
                l = cut1+1;
        }
        return 0.0;
    }
}
