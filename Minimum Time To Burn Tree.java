You-have-been-given-a-binary-tree-of-n-unique-nodes-and-a-start-node-from-where-the-tree-will-start-to-burn-given-that-the-start-node-will-always-exist-in-the-tree-your-task-is-to-print-the-time-in-minutes-that-it-will-take-to-burn-the-whole-tree">You have been given a binary tree of 'N' unique nodes and a Start node from where the tree will start to burn. Given that the Start node will always exist in the tree, your task is to print the time (in minutes) that it will take to burn the whole tree.
  
  
/**********************************************************	
	
	Following is the representation of Binary Tree Node:
 	
 	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}

*********************************************************/
import java.util.*;
public class Solution {
    public static BinaryTreeNode<Integer> getParents(Map<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>> parents, int start, BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        BinaryTreeNode<Integer> s = null;
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryTreeNode<Integer> curr = queue.poll();
            if(curr.data == start) s = curr;
            if(curr.left != null) {
                queue.add(curr.left);
                parents.put(curr.left, curr);
            }
            if(curr.right != null) {
                queue.add(curr.right);
                parents.put(curr.right, curr);
            }
        }
        return s;
    }
    
    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int s) {
        Map<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>> parents = new HashMap<>();
        BinaryTreeNode<Integer> start = getParents(parents, s, root);
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        Set<BinaryTreeNode<Integer>> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        int time = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                BinaryTreeNode<Integer> curr = queue.poll();
                if(curr.left != null && !visited.contains(curr.left)) {
                    queue.add(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right)) {
                    queue.add(curr.right);
                    visited.add(curr.right);
                }
                if(parents.get(curr) != null && !visited.contains(parents.get(curr))) {                                       queue.add(parents.get(curr));
                    visited.add(parents.get(curr));
                }
            }
            time++;
        }
        return time;
    }
}

// Time complexity = O(N)
//Space complexity = O(N)
