// Problem Statement: Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

//        1
//     /     \
//    2       3
//   /  \    /   \
// 4    5  6   7

// Top view will be: 4 2 1 3 7
// Note: Return nodes from leftmost node to rightmost node.

//Solution: 



import java.util.*;

//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    static class Pair {
        Node node;
        int line;
        Pair(Node _node, int _line) {
            node = _node;
            line = _line;
        }
    }
    
    
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        //Starting with 0th line.
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            //If the current node is the first one in the top view of it's line, means it's not already in TreeMap then add it.
            if(!map.containsKey(curr.line)) {
                map.put(curr.line, curr.node.data);
            }
          
            //If current node has left then put it in the queue with line - 1.
            if(curr.node.left != null) {
                queue.add(new Pair(curr.node.left, curr.line - 1));
            }
            //If current node has right then put it in the queue with line + 1.
            if(curr.node.right != null) {
                queue.add(new Pair(curr.node.right, curr.line + 1));
            }
        }
        //Store all the Map values into the ArrayList and return.
        for(int key: map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}

//Time Complexity = O(N + N)
//Space Complexity = O(N + N)
