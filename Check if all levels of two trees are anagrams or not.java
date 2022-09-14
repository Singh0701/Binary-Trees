class Solution {
    public static boolean areAnagrams(Node root1, Node root2) {
        // List<Set<Integer>> levels = new ArrayList<>();
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue1.add(root1);
        queue2.add(root2);
        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            int size1 = queue1.size();
            int size2 = queue2.size();
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            while(size1-- > 0 && size2-- > 0) {
                Node node1 = queue1.poll();
                Node node2 = queue2.poll();
                
                if(node1.left != null) queue1.add(node1.left);
                if(node1.right != null) queue1.add(node1.right);
                
                if(node2.left != null) queue2.add(node2.left);
                if(node2.right != null) queue2.add(node2.right);
                set1.add(node1.data);
                set2.add(node2.data);
            }
            if(!set1.containsAll(set2)) return false;
        }
        return true;
    }
}
