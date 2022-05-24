package top.codeshow.leetcode.topic.pricture.oneHundred;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/">5. 最长回文子串</a>
 */
public class Solution005 {
    public String longestPalindrome(String s) {
        int len = s.length();
        int[] result = new int[]{0, 0};
        int max = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            int start = 0;
            while (start + i < len) {
                if (i == 0) {
                    dp[start][start + i] = true;
                } else if (i == 1) {
                    dp[start][start + i] = s.charAt(start) == s.charAt(start + 1);
                } else {
                    dp[start][start + i] = dp[start + 1][start + i - 1] && s.charAt(start) == s.charAt(start + i);
                }
                if (dp[start][start + i] && i > max) {
                    result = new int[]{start, start + i};
                }
                start++;
            }
        }
        return s.substring(result[0], result[1] + 1);
    }
}
