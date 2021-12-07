package Recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensLeetcode {
    public static List<List<String>> solveNQueens(int n) {
        List<int[][]> out = new ArrayList<>();
        int[][] board = new int[n][n];
//        for(int[] arr : board)
//            Arrays.fill(arr,0);
        helper(0,board,out,n);
        List<List<String>> ans = new ArrayList<>();
        for(int k = 0; k < out.size(); k++){
            int[][] arr = out.get(k);
            List<String> l = new ArrayList<>();
            for(int i = 0; i < arr.length; i++){
                String s = "";
                for(int j = 0; j < arr.length; j++){
                    if(arr[i][j] == 0)
                        s += '.';
                    else
                        s += 'Q';
                }
                l.add(s);
            }
            ans.add(l);
        }
        return ans;
    }
    static void helper(int r, int[][] board, List<int[][]> out, int n){
        if( r >= n){
            int[][] arr = new int[board.length][board.length];
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board.length; j++){
                    arr[i][j] = board[i][j];
                }
            }
            out.add(arr);
        }
        for(int i = 0; i < n; i++){
            if(isValid(board,r,i,n)){
                board[r][i] = 1;
                helper(r+1,board,out,n);
                board[r][i] = 0;
            }
        }
    }

    static boolean isValid(int[][] board, int r, int c, int n){
        for(int i = 0; i < r; i++)
            if(board[i][c] == 1)
                return false;
        for(int i = r, j = c; i >= 0 && j >= 0; i--, j--)
            if(board[i][j] == 1)
                return false;
        for(int i = r, j  = c; i >= 0 && j < n; i--, j++)
            if(board[i][j] == 1)
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
