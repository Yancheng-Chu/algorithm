package string;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && symbolValues.get(s.charAt(i)) < symbolValues.get(s.charAt(i + 1))) {
                int n = symbolValues.get(s.charAt(i));
                result -= n;
                continue;
            }
            result += symbolValues.get(s.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "III";
        String s2 = "IV";
        String s3 = "IX";
        String s4 = "LVIII";
        String s5 = "MCMXCIV";

        System.out.println(solution.romanToInt(s1));
        System.out.println(solution.romanToInt(s2));
        System.out.println(solution.romanToInt(s3));
        System.out.println(solution.romanToInt(s4));
        System.out.println(solution.romanToInt(s5));
    }
}