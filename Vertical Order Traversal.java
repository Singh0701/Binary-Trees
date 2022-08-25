Problem Statement: Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
Example 2:


Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.


 //Solution:
 
 //Approach 1: Using Level Order Traversal.

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
    class Node {
        TreeNode node;
        int row;
        int col;
        Node(TreeNode n, int v, int l) {
            node = n;
            row = v;
            col = l;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(new Node(root, 0, 0));
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if(!map.containsKey(curr.row))
                map.put(curr.row, new TreeMap<>());
            if(!map.get(curr.row).containsKey(curr.col))
                map.get(curr.row).put(curr.col, new PriorityQueue<>());
            map.get(curr.row).get(curr.col).add(curr.node.val);
            if(curr.node.left != null) {
                queue.add(new Node(curr.node.left, curr.row - 1, curr.col + 1));
            }
            if(curr.node.right != null) {
                queue.add(new Node(curr.node.right, curr.row + 1, curr.col + 1));
            }
        }
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}

//Time Complexity = O(N * Log(N))
//Space Complexity = O(N) + O(N)



//Approach 2: Using inorder traversal.



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
    class Node {
        TreeNode node;
        int row;
        int col;
        Node(TreeNode n, int v, int l) {
            node = n;
            row = v;
            col = l;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(new Node(root, 0, 0));
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        inorder(new Node(root, 0, 0), map);
        
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
    
    
    public void inorder(Node root, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if(root.node == null) return;
        if(!map.containsKey(root.row))
                map.put(root.row, new TreeMap<>());
        if(!map.get(root.row).containsKey(root.col))
                map.get(root.row).put(root.col, new PriorityQueue<>());
        map.get(root.row).get(root.col).add(root.node.val);
        if(root.node.left != null) {
            inorder(new Node(root.node.left, root.row - 1, root.col + 1),  map);
        }
        if(root.node.right != null) {
            inorder(new Node(root.node.right, root.row + 1, root.col + 1), map);
        }
    }
}


//Time Complexity = O(N * Log(N))
//Space Complexity = O(N) + O(N)

