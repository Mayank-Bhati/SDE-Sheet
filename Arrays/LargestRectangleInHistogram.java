package Arrays;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] h) {
        int[] left = new int[h.length];
        int[] right = new int[h.length];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < h.length; i++){
            if(s.empty()){
                s.push(i);
                left[i] = i;
            }
            else{
                while(!s.empty() && h[s.peek()] >= h[i])
                    s.pop();
                if(s.empty()){
                    s.push(i);
                    left[i] = i;
                }
                else{
                    left[i] = s.peek();
                    s.push(i);
                }
            }
        }
        s.clear();
        for(int i = h.length-1; i>= 0; i--){
            if(s.empty()){
                s.push(i);
                right[i] = i;
            }
            else{
                while(!s.empty() && h[s.peek()] >= h[i])
                    s.pop();
                if(s.empty()){
                    s.push(i);
                    right[i] = i;
                }
                else{
                    right[i] = s.peek();
                    s.push(i);
                }
            }
        }
        int out = 0;
        for(int i = 0; i < h.length; i++){
            int area = h[i]*(right[i]-left[i]);
            if(area > out)
                out = area;
        }
        return out;
    }
}
