//Approach 1: Naive Approach, traverse through the array and keep calling the insert node function for every value.


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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        //Iterate through all the values and call insert node function for each.
        for(int i = 1; i < preorder.length; i++) {
            int val = preorder[i];
            TreeNode temp = root;
            insert(temp, val);
        }
        //Return root.
        return root;
    }
    
    public void insert(TreeNode root, int val) {
        if(root == null) return;
        if(root.val < val) {
            if(root.right == null) {
                root.right = new TreeNode(val);
            } else insert(root.right, val);
        } else {
            if(root.left == null) {
                root.left = new TreeNode(val);
            } else insert(root.left, val);
        }
    }
}

//Time complexity = O(N*N)
//Space complexity = O(N) Aux stack space.

//Approach 2: Use the recursive way to create a unique binary tree using preorder and inorder, We can get inorder by simply copying the given preorder and sort it.

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        //Create the inorder of the tree using the given preorder.
        int[] inorder = new int[n];
        for(int i = 0; i < n; i++)
            inorder[i] = preorder[i];
        //Sort to get the inorder as the BST's inorder is sorted always.
        Arrays.sort(inorder);
        
        //Creat a mapping of Element to index of inorder.
        Map<Integer, Integer> in = new HashMap<>();
        for(int i = 0; i < n; i++) {
            in.put(inorder[i], i);
        }
        //Call the construct Tree function to create Binary Tree using the preorder and inorder traversal.
        return constructBinaryTree(preorder, 0, n - 1, inorder, 0, n - 1, in);
    }
    
    public TreeNode constructBinaryTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> in) {
        //base case, return null.
        if(preStart > preEnd || inStart > inEnd) return null;
        
        //Create the root node as it'll be the first element of preorder traversal.
        TreeNode root = new TreeNode(preorder[preStart]);
        //Get the index of the root in the inorder traversal array.
        int inMap = in.get(root.val);
        //Get the total number of elements on the left of root in the inorder.
        int numLeft = inMap - inStart;
        //Call the construct Tree function for left Sub Tree, It'll return the root of left subtree.
        root.left = constructBinaryTree(preorder, preStart + 1, preEnd + numLeft, inorder, inStart, inMap - 1, in);
        //Call the construct Tree function for right Sub Tree, It'll return the root of right subtree.
        root.right = constructBinaryTree(preorder, preStart + numLeft + 1, preEnd, inorder, inMap + 1, inEnd, in);
        //Return the root at the end.
        return root;
    }
}


//Time complexity = O(N*Log(N)) + O(N + N + N) = O(N*Log(N)) Approx
//Space complexity = O(N + N + N) = O(N) Approx


//Approach 3: Optimal Approach using the range for each node fromt the problem Validate a BST.

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
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(new int[1], preorder, Integer.MAX_VALUE);
    }
    
    public TreeNode constructBST(int[] index, int[] preorder, int upperBound) {
        //IF ran out of elements or the current val is greater than than upperBound return null. 
        if(index[0] >= preorder.length || preorder[index[0]] > upperBound) return null;
        //Create root.
        TreeNode root = new TreeNode(preorder[index[0]++]);
        //Call the function for left subTree and pass the current value as upperBound for left subTree.
        root.left = constructBST(index, preorder, root.val);
        //Call the function for right subTree and pass the upperBound as it is because the right subTree can have value as big as possible, there's no bound.
        root.right = constructBST(index, preorder, upperBound);
        //Return the root.
        return root;
    }
}

//Time complexity = O(N)
//Space complexity = O(N)
