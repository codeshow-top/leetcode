package top.codeshow.leetcode.topic.pricture.oneHundred;

import org.junit.jupiter.api.Test;
import top.codeshow.leetcode.common.oftenClass.ListNode;
import top.codeshow.leetcode.common.util.ListNodeUtils;

import java.util.Objects;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers/">2.两数相加</a>
 */
public class Solution002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode temp = root;
        int moreTen = 0;
        while (l1 != null || l2 != null || moreTen > 0) {
            int val1 = (l1 == null) ? 0 : l1.val;
            int val2 = (l2 == null) ? 0 : l2.val;
            int val = val1 + val2 + moreTen;
            moreTen = val / 10;
            temp.next = new ListNode(val % 10);
            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return root.next;
    }

    @Test
    public void test() {
        ListNode listNode1 = ListNodeUtils.generateListNode(new int[]{2, 4, 3});
        ListNode listNode2 = ListNodeUtils.generateListNode(new int[]{5, 6, 4});
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        assert Objects.equals(ListNodeUtils.nodeToString(listNode), "[7, 0, 8]");
    }
}
