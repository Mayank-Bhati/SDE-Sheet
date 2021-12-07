package Arrays;

public class KthElementOfTwoSortedArrays {
    public static void main(String[] args) {
//        try{
//            int n = args.length;
//            int a = 5/n;
//            int[] arr = {1,2,3};
//            System.out.println("yeah");
//            arr[5] = 2;
//        }
//        catch (ArithmeticException|IndexOutOfBoundsException i){
//            System.out.println(i);
//        }
        int a = -2;
        try{
            if(a < 0){
                MyException me = new MyException("negative valueis not accepted");
                throw me;
            }
        }
        catch (MyException o){
            System.out.println(o);
        }
    }

    static class MyException extends Exception{
        MyException(){}
        MyException(String s){
//            super(s);
            System.out.println(s);
        }
    }

    public static long kthElement(int arr1[], int arr2[], int n, int m, int k) {
        int c = 0, i = 0, j = 0, ans = 0;
        while (i < n && j < m) {
            c++;
            if (arr1[i] < arr2[j]) {
                ans = arr1[i];
                i++;
            } else {
                ans = arr2[j];
                j++;
            }
            if (c == k)
                return ans;
        }
        while (i < n) {
            c++;
            ans = arr1[i];
            if (c == k)
                return ans;
            i++;
        }
        while (j < m) {
            c++;
            ans = arr2[j];
            if (c == k)
                return ans;
            j++;
        }
        return ans;
    }
}
