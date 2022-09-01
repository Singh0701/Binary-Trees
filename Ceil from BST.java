import java.util.*;
public class Solution {

    public static int findCeil(TreeNode<Integer> root, int x) {
        int ceil = -1;
        while(root != null) {
            //If a node is present with value exactly equal to the ceil then return it.
            if(root.data == x) return x;
            //else, check if key value is greater than current node then move to the right subTree.
            if(root.data < x) 
                root = root.right;
            //else, go to the left Sub tree and as the current node's value is less than key, store it's value into the ceil.
            else {
                ceil = root.data;
                root = root.left;
            }
        }
        //return ceil.
        return ceil;
    }
}

//Time complexity = O(N)
//Space complexity = O(1)
