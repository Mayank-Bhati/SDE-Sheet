package Arrays;

// brute force are - sorting, set/hashing
public class findDuplicateNumberInArray {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
// Set<Integer> s = new HashSet<>();
//   for(int a: nums){
//       if(s.contains(a))
//           return a;
//       s.add(a);
//   }
//   return -1;