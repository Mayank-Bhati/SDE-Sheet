package Math;

public class ReverseTheInteger {
    /*
    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the
     value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     */
    public static int reverse(int x) {
        boolean neg = false;
        if(x < 0){
            neg = true;
            x = -1*x;
        }
        long ans = 0;
        while(x > 0){
            int r = x % 10;
            x /= 10;
            ans = 10*ans + r;
        }
        if(neg){
            if(ans > Math.pow(2,31))
                return 0;
            else
                return (int)(-1*ans);
        }
        else{
            if(ans > Math.pow(2,31)-1)
                return 0;
            else
                return (int)ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(1234567));
    }
}
