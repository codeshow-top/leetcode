package top.codeshow.leetcode.common.util;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 数组工具类：补充自带的Arrays工具类
 */
public class ArrayUtils {
    /**
     * 字符生成二维数组
     *
     * @param str 字符
     * @return
     */
    public static int[][] getTwoDiArr(String str) {
        List<List<Integer>> lists = JSONUtil.parseArray(str).stream()
                .map(arr -> ((JSONArray) arr).toList(Integer.class))
                .collect(toList());
        return getTwoDiArrBy(lists);
    }

    /**
     * 将二维list列表转化为二维数组
     *
     * @param lists 列表
     * @return
     */
    public static int[][] getTwoDiArrBy(List<List<Integer>> lists) {
        int[][] arr2Di = new int[lists.size()][lists.get(0).size()];
        for (int i = 0; i < lists.size(); i++) {
            int[] arr = lists.get(i).stream().mapToInt(Integer::intValue).toArray();
            arr2Di[i] = arr;
        }
        return arr2Di;
    }

/*    public static void main(String[] args) {
        String s = "[[1,3],[5,4]]";
        int[][] twoDiArrByStr = getTwoDiArr(s);
        String str = Arrays.deepToString(twoDiArrByStr);
        System.out.println(str);
        assert str.equals(s);
    }*/
}
