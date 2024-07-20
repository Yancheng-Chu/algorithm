import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[] { hashtable.get(target - nums[i]), i };
            }
            hashtable.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println(
                "Test Case 1: " + (result1 != null ? "[" + result1[0] + ", " + result1[1] + "]" : "No solution"));

        // Test case 2
        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println(
        "Test Case 2: " + (result2 != null ? "[" + result2[0] + ", " + result2[1] +
        "]" : "No solution"));

        // Test case 3
        int[] nums3 = { 3, 3 };
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println(
        "Test Case 3: " + (result3 != null ? "[" + result3[0] + ", " + result3[1] +
        "]" : "No solution"));
    }
}