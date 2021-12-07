package Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
//        rotateBrute(m);
        rotateInPlace(m);
        for(int[] arr : m){
            for(int a : arr){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }

    public static void rotateInPlace(int[][] m){
        transposeInPlace(m);
        for(int[] a : m){
            rotate(a);
        }
    }

    public static void rotateBrute(int[][] matrix) {
        int[][] t = transpose(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = t[i][j];
            }
        }
        for (int[] a : matrix) {
            rotate(a);
        }
    }

    public static int[][] transpose(int[][] mat) {
        int[][] t = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                t[i][j] = mat[j][i];
            }
        }
        return t;
    }

    public static void transposeInPlace(int[][] m){
        int n = m.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                swap2D(m,i,j);
            }
        }
    }
    public static void rotate(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            swap1D(arr, l, r);
            l++;
            r--;
        }
    }

    public static void swap1D(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void swap2D(int[][] arr, int i, int j) {
        int t = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = t;
    }
}
