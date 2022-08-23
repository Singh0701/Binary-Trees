
// Problem Statement: BoundaryTraversal of a binary tree. Write a program for the Anti-Clockwise Boundary traversal of a binary tree.

/************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
		    this.data = data;
		    this.left = null;
		    this.right = null;
	    }

    }

************************************************************/

import java.util.*;

public class Solution {
	public static ArrayList<Integer> traverseBoundary(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if(!isLeaf(root)) result.add(root.data);
        getLeft(root, result);
        inorder(root, result);
        getRight(root, result);
        return result;
    }
    
    public static void getRight(TreeNode root, ArrayList<Integer> result) {
        TreeNode curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while(curr != null) {
            if(!isLeaf(curr)) temp.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        for(int i = temp.size() - 1; i >= 0; i--)
            result.add(temp.get(i));
    }
    
    public static void inorder(TreeNode root, ArrayList<Integer> result) {
        if(isLeaf(root)) {
            result.add(root.data);
            return;
        }
        if(root.left != null) inorder(root.left, result);
        if(root.right != null) inorder(root.right, result);
    }
    
    public static void getLeft(TreeNode root, ArrayList<Integer> result) {
        TreeNode curr = root.left;
        while(curr != null) {
            if(!isLeaf(curr)) result.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    
    public static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}


// Time Complexity: O(N)
// Space Complexity: O(N)



