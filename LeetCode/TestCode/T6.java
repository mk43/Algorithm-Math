package testCode;

import java.util.ArrayList;
import java.util.Stack;

public class T6 {

    public static final void main(String args[]) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(null);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.print(postorderTraversal(root).size());
    }

    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (null == root) {
            return new ArrayList<Integer>();
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode currentNode = root;
        boolean hasChildNode = false;
        while (true) {
            if (null != currentNode && Integer.MAX_VALUE != currentNode.val) {
                stack.push(currentNode);
            }
            if (null != currentNode.right && Integer.MAX_VALUE != currentNode.right.val) {
                stack.push(currentNode.right);
                hasChildNode = true;
            }
            if (null != currentNode.left && Integer.MAX_VALUE != currentNode.left.val) {
                stack.push(currentNode.left);
                hasChildNode = true;
            }
            if (hasChildNode) {
                currentNode = stack.pop();
                if (0 == stack.size()) {
                    result.add(currentNode.val);
                    return result;
                }
                hasChildNode = false;
            } else {
                result.add(currentNode.val);
                stack.pop();
                currentNode.val = Integer.MAX_VALUE;
                if (0 == stack.size()) {
                    return result;
                }
                currentNode = stack.pop();
            }
        }
    }

    public ArrayList<Integer> postorderTraversal1(TreeNode root) {
        if (null == root) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> left = postorderTraversal(root.left);
        ArrayList<Integer> right = postorderTraversal(root.right);
        ArrayList<Integer> result = new ArrayList<>();
        if (0 < left.size()) {
            result.addAll(left);
        }
        if (0 < right.size()) {
            result.addAll(right);
        }
        result.add(root.val);
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
