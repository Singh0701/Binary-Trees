//Problem Statement: Given the root of a binary tree, return its maximum depth.
//A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


//Solution: Using recursion.

class Solution {
    public int maxDepth(TreeNode root) {
      //Base case for the recuurence.
        if(root == null) return 0;
      //Get the left sub tree's height.
        int left = maxDepth(root.left);
      //Get the right tree's height
        int right = maxDepth(root.right);
      //Return 1 + Max of left and right sub tree's height.
        return 1 + Math.max(left, right);
    }
}


//Time complexity = O(N)
//Space complexity = O(height) 
//Stack space for recursion calls.



//Using Level Order Traversal.

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode curr = queue.poll();
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            height++;
        }    
        return height;
    }
}


//Time complexity = O(N)
//Space complexity = O(N) 
//Space for queue.
