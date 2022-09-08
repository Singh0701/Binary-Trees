class GfG
{
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
        Node temp = root;
        while(temp != null) {
            if(temp.data > key) {
                s.succ = temp;
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        temp = root;
        while(temp != null) {
            if(temp.data < key) {
                p.pre = temp;
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
    }
}


//Time Complexity = O(Log(N))
//Space Complexity = O(1)
