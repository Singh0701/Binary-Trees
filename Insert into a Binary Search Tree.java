//Iterative Approach.

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //if given root is null then just create and return a new node
        if(root == null) return new TreeNode(val);
        TreeNode temp = root;
        //Node to be inserted.
        TreeNode insert = new TreeNode(val);
        while(temp != null) {
            //If current node's val is less than val means we have to put it into the right subTree.
            if(temp.val < val) {
                //if right is null then attach the node
                if(temp.right == null) {
                    temp.right = insert;
                    break;
                }
                //else move to the right right subTree.
                else temp = temp.right;
            } else {
              //Else check in the left Sub Tree. and insert if null, else move.
                if(temp.left == null) {
                    temp.left = insert;
                    break;
                }
                else temp = temp.left;
            }
        }
      //return the root.
        return root;
    }
}

//Time complexity = O(N)
//Space complexity = O(N)


