// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as //descendants (where we allow a node to be a descendant of itself).”


//Solution:

//Approach 1:  Using Root to node path technique.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        getPath(root, p, path1);
        getPath(root, q, path2);
        int min = Math.min(path1.size(), path2.size());
        if(min == 1) return path1.get(0);
        int i = 0, j = 0;
        while(i < path1.size() || j < path2.size()) {
            if(i < path1.size() && j < path2.size()) {
                if(path1.get(i).val != path2.get(j).val) return path1.get(i - 1);
            }
            if(i >= path1.size()) return path2.get(j - 1);
            if(j >= path2.size()) return path2.get(i - 1);
            i++;
            j++;
        }
        return null;
    }
    
    public boolean getPath(TreeNode root, TreeNode dest, List<TreeNode> path) {
        if(root == null) return false;
        path.add(root);
        if(root.val == dest.val) return true;
        
        if(getPath(root.left, dest, path) || getPath(root.right, dest, path)) 
            return true;
        
        path.remove(path.size() - 1);
        return false;
    }
}


//Time complexity = O(N + N)
//Space complexity = O(N + N)


//Approach 2: Using DFS.

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Base case.
        if(root == null || root == p || root == q) 
            return root;
      
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        //Result.
        if(left == null) return right;
        if(right == null) return left;
        else return root;
    }
}

//Time complexity = O(N)
//Space complexity = O(N)
