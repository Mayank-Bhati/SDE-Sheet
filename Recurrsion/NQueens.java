package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    static List<int[][]> nQueen(int n){
        List<int[][]> out = new ArrayList<>();
        int[][] board = new int[n][n];
        helper(board,0,out);
        return out;
    }

    private static boolean helper(int[][] board, int r, List<int[][]> out) {
        if(r >= board.length) {
//            out.add(board);
            int[][] arr = new int[board.length][board.length];
           for(int i = 0; i < board.length; i++){
               for(int j = 0; j < board.length; j++){
                   arr[i][j] = board[i][j];
               }
           }
           out.add(arr);
            return true;
        }
        for(int i = 0; i < board.length; i++){
            if(isValid(board,r,i)) {
                board[r][i] = 1;
                helper(board, r + 1, out);
                board[r][i] = 0;
            }
        }
        return false;
    }

    private static boolean isValid(int[][] board, int r, int c) {
        for(int i = 0; i < r; i++){
            if(board[i][c] == 1)
                return false;
        }
        for(int i = r-1,j = c-1; i >= 0 && j >= 0; i--,j--){
            if(board[i][j] == 1)
                return false;
        }
        for(int i = r-1,j = c+1; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 1)
                return false;
        }
        return true;
    }

    static void print(List<int[][]> board){
        for(int[][] out : board){
            for(int[] arr : out){
                for(int i : arr){
                    System.out.print(i+" ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(nQueen(6));
    }
}
