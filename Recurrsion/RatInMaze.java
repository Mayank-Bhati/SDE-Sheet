package Recurrsion;

import java.util.ArrayList;

public class RatInMaze {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        helper(0, 0, m, n, ans, "");
        return ans;
    }

    static void helper(int r, int c, int[][] m, int n, ArrayList<String> ans, String s) {
        if(!isValid(r,c,m,n))
            return ;
        if (r == n - 1 && c == n - 1) {
            ans.add(s);
            return;
        }
        if (isValid(r - 1, c, m, n)) {
            m[r - 1][c] = 0;
            helper(r - 1, c, m, n, ans, s + 'D');
            m[r - 1][c] = 1;
        }
        if (isValid(r, c - 1, m, n)) {
            m[r][c - 1] = 0;
            helper(r, c - 1, m, n, ans, s + 'L');
            m[r][c - 1] = 1;
        }
        if (isValid(r, c + 1, m, n)) {
            m[r][c + 1] = 0;
            helper(r, c + 1, m, n, ans, s + 'R');
            m[r][c + 1] = 1;
        }
        if (isValid(r + 1, c, m, n)) {
            m[r + 1][c] = 0;
            helper(r + 1, c, m, n, ans, s + 'U');
            m[r + 1][c] = 1;
        }
    }

    static boolean isValid(int r, int c, int[][] m, int n) {
        if (r < 0 || c < 0 || r >= n || c >= n)
            return false;
        else if (m[r][c] == 0)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        int[][] m = {
                {0, 1, 1, 1},
                {1, 1, 1, 0},
                {1, 0, 1, 1},
                {0, 0, 1, 1}
        };
        System.out.println(findPath(m, 5));
    }

}
   /* public static ArrayList<String> findPath(int[][] m, int n) {
        int[][] vis = new int[n][n] ;
        ArrayList<String> ans = new ArrayList<>();
        helper(0,0,m,n,ans,"",vis);
        return ans;
    }
    static void helper(int r, int c, int[][] m, int n, ArrayList<String> ans, String s, int[][] vis){
        if(!isValid(r,c,m,n,vis))
            return;
        if(r == n-1 && c == n-1){
            ans.add(s);
            return;
        }
        vis[r][c] = 1;
        if(isValid(r-1,c,m,n,vis)){
            helper(r-1,c,m,n,ans,s+'U',vis);
        }
        if(isValid(r+1,c,m,n,vis)){
            helper(r+1,c,m,n,ans,s+'D',vis);
        }
        if(isValid(r,c-1,m,n,vis)){
            helper(r,c-1,m,n,ans,s+'L',vis);
        }
        if(isValid(r,c+1,m,n,vis)){
            helper(r,c+1,m,n,ans,s+'R',vis);
        }
        vis[r][c] = 0;
    }
    static boolean isValid(int r, int c, int[][] m, int n,int[][] vis){
        if(r < 0 || c < 0 || r >= n || c >= n)
        return false;
        else if(m[r][c] == 0 || vis[r][c] == 1)
        return false;
        else
        return true;
    }
    */
