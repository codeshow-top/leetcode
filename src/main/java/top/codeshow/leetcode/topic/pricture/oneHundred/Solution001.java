package top.codeshow.leetcode.topic.pricture.oneHundred;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum/">1. 两数之和</a>
 */
public class Solution001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 因为每种输入只有一种答案
            // 所以答案只可能是两个相等(如3,3)或两个不同的唯一值(如2,4)
            if (map.get(target - num) != null) {
                return new int[]{map.get(target - num), i};
            }
            map.put(num, i);
        }
        return null;
    }
}
