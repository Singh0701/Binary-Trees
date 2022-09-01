//Approach 1: Recursive Approach.

class Solution {
    TreeNode prev = null;
    //Right -> Left -> Root Traversal.
    public void flatten(TreeNode root) {
        //base case.
        if(root == null) return;
        //Keep going right.
        flatten(root.right);
        //Then keep going left.
        flatten(root.left);
        //When both left and right are null, do make below changes and make prev pointing to root.
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

//Time complexity = O(N)
//Space complexity = O(N) Aux

//Approach 2: Using Stack.

class Solution {
    public void flatten(TreeNode root) {
        //Return if the tree is empty.
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        //Push the root into the stack.
        stack.push(root);
        while(!stack.isEmpty()) {
            //Pop out the top element.
            TreeNode curr = stack.pop();
            //If it's right is not null then push into the stack.
            if(curr.right != null) stack.push(curr.right);
            //If it's left is not null then push it into the stack.
            if(curr.left != null) stack.push(curr.left);
            //Now check if the stack is empty or not, if not then make the current node's right pointer points to stack top. 
            if(!stack.isEmpty()) curr.right = stack.peek();
            //Make the curr's left null.
            curr.left = null;
        }
    }
}

//Time complexity = O(N)
//Space complexity = O(N)

//Approach 3: Using Morris Traversal technique.

class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while(curr != null) {
            //If curr has left then take it's rightmost node and make it point to the curr's right subtree's root.
            if(curr.left != null) {
                //Take a pointer to curr's left.
                TreeNode prev = curr.left;
                //while prev's right is not null keep moving the pointer to it's right, and this will eventually give us the rightmost node of the current subTree.
                while(prev.right != null) {
                    prev = prev.right;
                }
                //make prev's right to curr's right.
                prev.right = curr.right;
                //curr's right will point to curr's left.
                curr.right = curr.left;
                //make the curr's left equal to null.
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}

//Time complexity = O(N)
//Space complexity = O(1)
