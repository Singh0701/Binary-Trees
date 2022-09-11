Problem Statement: Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
  
//Approach 1: Save the inorder and then perform two pointer search.
  
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        //Two pointer search.
        int low = 0, high = inorder.size() - 1;
        while(low < high) {
            if(inorder.get(low) + inorder.get(high) == k) return true;
            else if(inorder.get(low) + inorder.get(high) < k) low++;
            else high--;
        }
        return false;
    }
    
    public void getInorder(TreeNode root, List<Integer> inorder) {
        if(root == null) return;
        getInorder(root.left, inorder);
        inorder.add(root.val);
        getInorder(root.right, inorder);
    }
}

//Time complexity = O(N + N)
//Space complexity = O(N)



//Approach 2: Start with any traversal and for each node we call a binary search function on the root of the tree which will find if the other node exists in the tree which sums upt to the target sum k.



class Solution {
    public boolean findTarget(TreeNode root, int k) {
        boolean[] flag = new boolean[1];
        getInorder(root, root, flag, k);
        return flag[0];
    }
    
    public void getInorder(TreeNode node, TreeNode root, boolean[] flag, int target) {
        if(node == null) return;
        getInorder(node.left, root, flag, target);
        if(bst(root, target - node.val, node)) {
            flag[0] = true;
            return;
        }
        getInorder(node.right, root, flag, target);
    }
    
    public boolean bst(TreeNode root, int target, TreeNode root1) {
        if(root == null) return false;
        if(root1.val != root.val && root.val == target) return true;
        if(root.val < target) {
            if(bst(root.right, target, root1)) return true;
        } else if(root.val > target) {
            if(bst(root.left, target, root1)) return true;
        }
        return false;
    }
}


//Time complexity = O(N * Log(N))
//Space complexity = O(1) Ignoring the Stack space for recursion, although it would be O(H) in worst case (assuming BST is balanced and has Log(N) height.
