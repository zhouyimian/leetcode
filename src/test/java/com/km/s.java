package com.km;

import java.util.*;

public class s {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int ans = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        List<Integer> nums = new ArrayList<>();
        nums.add(root.val);
        if (root.left != null)
            pseudoPalindromicPaths(root.left, nums);
        if (root.right != null)
            pseudoPalindromicPaths(root.right, nums);
        return ans;
    }

    private void pseudoPalindromicPaths(TreeNode root, List<Integer> nums) {
        nums.add(root.val);
        if (root.left == null && root.right == null) {
            if (check(nums))
                ans++;
            nums.remove(nums.size() - 1);
            return;
        }
        if (root.left != null)
            pseudoPalindromicPaths(root.left, nums);
        if (root.right != null)
            pseudoPalindromicPaths(root.right, nums);
        nums.remove(nums.size() - 1);
    }

    private boolean check(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num,map.getOrDefault(num, 0) + 1);
        int oddNum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1)
                oddNum++;
        }
        if (nums.size() % 2 == 0)
            return oddNum == 0;
        return oddNum == 1;
    }
}
