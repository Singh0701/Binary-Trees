//Approach 1: Using a level order traversal.

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.val == val) return node;
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        return null;
    }
}


//Time complexity = O(N)
//Space complexity = O(N)

//Approach 2: Performing a binary search.

//Iterative.
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val) {
            root = (root.val < val) ? root.right : root.left;
        }
        return root;
    }
} 

//Recursive.

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) return root;
        if(root.val < val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }
}

//Time complexity = O(Log(N))
//Space complexity = O(Log(N))
