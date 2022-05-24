package top.codeshow.leetcode.common.util;

/**
 * Double工具类
 */
public class DoubleUtils {
    public static boolean equals(Double d1, Double d2) {
        if (d1 == null || d2 == null) {
            return false;
        }
        return Double.compare(d1, d2) == 0;
    }
}
