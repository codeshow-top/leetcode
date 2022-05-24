package top.codeshow.leetcode.topic.pricture.oneHundred;

import org.junit.jupiter.api.Test;
import top.codeshow.leetcode.common.util.DoubleUtils;

/**
 * <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/">4. 寻找两个正序数组的中位数</a>
 */
public class Solution004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        if (len == 0) {
            return 0;
        }
        int mid = len / 2;
        if (len % 2 == 0) {
            // 寻找数组中最中间两个相除
            int num1 = findNoSortedArrays(mid, nums1, nums2, 0, len1 - 1, 0, len2 - 1);
            int num2 = findNoSortedArrays(mid + 1, nums1, nums2, 0, len1 - 1, 0, len2 - 1);
            return (num1 + num2) / 2.0;
        } else {
            return findNoSortedArrays(mid + 1, nums1, nums2, 0, len1 - 1, 0, len2 - 1);
        }
    }

    /**
     * 寻找寻找两个数组中第no大的数(从num1的start1到end1,从num2的start2到end2)
     *
     * @param no     第几个数
     * @param nums1  数组1
     * @param nums2  数组2
     * @param start1 开始索引1
     * @param end1   结束索引2
     * @param start2 开始索引2
     * @param end2   结束索引2
     * @return
     */
    int findNoSortedArrays(int no, int[] nums1, int[] nums2, int start1, int end1, int start2, int end2) {
        if (no == 1) {
            return Math.min(getMin(nums1, start1, end1), getMin(nums2, start2, end2));
        }
        int noSub = no / 2;
        int mid1 = findMedianSortedArrays(nums1, start1, end1, noSub);
        int mid2 = findMedianSortedArrays(nums2, start2, end2, noSub);
        if (mid1 <= mid2) {
            // mid1所在的索引
            // 要寻找的数(减去已经找到的数)
            int no1 = no - noSub;
            return findNoSortedArrays(no1, nums1, nums2, start1 + noSub, end1, start2, end2);
        } else {
            int no2 = no - noSub;
            return findNoSortedArrays(no2, nums1, nums2, start1, end1, start2 + noSub, end2);
        }
    }

    private int findMedianSortedArrays(int[] nums, int start, int end, int no) {
        if (start > end || start + no - 1 > nums.length - 1) {
            return Integer.MAX_VALUE;
        }
        return nums[start + no - 1];
    }

    private int getMin(int[] nums, int start, int end) {
        if (start > end || end >= nums.length) {
            return Integer.MAX_VALUE;
        }
        return nums[start];
    }

    @Test
    public void test() {
        double num1 = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println(num1);
        assert DoubleUtils.equals(num1, 2D);
        double num2 = findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(num2);
        assert DoubleUtils.equals(num2, 2.5);
        double num3 = findMedianSortedArrays(new int[]{1, 2, 6}, new int[]{3, 4, 4});
        System.out.println(num3);
        assert DoubleUtils.equals(num3, 3.5);
        double num4 = findMedianSortedArrays(new int[]{1, 2, 3, 5, 6, 7, 6}, new int[]{1, 3, 4, 9});
        System.out.println(num4);
        assert DoubleUtils.equals(num4, 4D);
        double num5 = findMedianSortedArrays(new int[]{2}, new int[]{});
        System.out.println(num5);
        assert DoubleUtils.equals(num5, 2D);
    }
}
