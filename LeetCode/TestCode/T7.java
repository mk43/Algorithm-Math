package testCode;

import java.util.ArrayList;
import java.util.Stack;

public class T7 {


    public static final void main(String args[]) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(null);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.print(preorderTraversal(root).size());
    }


    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (null == root) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode currentNode;
        while (0 != stack.size()) {
            currentNode = stack.pop();
            result.add(currentNode.val);
            if (null != currentNode.right) {
                stack.push(currentNode.right);
            }
            if (null != currentNode.left) {
                stack.push(currentNode.left);
            }
        }
        return result;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
