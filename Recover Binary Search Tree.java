//Approach 1: Store the traversal of the tree and sort it to get the inorder and now perform inorder by filling in correct values for each node.

class Solution {
    public void recoverTree(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);
        Collections.sort(inorder);
        int[] index = new int[1];
        recoverBST(root, index, inorder);
    }
    
    public void recoverBST(TreeNode root, int[] index, List<Integer> in) {
        if(root == null) return;
        recoverBST(root.left, index, in);
        root.val = in.get(index[0]++);
        recoverBST(root.right, index, in);
    }
    
    public void inorder(TreeNode root, List<Integer> in) {
        if(root == null) return;
        inorder(root.left, in);
        in.add(root.val);
        inorder(root.right, in);
    }
}

//Time complexity = O(2*N) + O(N * Log(N))
//Space complexity = O(N)


//Approach 2: Keep track of previous initially as INT_MIN VALUE and the nodes that doesn't follow the BST ordering while doing the inorder traversal and then at the end swap the two nodes (either adjacent or different ones).


class Solution {
    
    TreeNode first = null;
    TreeNode middle = null;
    TreeNode last = null;
    TreeNode prev = null;
    
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if(first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
    
    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev != null && root.val < prev.val) {
            if(first == null) {
                first = prev;
                middle = root;
            } else last = root;
        }
        prev = root;
        inorder(root.right);
    }
}

//Time complexity = O(N)
//Space complexity = O(1)
