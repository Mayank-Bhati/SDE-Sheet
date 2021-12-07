package Map;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> m = new HashMap<>();
        int p = 0, max = 0, l = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!m.containsKey(c)){
                m.put(c,1);
                l++;
            }
            else{
                l++;
                while(s.charAt(p) != c){
                    m.remove(s.charAt(p));
                    p++;
                    l--;
                }
                m.remove(s.charAt(p));
                p++;
                l--;
                m.put(c,1);
            }
            if(l > max)
                max = l;
        }
        return max;
    }
}
