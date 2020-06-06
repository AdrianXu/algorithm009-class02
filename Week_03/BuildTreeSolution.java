/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BuildTreeSolution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end){
        if(p_start == p_end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[p_start]);
        int i_root_index = i_start;
        while(inorder[i_root_index] != preorder[p_start])i_root_index++;
        int leftNum = i_root_index - i_start;
        root.left = buildTreeHelper(preorder, p_start+1, p_start 
        +leftNum+1, inorder, i_start, i_root_index);
        root.right = buildTreeHelper(preorder, p_start+leftNum+1, p_end, inorder, i_root_index+1, i_end);
        return root;
    }
}