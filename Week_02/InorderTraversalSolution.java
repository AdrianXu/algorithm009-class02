
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

class InorderTraversalSolution {
    //List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.empty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            curr = node.right;
        }
        // inorderTraversal(root.left);
        // list.add(root.val);
        // inorderTraversal(root.right);
        return list;
    }
}