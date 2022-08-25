// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// Example 1:

// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]

// Example 2:

// Input: root = [1,null,3]
// Output: [1,3]

// Example 3:

// Input: root = []
// Output: []



//Solution:

//Approach 1: Using Level order traversal.

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode curr = queue.poll();
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
                if(size == 0) result.add(curr.val);
            }
        }
        return result;
    }
}


//Time complexity = O(N)
//Space complexity = O(N)


//Approach 2: Recursive approach using a modified varient of pre-order traversal (that is ROOT -> RIGHT -> LEFT).


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        preorder(root, 0, result);
        return result;
    }
    
    public void preorder(TreeNode root, int level, List<Integer> result) {
        if(root == null) return;
        if(result.size() == level) result.add(root.val);
        preorder(root.right, level + 1, result);
        preorder(root.left, level + 1, result);
    }
}

//Time complexity = O(N)
//Space complexity = O(H)
//H -> Height of the tree.
