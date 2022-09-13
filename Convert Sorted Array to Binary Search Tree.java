//Problem: Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree. A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.


class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
    
    public TreeNode buildTree(int[] nums, int low, int high) {
        if(low > high) return null;
        int mid = (low + high) % 2 == 0 ? (low + high) / 2 : (low + high + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, low, mid - 1);
        root.right = buildTree(nums, mid + 1, high);
        return root;
    }
}

//Time complexity = O((Log(N))
//Space complexity = O(Log(N)) Stack space.
