Problem Statement: Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).


Solution:

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        //If Binary Tree is empty then return the result.
        if(root == null) return result;
        //Initialize the queue with root node.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            //Take the size of current level.
            int k = queue.size();
            List<Integer> subList = new ArrayList<>();
            //Pop out the current level's elements, that is the first k elements, and along with that add the next level (children) nodes into the queue. 
            while(k-- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                subList.add(node.val);
            }
            result.add(subList);
        }
        return result;
    }
}


//Time Complexity = O(N)
//Space Complexity = O(N)
//Space for using an external queue.
 
