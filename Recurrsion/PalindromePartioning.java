package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartioning {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> out = new ArrayList<>();
        List<String> l = new ArrayList<>();
        helper(s,0,l,out);
        return out;
    }
    static void helper(String s, int ind, List<String> l, List<List<String>> out){
        if(ind == s.length()){
            out.add(new ArrayList<>(l));
            return;
        }
        for(int i = ind+1; i <= s.length(); i++){
            String sub = s.substring(ind,i);
            if(isPalin(sub)){
                /*
                 l.add(sub);
                helper(s,i,l,out);
                l.remove(l.size()-1);
                 */
                List<String> temp = new ArrayList<>(l);
                temp.add(sub);
                helper(s,i,temp,out);
            }
        }
    }
    static boolean isPalin(String s){
        int i = 0, j = s.length()-1;
        while( i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
