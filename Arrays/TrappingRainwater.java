package Arrays;

public class TrappingRainwater {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
    public static int trap(int[] height) {
        int lMax = 0, rMax = 0, l = 0, r = height.length-1, ans = 0;
        while(l <= r){
            if(height[l] < height[r]){
                if(height[l] < lMax)
                    ans += (lMax - height[l]);
                else
                    lMax = height[l];
                l++;
            }
            else{
                if(height[r] < rMax)
                    ans += (rMax - height[r]);
                else
                    rMax = height[r];
                r--;
            }
        }
        return ans;
    }
}
