package sort;

import java.util.Arrays;

class Solution {
    // 遍历数组，将每一个元素和后一个比较
    // 若前>后,则swap， 直到最大元素在末尾
    public void bubble(int[] s) {
        for (int i = 0; i < s.length; i++) {
            for (int j = i; j < s.length - 1; j++) {
                if (s[j] > s[j + 1]) {
                    int temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] s = new int[] { 10, 1, 2, 12, 20 };
        solution.bubble(s);
        System.out.println(Arrays.toString(s));
    }

}
