package LC0003_LongestSubstringWithoutRepeatingCharacters;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">Longest Substring Without Repeating Characters</a>
 * 哈希表；字符串；滑动窗口
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();

        boolean[] map = new boolean[128];
        Arrays.fill(map, false);
        map[s.charAt(0)] = true;

        int i = 0;
        int maxLength = 1;
        for (int j = 1; j < s.length(); j++) {

            if (!map[s.charAt(j)]) {
                maxLength = Math.max(maxLength, j - i + 1);
            } else {
                while (map[s.charAt(j)]) {
                    map[s.charAt(i++)] = false;
                }
            }

            map[s.charAt(j)] = true;
        }

        return maxLength;
    }

//    public int lengthOfLongestSubstring(String s) {
//        StringBuilder sb = new StringBuilder();
//        if (!s.isEmpty()) {
//            sb.append(s.charAt(0));
//        }
//
//        int maxLength = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int index = sb.indexOf(String.valueOf(s.charAt(i)));
//
//            if (index != -1) {
//                sb.delete(0, index + 1);
//            }
//            sb.append(s.charAt(i));
//
//            maxLength = Math.max(maxLength, sb.length());
//        }
//
//        return maxLength;
//    }
}