package top.codeshow.leetcode.common.util;


import top.codeshow.leetcode.common.oftenClass.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 链表工具类
 */
public class ListNodeUtils {
    /**
     * 根据数组生成node
     *
     * @param nums
     * @return
     */
    public static ListNode generateListNode(int[] nums) {
        ListNode root = new ListNode();
        ListNode temp = root;
        for (int num : nums) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        return root.next;
    }

    /**
     * 重写node的ToString方法
     *
     * @param node
     * @return
     */
    public static String nodeToString(ListNode node) {
        List<Integer> list = new LinkedList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list.toString();
    }

    public static void main(String[] args) {
        ListNode listNode = generateListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(nodeToString(listNode));
    }
}
