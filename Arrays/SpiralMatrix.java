package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> l = spiralOrder(mat);
        for(int a : l)
            System.out.print(a+" ");
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l =new ArrayList<>();
        int rs = 0, re = matrix.length-1, cs = 0, ce = matrix[0].length-1;
        while(valid(rs,re,cs,ce)){
            for(int i = cs; i <= ce; i++)
                l.add(matrix[rs][i]);
            rs++;
            if(!valid(rs,re,cs,ce))
                return l;
            for(int i = rs; i <= re; i++)
                l.add(matrix[i][ce]);
            ce--;
            if(!valid(rs,re,cs,ce))
                return l;
            for(int i = ce; i >= cs; i--)
                l.add(matrix[re][i]);
            re--;
            if(!valid(rs,re,cs,ce))
                return l;
            for(int i = re; i >= rs; i--)
                l.add(matrix[i][cs]);
            cs++;
        }
        return l;
    }
    static boolean valid(int rs, int re, int cs, int ce){
        return (rs <= re && cs <= ce);
    }
}
