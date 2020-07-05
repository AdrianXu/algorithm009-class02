// Definition for a Node.
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

class LevelOrderSolution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root != null){
            order(root, 0);
        }
        return list;
    }
    void order(Node node, int level){
        if(list.size() == level){
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(node.val);
        for(Node n: node.children){
            order(n, level+1);
        }
    }
}