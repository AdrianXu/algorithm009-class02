class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class PreorderSolution {
    //List<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while(stack.size() != 0){
            Node node = stack.pollLast();
            list.add(node.val);
            Collections.reverse(node.children);
            for(Node n: node.children){
                stack.add(n);
            }
        }
        // if(root == null){
        //     return list;
        // }
        // list.add(root.val);
        // for(Node node: root.children){
        //     preorder(node);
        // }
        return list;
    }
}