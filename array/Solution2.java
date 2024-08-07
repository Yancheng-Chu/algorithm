package array;

import java.util.ArrayList;

class Solution2 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        ArrayList<Double> arr = new ArrayList<Double>();
        int result = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]>k){
                break;
            }else{
                double temp = 1;
                for (int i = j; i < nums.length; i++) {
                   temp =  nums[i]*temp;
                    if(temp < k){
                        arr.add(temp);
                        result++;
                    }else{
                        break;
                    }
                }
            }
        }
        System.out.println(arr.toString());
        return result;
    }

    public static void main(String[] arg) {
        Solution2 solution = new Solution2();
        // int[] nums1 = { 10, 5, 2, 6 };

        int[] nums1 = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        int result = solution.numSubarrayProductLessThanK(nums1, 19);
        System.out.println(result);
    }
}


// class Solution {
//     public int numSubarrayProductLessThanK(int[] nums, int k) {
//         int n = nums.length, ret = 0;
//         int prod = 1, i = 0;
//         for (int j = 0; j < n; j++) {
//             prod *= nums[j];
//             while (i <= j && prod >= k) {
//                 prod /= nums[i];
//                 i++;
//             }
//             ret += j - i + 1;
//         }
//         return ret;
//     }
// }