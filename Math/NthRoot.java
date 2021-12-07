package Math;

public class NthRoot {
    public static void main(String[] args) {
        System.out.println(nthRoot(3,9));
    }

    public static double nthRoot(int n, int m){ // if need answer correct upto 5 decimal places
        if(m == 1)
            return 1;
        double l = 1, r = m;
        double eps = 1e-6;
        while(r-l > eps){
            double mid = (l+r)/2.0;
            double p = Math.pow(mid,n);
            if(p < m)
                l = mid;
            else
                r = mid;
        }
        return l ;// l and r are almost equal here
    }

    public static int NthRoot(int n, int m){ // if we need to return integer only
        if(m == 1)
            return 1;
        // for(int i = 1; Math.pow(i,n) <= m ; i++){
        //     if(Math.pow(i,n) == m)
        //     return i;
        //     else if(Math.pow(i,n) > m)
        //     return -1;
        // }
        int l = 1, r = m;
        while(l <= r){
            int mid = l + (r-l)/2;
            double p = Math.pow(mid,n);
            if(p == m)
                return mid;
            else if(p < m)
                l = mid+1;
            else
                r = mid - 1;
        }
        return -1;
    }

}
