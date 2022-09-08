//Aproach 1: Store the inorder and then perform binary search to find value next to the given val.

class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x)
    {
        List<Node> inorder = new ArrayList<>();
        //Get the inorder.
        inorder(root, inorder);
        int low = 0, high = inorder.size() - 1;
        int middle = 0;
        //Perform binary search to compute the value.
        while(low <= high) {
            middle = low + (high - low) / 2;
            if(inorder.get(middle).data == x.data) break;
            if(inorder.get(middle).data < x.data) low = middle + 1;
            else high = middle - 1;
        }
        return (middle == inorder.size() - 1) ? null : inorder.get(middle + 1);
    }
    
    public void inorder(Node root, List<Node> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}

//Time complexity = O(N) + O(Log(N))
//Space complexity = O(N)


//Aproach 2: While doing the inorder and find value next to the given val and return.

class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x)
    {
        Node[] prev = new Node[1];
        inorder(root, null, prev, x);
        return prev[0];
    }
    
    public void inorder(Node root, Node prev, Node[] ans, Node x) {
        if(root == null) return;
        inorder(root.left, prev, ans, x);
        if(root.data > x.data) {
            prev = root;
            ans[0] = prev;
            x.data = Integer.MAX_VALUE;
            return;
        } 
        inorder(root.right, root, ans, x);
    }
}

//Time complexity = O(N)
//Space complexity = O(N)



//Aproach 3: Best Approach, Do a binary search by keeping track of a next possible successor.


class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x)
    {
        Node successor = null;
        while(root != null) {
            if(root.data > x.data) {
                successor = root;
                root = root.left;
            }
            else {
                root = root.right;    
            } 
        }
        return successor;
    }
}

//Time complexity = O(N)
//Space complexity = O(N)
