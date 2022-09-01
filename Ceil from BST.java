import java.util.*;
public class Solution {

    public static int findCeil(TreeNode<Integer> root, int x) {
        int ceil = -1;
        while(root != null) {
            if(root.data == x) return x;
            if(root.data < x) 
                root = root.right;
            else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
}

//Time complexity = O(N)
//Space complexity = O(1)
