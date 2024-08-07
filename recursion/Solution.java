package recursion;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> result = new ArrayList<String>();
    public final int len = 4;
    List<String> current = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {
        int i = 0;
        int seg = 0;
        recursion(s, i, seg);


        for (String j : result) {
            System.out.println(j);
        }
        return result;
    }

    // dfs:
    public void recursion(String s, int i, int seg) {

        if (seg == len) {
            if (i == s.length()) {
                StringBuffer sb = new StringBuffer();
                for (String c : current) {
                    sb.append(c + ".");
                }
                String cur = sb.toString();
                cur = cur.substring(0, cur.length() - 1);
                result.add(cur);
            }
            return;
        }

        if (i == s.length()) {
            return;
        }

        if (s.charAt(i) == '0') {
            current.add(String.valueOf(s.charAt(i)));
            recursion(s, i + 1, seg + 1);
            current.remove(current.size() - 1);
            // return;
        }
        for (int j = i; j < s.length() && j < i + 3; j++) {
            int inte = Integer.parseInt(s.substring(i, j + 1));
            if (inte > 0 && inte < 256) {
                current.add(String.valueOf(inte));
                recursion(s, j + 1, seg + 1);
                current.remove(current.size() - 1);
            } else {
                break;
            }

        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "101023";
        solution.restoreIpAddresses(s);

        // for(String i:result){

        // }
    }
}
