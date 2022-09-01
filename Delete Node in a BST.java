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
    public TreeNode deleteNode(TreeNode root, int key) {
      //If root itself is null then return null.
        if(root == null) return null;
      //If the root has to be deleted then call helper function on root, and return.
        if(root.val == key) {
            return helper(root);
        }
      //Point a duumy pointer to root, to return it at the end.
        TreeNode dummy = root;
        while(root != null) {
          //If the key is smaller than current node's val then look into the left subtree.
            if(root.val > key) {
              //If left subtree is not null and the left node is the one to be deleted then call helper function on root.left, else move to the left.
                if(root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
              //If the key value is greater then current node's value then look into the right subtree.
                //If the right is not null and right.val is equal to key then call helper function on root.right, else move right.
                if(root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
      //return answer.
        return dummy;
    }
    
  //Helper function takes the node to be deleted and returns the rearranged subTree's root node.
    public TreeNode helper(TreeNode root) {
      //If left subTree is null then return right.
        if(root.left == null) {
            return root.right;
        } 
        //If right is null then return left.
        else if(root.right == null) {
            return root.left;
        } 
        //Else take the right of root and the rightMost of the root's left Subtree and connect rightMost to the right of root and return root.left that is basically the root of new Subtree.
        else {
            TreeNode rightChild = root.right;
            TreeNode lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }
    
    public TreeNode findLastRight(TreeNode root) {
        while(root.right != null) {
            root = root.right;
        }
        return root;
    }
}
