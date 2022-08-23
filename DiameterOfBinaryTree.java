// Problem Statement: Given the root of a binary tree, return the length of the diameter of the tree.
// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
// The length of a path between two nodes is represented by the number of edges between them.


//Solution:

//Approach 1: Brute Force. (Check the maximum path length for each node in the tree)

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        findMax(root, res);
        return res.get(0);
        // return maximum;
    }
    
    public void findMax(TreeNode node, List<Integer> maximum) { 
        if(node == null) return;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        maximum.set(0, Math.max(left + right, maximum.get(0)));
        findMax(node.left, maximum);
        findMax(node.right, maximum);
    }
    
    public int getHeight(TreeNode node) {
        if(node == null) return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return 1 + Math.max(left, right);
    }
}


//Time Complexity = O(N^2)
//Spcae Complexity = O(2*N)


//Approach 2: Optimal Approach using concept of finding maximum height of a bianry tree.

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        getHeight(root, res);
        return res.get(0);
        // return maximum;
    }
    
    public int getHeight(TreeNode node, List<Integer> maxi) {
        if(node == null) return 0;
        int left = getHeight(node.left, maxi);
        int right = getHeight(node.right, maxi);
        maxi.set(0, Math.max(maxi.get(0), left + right));
        return 1 + Math.max(left, right);
    }
}

//Time Complexity = O(N)
//Spcae Complexity = O(N)
