package Arrays;

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };
        System.out.println(searchMatrix(m,11));
        System.out.println(searchMatrix(m,21));
    }

    public static boolean searchMatrix(int[][] m, int t) {
        int r = m.length, c = m[0].length;
        int i = 0, j = c - 1;
        while (i < r && j >= 0) {
            if (m[i][j] == t)
                return true;
            else if (m[i][j] > t)
                j--;
            else
                i++;
        }
        return false;
    }
}
