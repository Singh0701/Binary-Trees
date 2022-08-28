// Given the root of a complete binary tree, return the number of the nodes in the tree.

// According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

// Design an algorithm that runs in less than O(n) time complexity.
  
//Approach 1: Using A BFS Traversal.  
  
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int nodes = 0;
        queue.add(root);
        while(!queue.isEmpty()) {
            nodes++;
            TreeNode node = queue.poll();
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        return nodes;
    }
}

//Time Complexity = O(N)
//Space Comlpexity = O(N)


//Approach 2: Recursive solution with help of formula for a complete binary tree having (2^h - 1) - 1 nodes in an full tree.

class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = getLeftHeight(root);
        int right = getRightHeight(root);
        return (left == right) ? (int) Math.pow(2, left) - 1 : 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    public int getLeftHeight(TreeNode root) {
        if(root == null) return 0;
        return 1 + getLeftHeight(root.left);
    }
    
    public int getRightHeight(TreeNode root) {
        if(root == null) return 0;
        return 1 + getRightHeight(root.right);
    }
}


//Time Complexity = O(Log(N)^2)
//Space Comlpexity = O(Log(N))

