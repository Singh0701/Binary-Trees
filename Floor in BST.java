public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        int floor = -1;
        while(root != null) {
            if(root.data == X) return X;
            if(root.data < X) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }
}
