package Arrays;

public class ContainerWithMostWater {
    /*
    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate
     (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai)
      and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the
      container contains the most water.

Example 1:

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
     */
    public static int maxArea(int[] a) {

        int i = 0, j = a.length-1;
        int res = 0;
        while(i < j){
            res = Math.max(res,Math.min(a[i],a[j]) * (j - i));
            if(a[i] < a[j]){
                i++;
            }
            else
                j--;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
