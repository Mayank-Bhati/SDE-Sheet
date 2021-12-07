package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithZeroSum {
    public static void main(String[] args) {
        int A[] = {15,-2,2,-8,1,7,10,23};
        System.out.println(maxLen(A));
    }
    static int maxLen(int[] arr){
        Map<Integer,Integer> m = new HashMap<>();
        int max = 0, sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum == 0) {
                if (i + 1 > max)
                    max = i + 1;
            }
                else if(m.containsKey(sum)){
                    int l = i - m.get(sum);
                    if(l > max)
                        max = l;
                }
                else
                    m.put(sum,i);
        }
        return max;
    }
}
