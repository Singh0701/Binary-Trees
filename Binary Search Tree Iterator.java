//Approach 1: Naive approach, Store the inorder traversal in a Data structure and then return next and hasNext value using the same.

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
class BSTIterator {
    List<Integer> inorder;
    int index;
    
    public void inorder(TreeNode node, List<Integer> inorder) {
        if(node == null) return;
        inorder(node.left, inorder);
        inorder.add(node.val);
        inorder(node.right, inorder);
    }
    
    public BSTIterator(TreeNode root) {
        inorder = new ArrayList<>();
        inorder(root, inorder);
        index = 0;
    }
    
    public int next() {
        return inorder.get(index++);
    }
    
    public boolean hasNext() {
        return index < inorder.size();
    }
}

//Time complexity = O(N) 
//Space complexity = O(N) + O(N) -> Recursive stack space.


//Approach 2: Using stack, we psuh all the nodes in betweem from root to the left most node and return the top node when next() call is made and while poping out the top element, do the same process for it's right subTree, that is check if the right is not null then again push right subTree's root and all of it's left most nodes.

class BSTIterator {
    
    Stack<TreeNode> inorder;    
    //Utility function to insert all the nodes in from given root and the left most node.
    public void insertIntoStack(TreeNode root) {
        while(root != null) {
            inorder.push(root);
            root = root.left;
        }
    }
    
    //Insert root to left at first.
    public BSTIterator(TreeNode root) {
        inorder = new Stack<>();
        insertIntoStack(root);
    }
    
    //Pop out the top node and call insertIntoStack function for it's right Sub Tree.
    public int next() {
        TreeNode next = inorder.pop();
        insertIntoStack(next.right);
        return next.val;
    }
    
    //If stack is empty return false else return true.
    public boolean hasNext() {
        return !inorder.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


//Time complexity = O(1) 
//Space complexity = O(H) -> At most we'll be stroing the H no. of nodes that is the height of the tree.

