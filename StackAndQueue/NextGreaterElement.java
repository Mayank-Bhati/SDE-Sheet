package StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums = {5,2,3,4,3};
        int[] out = nextGreaterElements(nums);
        for(int i : out)
            System.out.print(i+" ");
    }
    static public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] out = new int[n];
        Arrays.fill(out,-1);
        Stack<Integer> s = new Stack<>();
        for(int k = 0; k < 2; k++){
            for(int i = n-1; i >= 0; i--){
                while(!s.empty() && s.peek() <= nums[i])
                    s.pop();
                if(!s.empty())
                    out[i] = s.peek();
                s.push(nums[i]);
            }
        }
        return out;
    }
    public int[] nextGreaterElements2(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }
}
