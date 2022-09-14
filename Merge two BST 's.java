class Solution
{
    class BSTIterator {
    
        Stack<Node> inorder;    
        //Utility function to insert all the nodes in from given root and the left most node.
        public void insertIntoStack(Node root) {
            while(root != null) {
                inorder.push(root);
                root = root.left;
            }
        }
        
        //Insert root to left at first.
        public BSTIterator(Node root) {
            inorder = new Stack<>();
            insertIntoStack(root);
        }
        
        //Pop out the top node and call insertIntoStack function for it's right Sub Tree.
        public int next() {
            Node next = inorder.pop();
            insertIntoStack(next.right);
            return next.data;
        }
        
        public int peek() {
            return inorder.peek().data;
        }
        
        //If stack is empty return false else return true.
        public boolean hasNext() {
            return !inorder.isEmpty();
        }
    }

    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        BSTIterator t1 = new BSTIterator(root1);
        BSTIterator t2 = new BSTIterator(root2);
        List<Integer> merge = new ArrayList<>();
        while(t1.hasNext() && t2.hasNext()) {
            if(t1.peek() < t2.peek()) {
                merge.add(t1.next());
            } else merge.add(t2.next());
        }
        while(t1.hasNext()) {
            merge.add(t1.next());
        }
        while(t2.hasNext()) {
            merge.add(t2.next());
        }
        return merge;
    }
}
