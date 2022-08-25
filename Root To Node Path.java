// Problem Description

// Given a Binary Tree A containing N nodes.

// You need to find the path from Root to a given node B.

// NOTE:

// No two nodes in the tree have same data values.
// You can assume that B is present in the tree A and a path always exists.


//Solution: Using recursion, Trying out all paths.

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        getPath(A, B, result);
        return result;
    }
    
    public boolean getPath(TreeNode root, int dest, ArrayList<Integer> result) {
        if(root == null) return false;
        result.add(root.val);
        if(root.val == dest) {
            return true;
        }
        if(getPath(root.left, dest, result) || getPath(root.right, dest, result))
                return true;
        result.remove(result.size() - 1);
        return false;
    }
}


//Time Complexity = O(N)
//Space Complexity = O(Height)
