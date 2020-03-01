package com.km.WeeklyContest178;

import java.util.ArrayList;
import java.util.List;

public class Linked_List_in_Binary_Tree {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        for (ListNode curr = head; curr != null; curr = curr.next) {
            lst.add(curr.val);
        }
        if (maxDepth(root) < lst.size()) return false;
        return isSubPath(lst, root, false);
    }

    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    private boolean isSubPath(List<Integer> lst, TreeNode root, boolean listElementFound) {
        if (lst.size() == 0) return true;
        if (root == null) return false;
        if (listElementFound && root.val != lst.get(0)) return false;

        if (root.val == lst.get(0)) {
            List<Integer> lstClone = new ArrayList<Integer>(lst);
            lstClone.remove(0);
            if (isSubPath(lstClone, root.left, true)) return true;

            lstClone = new ArrayList<Integer>(lst);
            lstClone.remove(0);
            if (isSubPath(lstClone, root.right, true)) return true;

            if (listElementFound) return false;
        }
        return isSubPath(lst, root.left, false) ||
                isSubPath(lst, root.right, false);
    }
}
