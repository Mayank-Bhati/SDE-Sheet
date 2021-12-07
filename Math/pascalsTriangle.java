package Math;

import java.util.ArrayList;
import java.util.List;

public class pascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> l = generate(10);
        for(List<Integer> arr : l){
            for(int a : arr){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> out = new ArrayList<>();
        int row = 1;
        while(row <= numRows){
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < row; i++){
                if(i == 0 || i == row-1)
                    l.add(1);
                else{
                    l.add(out.get(row-2).get(i-1)+out.get(row-2).get(i));
                }
            }
            row++;
            out.add(l);
        }
        return out;
    }




//    public static List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> out = new ArrayList<>();
//        int n = 1;
//        while(n <= numRows){
//            ArrayList<Integer> l = new ArrayList<>();
//            for(int i = 0; i < n; i++){
//                if(i == 0)
//                    l.add(1);
//                else if(i == n-1)
//                    l.add(1);
//                else{
//                    int f = out.get(n-2).get(i-1);
//                    int s = out.get(n-2).get(i);
//                    l.add(f+s);
//                }
//            }
//            out.add(l);
//            n++;
//        }
//        return out;
//    }
}
