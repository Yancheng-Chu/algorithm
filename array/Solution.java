package array;

import java.util.ArrayList;

class Solution {
    public int[] sortedSquares(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int index = 0;
        int left = 0;
        int right = 0;
        int smallest = 10000;
        for (int i = 0; i < nums.length; i++) {
            int current = Math.abs(nums[i]);
            if (current < smallest) {
                smallest = current;
                index = i;
                left = i - 1;
                right = i + 1;
                // System.out.println(smallest);
            }
        }
        temp.add((int) Math.pow(nums[index], 2));
        while (left >= 0 || right < nums.length) {

            if (left < 0) {
                temp.add((int) Math.pow(nums[right], 2));
                right += 1;
                continue;
            }
            if (right >= nums.length) {
                temp.add((int) Math.pow(nums[left], 2));
                left -= 1;
                continue;
            }
            int leftNum = Math.abs(nums[left]);
            int rightNum = Math.abs(nums[right]);
            if (leftNum >= rightNum) {
                temp.add((int) Math.pow(rightNum, 2));
                right += 1;
            } else {
                temp.add((int) Math.pow(leftNum, 2));
                left -= 1;
            }
        }

        int[] arr = temp.stream().mapToInt(i -> i).toArray();
        // int[] intArray = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        // intArray[i] = nums[i];
        // }
        return arr;
    }

    public static void main(String[] arg) {
        Solution solution = new Solution();
        int[] nums1 = { -4, -1, 0, 3, 10 };
        nums1 = solution.sortedSquares(nums1);
        for(int i=0;i<nums1.length;i++){
            System.out.println(nums1[i]);
        }
       
    }
}
