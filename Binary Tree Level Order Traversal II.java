class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levelOrder = new ArrayList<>();
        
        if(root == null) return levelOrder;
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while(size-- > 0) {
                TreeNode curr = queue.poll();
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
                level.add(curr.val);
            }
            stack.push(level);
        }
        
        while(!stack.isEmpty()) {
            levelOrder.add(stack.pop());
        }
        return levelOrder;
    }
}
