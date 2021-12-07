package Arrays;

public class countInversionsInArray {
    public static void main(String[] args) {
        long[] arr = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr,5));
    }
    static long inversionCount(long arr[], long N)
    {
        long[] temp = new long[(int)N] ;
        return mergeSort(arr,temp,0, (int) (N-1));
    }
    static long mergeSort(long[] arr, long[] temp, int l, int r){
        int m = 0;
        long count = 0;
        if(l < r){
            m = l+(r-l)/2;
            count += mergeSort(arr,temp,l,m);
            count += mergeSort(arr, temp,m+1,r);
            count += merge(arr,temp,l,m+1,r);
        }
        return count;
    }
    static long merge(long[] arr, long[] temp, int l, int m, int r){
        long count = 0;
        int i = l, j = m, k = l;
        while(i < m && j <= r){
            if(arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else{
                temp[k++] = arr[j++];
                count = count + (m - i);
            }
        }
        while(i < m)
            temp[k++] = arr[i++];
        while(j <= r)
            temp[k++] = arr[j++];
        for(int x = l;x <= r; x++)
            arr[x] = temp[x];
        return count;
    }
}
