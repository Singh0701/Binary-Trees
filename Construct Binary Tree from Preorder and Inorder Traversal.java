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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    } 
    
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inMap = map.get(root.val);
        int numsLeft = inMap - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inMap - 1, map);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inMap + 1, inEnd, map);
        return root;
    }
}

//test case
//pre = [10,20,40,50,30,60]
//in = [40,20,50,10,60,30]
//n = 6
// inMap = [10 -> 3, 20 -> 1, 40 -> 0, 50 -> 2, 30 -> 5, 60 -> 4]
//root.val = 10
//inRoot = inMap(10) -> 3 , numsLeft = inRoot - inStart = 3 - 0 = 3
//buildTree(pre, 0 + 1, 0 + 3, in, 0, 3 - 1, inMap) for left
//preStart = 1, preEnd = 3, inStart = 0, inEnd = 2
//buildTree(pre, 0 + 3 + 1, 5, in, 3 + 1, 5, inMap) for right
//preStart = 4, preEnd = 5, inStart = 4, inEnd = 5
//...........and so on



