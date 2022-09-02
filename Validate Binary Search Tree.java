//Approach 1: Using inorder and an ArrayList.

class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();
        inorder(root, inorder);
        for(int i = 0; i < inorder.size() - 1; i++) {
            if(inorder.get(i) >= inorder.get(i + 1)) return false;
        }
        return true;
    }
    
    public void inorder(TreeNode node, List<Integer> in) {
        if(node == null) return;
        inorder(node.left, in);
        in.add(node.val);
        inorder(node.right, in);
    }
}

//Approach 2: Recursively without using an ArrayList.

class Solution {
    public boolean isValidBST(TreeNode root) {
        return inorder(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean inorder(TreeNode node, long low, long high) {
        if(node == null) return true;
        if(node.val <= low || node.val >= high) return false;
        return inorder(node.left, low, node.val) && inorder(node.right, node.val, high);
    }
}
