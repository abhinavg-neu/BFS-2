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
    //Space Complexity: O(H)
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();
            TreeNode rightnode = null;
            for (int i = 0;i < len;i++){
                 TreeNode node = q.poll();
                if (node != null){
                    rightnode = node;
                    q.offer(rightnode.left);
                    q.offer(rightnode.right);
                }
            }
             if (rightnode != null){
                res.add(rightnode.val);
                }
        }
        return res;
    }
}