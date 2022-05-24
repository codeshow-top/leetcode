package top.codeshow.leetcode.topic.pricture.oneHundred;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">3. 无重复字符的最长子串</a>
 */
public class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, max = 0;
        while (i < len) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int index = map.get(c);
                // 移除掉"c"在的索引及其之前的数据
                for (int k = j; k <= index; k++) {
                    // 删除有该元素中有key的值(error)
                    map.remove(s.charAt(k));
                }
                j = index + 1;
            } else {
                map.put(c, i);
                max = Math.max(max, i - j + 1);
                i++;
            }
        }
        return max;
    }

    @Test
    public void test() {
        int len1 = lengthOfLongestSubstring("abcabcbb");
        assert len1 == 3;
        int len2 = lengthOfLongestSubstring("bbbbb");
        assert len2 == 1;
        int len3 = lengthOfLongestSubstring("pwwkew");
        assert len3 == 3;
        // 提交错误的示例 "abba"
        long len4 = lengthOfLongestSubstring("abba");
        assert len4 == 2;
    }
}
