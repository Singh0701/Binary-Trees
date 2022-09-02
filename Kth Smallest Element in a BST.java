//Inorder traversal with storing the all nodes in a list.

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        List<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);
        return inorder.get(k - 1);
    }
    
    public void inorder(TreeNode node, List<Integer> list) {
        if(node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}

//Time complexity = O(N)
//Space complexity = O(N)

//Better approach, with O(1) space complexity.

class Solution {
    int counter = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        int[] kth = new int[1];
        inorder(root, kth, k);
        return kth[0];
    }
    
    public void inorder(TreeNode node, int[] list, int k) {
        if(node == null) return;
        inorder(node.left, list, k);
        counter++;
        if(k == counter) {
            list[0] = node.val;
        }
        inorder(node.right, list, k);
    }
}

//Time complexity = O(K)
//Space complexity = O(1)
