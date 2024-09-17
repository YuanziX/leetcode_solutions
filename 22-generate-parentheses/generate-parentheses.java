class CurrentBracketState {
    String data = "";
    int numOpen;
    int numClosed;

    public CurrentBracketState(String state, int o, int c) {
        data = state;
        numOpen = o;
        numClosed = c;
    }
}

class Tree {
    TreeNode root;

    public Tree() {
        this.root = new TreeNode(new CurrentBracketState("(", 1, 0));
    }

    public void collectLeaf(TreeNode node, List<String> result) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            result.add(node.val.data);
        }

        collectLeaf(node.left, result);
        collectLeaf(node.right, result);
    }

}

class TreeNode {
    CurrentBracketState val;
    TreeNode left;
    TreeNode right;

    public TreeNode(CurrentBracketState val) {
        this.val = val;
    }
}

public class Solution {
    public List<String> generateParenthesis(int n) {
        Tree t = new Tree();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(t.root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            if (temp.val.numOpen < n) {
                TreeNode left = new TreeNode(
                        new CurrentBracketState(temp.val.data + "(", temp.val.numOpen + 1, temp.val.numClosed));
                temp.left = left;
                q.add(left);
            }
            TreeNode right = new TreeNode(
                    new CurrentBracketState(temp.val.data + ")", temp.val.numOpen, temp.val.numClosed + 1));
            if (temp.val.numOpen > temp.val.numClosed) {
                temp.right = right;
                q.add(right);
            }
        }

        List<String> result = new ArrayList<String>();
        t.collectLeaf(t.root, result);
        return result;
    }
}
