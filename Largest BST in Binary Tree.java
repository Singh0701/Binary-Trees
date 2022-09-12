//Problem:  Given a BT, find the largest BST in it and return the size (Size is the no. of nodes).

//Approach 1: Brute force, basically for each node we check if it is a valid BST then we compute it's size and then update the maxSize variable.

class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        int[] count = new int[1];
        if(validBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, count)) return count[0];
        return Math.max(largestBst(root.left), largestBst(root.right));
    }
    
    static boolean validBST(Node root, int min, int max, int[] count) {
        if(root == null) return true;
        if(root.data <= min || root.data >= max) return false;
        //Computing the size on the way with validating the BST.
        count[0]++;
        return (validBST(root.left, min, root.data, count) && validBST(root.right, root.data, max, count));
    }
}

//Time complexity = O(N^2)
//Space complexity = O(H)


//Approach 2: Optimal approach, Keeping track of the range and size.


class Solution{
    static class NodeValue {
        int min, max, size;
        NodeValue(int size, int min, int max) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        return largestBST(root).size;
    }
    
    static NodeValue largestBST(Node root) {
        if(root == null) {
            return new NodeValue(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        NodeValue left = largestBST(root.left);
        NodeValue right = largestBST(root.right);
        
        if(left.max < root.data && root.data < right.min) {
            //It is a dataid BST.
            return new NodeValue(left.size + right.size + 1, Math.min(left.min, root.data), Math.max(right.max, root.data));
        }
        //else return a node with -INF and INF as max and min dataues.
        return new NodeValue(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

//Time complexity = O(N)
//Space complexity = O(H)
