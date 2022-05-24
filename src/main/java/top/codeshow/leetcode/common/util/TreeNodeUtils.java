package top.codeshow.leetcode.common.util;

import org.junit.jupiter.api.Test;
import top.codeshow.leetcode.common.oftenClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树工具类
 */
public class TreeNodeUtils {
    public static TreeNode generateTreeNodeByArr(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        int numsSize = list.size();
        TreeNode treeNode = new TreeNode(list.get(0));
        int index = 2;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (index <= numsSize - 1) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode poll = queue.poll();
                if (index <= numsSize - 1) {
                    Integer val = list.get(index++);
                    if (val != null) {
                        TreeNode leftTreeNode = new TreeNode(val);
                        assert poll != null;
                        poll.left = leftTreeNode;
                        queue.add(leftTreeNode);
                    }
                } else {
                    break;
                }
                if (index <= numsSize - 1) {
                    Integer val = list.get(index++);
                    if (val != null) {
                        TreeNode rightTreeNode = new TreeNode(val);
                        poll.right = rightTreeNode;
                        queue.add(rightTreeNode);
                    }
                } else {
                    break;
                }
            }
        }
        return treeNode;
    }

    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(null);
        list.add(3);
        list.add(null);
        list.add(1);
        TreeNode treeNode = TreeNodeUtils.generateTreeNodeByArr(list);
        System.out.println(treeNode);
    }
}