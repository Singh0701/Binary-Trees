//Approach 1: Using Map.

class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        inorder(root, map);
        int max = 0;
        for(int i: map.values())
            max = Math.max(max, i);
        int size = 0;
        for(int i: map.keySet()) {
            if(map.get(i) == max) size++;
        }
        int[] mode = new int[size];
        int index = 0;
        for(int i: map.keySet()) {
            if(map.get(i) == max) mode[index++] = i;
        }
        return mode;
    }
    
    public void inorder(TreeNode root, Map<Integer, Integer> map) {
        if(root == null) return;
        inorder(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        inorder(root.right, map);
    }
}

//Time complexity = O(N + N + N)
//Space complexity = O(N)


//Approach 2: Using Inorder traversal.

class Solution {
    int max = -1;
    int count = 1;
    TreeNode prev = null;
    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        inorder(root, modes);
        int[] mode = new int[modes.size()];
        int index = 0;
        for(int i: modes) {
            mode[index++] = i;
        }
        return mode;
    }
    
    public void inorder(TreeNode root, List<Integer> modes) {
        if(root == null) return;
        inorder(root.left, modes);
        if(prev != null) {
            if(prev.val == root.val)
                count++;
            else count = 1;
        }
        if(count > max) {
            max = count;
            modes.clear();
            modes.add(root.val);
        } else if(count == max) modes.add(root.val);
        prev = root;
        inorder(root.right, modes);
    }
}

//Time complexity = O(N)
//Space complexity = O(H)
