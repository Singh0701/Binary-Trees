// Problem Statement: Given a binary tree, determine if it is height-balanced.
// For this problem, a height-balanced binary tree is defined as:
// a binary tree in which the left and right subtrees of every node differ in height by no more than 1.



// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: true

// Example 2:
// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false

// Example 3:
// Input: root = []
// Output: true
  
//Solution:

//Approach 1: Naive Brute Force using a Queue.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int getHeight(TreeNode root) {
        if(root == null) return 0;
        int leftSubTree = getHeight(root.left);
        int rightSubTree = getHeight(root.right);
        return 1 + Math.max(leftSubTree, rightSubTree);
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int left = 0;
            int right = 0;
            if(node.left != null) {
                left = getHeight(node.left);
                queue.add(node.left);
            }
            if(node.right != null) {
                right = getHeight(node.right);
                queue.add(node.right);
            }
            if(Math.abs(left - right) > 1) return false;
        }
        return true;
    }
}

//Time complexity = O(N^2)
//Space complexity = O(N + N) 
//N for using Queue and another N if we consider the recursion stack space for getHeight() function.

//Approach 2: Using recursion and without using a queue.

class Solution {
    
    public int getHeight(TreeNode root) {
        if(root == null) return 0;
        int leftSubTree = getHeight(root.left);
        int rightSubTree = getHeight(root.right);
        return 1 + Math.max(leftSubTree, rightSubTree);
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        if(Math.abs(leftH - rightH) > 1) return false;
        if(!isBalanced(root.left) || !isBalanced(root.right)) return false;
        return true;
    }
}

//Time complexity = O(N^2)
//Space complexity = O(N) 
//if we consider the recursion stack space, N for isBalanced() recursion stack space and another N for getHeight() function.



//Approach 3: Optimal (Using Maximum Depth of Binary Tree concept).

class Solution {
    
    public int getHeight(TreeNode root) {
        if(root == null) return 0;
        int leftSubTree = getHeight(root.left);
        int rightSubTree = getHeight(root.right);
        if(leftSubTree == -1 || rightSubTree == -1) return -1;
        if(Math.abs(leftSubTree - rightSubTree) > 1) return -1;
        return 1 + Math.max(leftSubTree, rightSubTree);
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(getHeight(root) < 0) return false;
        return true;
    }
}

//Time complexity = O(N)
//Space complexity = O(N) 
