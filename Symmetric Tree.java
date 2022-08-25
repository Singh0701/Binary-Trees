// Problem Statement: Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

// Example 1:
// Input: root = [1,2,2,3,4,4,3]
// Output: true


// Example 2:
// Input: root = [1,2,2,null,3,null,3]
// Output: false


//Solution: 

//Approach 1: Using preorder and postorder traversal.

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        preorder(root.left, arr1);
        postorder(root.right, arr2);
        if(arr1.size() != arr2.size()) return false;
        for(int i = 0; i < arr1.size(); i++) {
            if(arr1.get(i) != arr2.get(arr2.size() - i - 1))
                return false;
        }
        return true;
    }
    
    
    public void preorder(TreeNode root, List<Integer> arr) {
        if(root == null) {
            arr.add(null);
            return;
        }
        arr.add(root.val);
        preorder(root.left, arr);
        preorder(root.right, arr);
    }
    
    public void postorder(TreeNode root, List<Integer> arr) {
        if(root == null) {
            arr.add(null);
            return;
        }
        postorder(root.left, arr);
        postorder(root.right, arr);
        arr.add(root.val);
    }
}


//Time Complexity = O(N + N + N)
//Space Complexity = O(N + N)



//Approach 2: Using recursion.

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSame(root.left, root.right);
    }
    
    public boolean isSame(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) return root1 == root2;
        if(root1.val != root2.val) return false;
        return isSame(root1.left, root2.right) && isSame(root1.right, root2.left);
    }
}
//Time Complexity = O(N)
//Space Complexity = O(N)

