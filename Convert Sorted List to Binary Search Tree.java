//Problem: Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST. For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


//Approach: Divide and Conquer, First we convert the given linked list into a arraylist or array for easier operations and then we call a build tree function. what it does is pick the middle element of the sorted list (The balance point for all  subTree's and root itself) after picking the middle element we divide the sorted list into two halfs and then again do the same operation.

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        return buildTree(list, 0, list.size() - 1);
    }
    
    public TreeNode buildTree(List<Integer> list, int low, int high) {
        if(low > high) return null;
        int mid = ((low + high) % 2 == 0) ? (low + high) / 2 : (low + high + 1) / 2;
        
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildTree(list, low, mid - 1);
        root.right = buildTree(list, mid + 1, high);
        
        return root;
    }
}


//Time complexity = O(N) + (Log(N))
//Space complexity = O(N)
