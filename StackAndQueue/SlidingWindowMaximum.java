package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] out = new int[nums.length - k + 1];
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (q.isEmpty() || nums[q.peekLast()] > nums[i])
                q.addLast(i);
            else {
                while (!q.isEmpty() && nums[q.peekLast()] <= nums[i])
                    q.pollLast();
                q.addLast(i);
            }
            if (i >= k - 1) {
                while (!(q.peekFirst() > i - k))
                    q.pollFirst();
                out[i - k + 1] = nums[q.peekFirst()];
            }
        }
        return out;
    }
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        int[] out = new int[nums.length - k + 1];
//        Deque<Integer> q = new LinkedList.LinkedList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (i < k - 1) {
//                if (q.isEmpty() || nums[i] < nums[q.peekLast()])
//                    q.addLast(i);
//                else {
//                    while (!q.isEmpty() && nums[q.peekLast()] <= nums[i])
//                        q.removeLast();
//                    q.addLast(i);
//                }
//            } else {
//                if (q.isEmpty() || nums[i] < nums[q.peekLast()])
//                    q.addLast(i);
//                else {
//                    while (!q.isEmpty() && nums[q.peekLast()] <= nums[i])
//                        q.removeLast();
//                    q.addLast(i);
//                }
//                while (q.peekFirst() <= i - k)
//                    q.pollFirst();
//                out[i - k + 1] = nums[q.peekFirst()];
//            }
//        }
//        return out;
//    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] arr = maxSlidingWindow(nums, 3);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
