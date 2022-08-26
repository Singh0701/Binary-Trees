// Given the root of a binary tree, return the maximum width of the given tree.

// The maximum width of a tree is the maximum width among all levels.

// The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

// It is guaranteed that the answer will in the range of a 32-bit signed integer.


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
    
    class Pair {
        int index;
        TreeNode node;
        Pair(TreeNode n, int i) {
            index = i;
            node = n;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().index;
            int first = 0, last = 0;
            for(int i = 0; i < size; i++) {
                Pair n = queue.poll();
                int id = n.index;
                if(i == 0) first = id;
                if(i == size - 1) last = id;
                if(n.node.left != null) {
                    queue.add(new Pair(n.node.left, id * 2 + 1));
                }
                if(n.node.right != null) {
                    queue.add(new Pair(n.node.right, id * 2 + 2));
                }
            }
            max = Math.max(max, last - first + 1);
        }
        return max;
    }
}


//Time complexity = O(N)
//Space complexity = O(N)
