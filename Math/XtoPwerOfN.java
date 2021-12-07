package Math;

public class XtoPwerOfN {
    public static void main(String[] args) {
        System.out.println(myPow(3,-2));
    }

    public static double myPow(double x, int n) {
        double ans = 1.0;
        long p = n;
        if(p < 0)
            p *= -1;
        while(p > 0){
            if(p%2 == 0){
                x = x*x;
                p = p/2;
            }
            else{
                ans = ans*x;
                p--;
            }
        }
        return (n > 0)?ans:(1/ans);
    }
}
