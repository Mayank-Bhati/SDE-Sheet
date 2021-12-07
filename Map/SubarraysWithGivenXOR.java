package Map;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithGivenXOR {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9};
        int m = 5;
        System.out.println(subarrayXor(arr,arr.length,m));
    }

    static long subarrayXor(int arr[], int n, int m) {
        Map<Integer,Integer> map = new HashMap<>();
        int xor = 0, ans = 0;
        for(int i = 0; i < n; i++){
            xor ^= arr[i];
            if(xor == m){
                ans++;
                map.put(xor,map.getOrDefault(xor,0)+1);
            }
            else{
                map.put(xor,map.getOrDefault(xor,0)+1);
                int y = xor ^ m;
                if(map.containsKey(y))
                    ans += map.get(y);
            }
        }
        return ans;
    }
}
