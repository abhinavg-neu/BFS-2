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
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    boolean areCousins = false;
    public boolean isCousins(TreeNode root, int x, int y) {
       if (root == null) {
        return false;
       }
       Queue<TreeNode> q = new LinkedList<>();
       q.add (root);
       boolean x_found = false;
       boolean y_found = false;
       while (!q.isEmpty()){

        int len = q.size ();
        for (int i = 0; i < len ;i++){
            TreeNode curr = q.poll();
            if (curr.left != null && curr.right != null){
                if (curr.left.val == x && curr.right.val == y || curr.left.val == y && curr.right.val ==x){
                    return false;
                }
            }
                if (curr.val == x) x_found = true;
                if (curr.val == y) y_found = true;

                if (curr.left != null)
                  q.offer (curr.left);
                if (curr.right != null)
                  q.offer (curr.right);
       }
        if ((x_found == true && y_found == false) || (x_found == false && y_found == true)){
                    return false;
                }
                  if ((x_found == true && y_found == true) ){
                    return true;
                  }
   
    }

    return false;
    }
}

// dfs solution

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
    int xLevel = -1;
    int yLevel = -2;
    public boolean isCousins(TreeNode root, int x, int y) {

       dfs (root, 0, x, y); 
       return xLevel == yLevel;
    }
    
    public void dfs (TreeNode node,int level, int x, int y){
        if (node == null) return;

        if (node.left != null && node.right != null){
            if ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x))
            return;
        }    
        if (node.val == x)
            xLevel = level;
            if (node.val == y)
            yLevel = level;
            
        dfs (node.left, level+1, x, y);
        dfs (node.right, level+1, x, y);

    }
}