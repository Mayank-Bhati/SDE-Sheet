package Arrays;

public class setMatrixZero {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(mat);
        for (int[] arr : mat) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        int col = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == 0 && matrix[i][j] == 0)
                    col = 0;
                else if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = matrix.length-1; i >= 0; i--){
            for(int j = matrix.length-1; j >= 0; j--){
                if(j == 0){
                    if(col == 0)
                        matrix[i][j] = 0;
                }
                else if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
                else
                    continue;
            }
        }
    }

//    public static void setZeroes(int[][] matrix) {
//        int col = 1;
//        for(int i = 0; i < matrix.length; i++){
//            for(int j = 0; j < matrix[0].length; j++){
//                if(j == 0 && matrix[i][j] == 0)
//                    col = 0;
//                else if(matrix[i][j] == 0){
//                    matrix[i][0] = 0;
//                    matrix[0][j] = 0;
//                }
//                else
//                    continue;
//            }
//        }
//        for(int i = matrix.length-1; i >= 0; i--){
//            for(int j = matrix[0].length-1; j >= 0; j--){
//                if(j == 0){
//                    if(col == 0)
//                        matrix[i][j] = 0;
//                }
//                else if(j != 0 && matrix[i][0] == 0 || matrix[0][j] == 0)
//                    matrix[i][j] = 0;
//                else
//                    continue;
//            }
//        }


//        int[] r = new int[matrix.length];
//        int[] c = new int[matrix[0].length];
//        for(int i = 0; i < matrix.length; i++){
//            for(int j = 0; j < matrix[i].length; j++){
//                if(matrix[i][j] == 0){
//                    r[i] = 1;
//                    c[j] = 1;
//                }
//            }
//        }
//        for(int i = 0; i < matrix.length; i++){
//            for(int j = 0; j < matrix[i].length; j++){
//                if(r[i] == 1 || c[j] == 1)
//                    matrix[i][j] = 0;
//            }
//        }
//    }
}
