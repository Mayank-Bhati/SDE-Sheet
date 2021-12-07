package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {3,6,1,2,0,4,5,100,300,45};
        System.out.println(longestConsecutive(arr));
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i : nums)
            s.add(i);
        int max = 0;
        for(int i : s){
            int l = 0;
            if(!s.contains(i-1)){
                l = 1;
            }
            while(s.contains(i+1)){
                l++;
                i++;
                if(l > max)
                    max = l;
            }
        }
        return max;
    }
}
