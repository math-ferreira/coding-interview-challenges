package algoexpert.easy;

import java.util.HashSet;
import java.util.Set;

public class EvaluateExpressionTree {

    public static int evaluateExpressionTreeSolutionOne(BinaryTree tree) {

        Set<String> table = new HashSet<>();
        calculateExpression(tree, tree, table, tree);

        return calculateCurrentNode(tree);
    }


    public static void calculateExpression(BinaryTree tree, BinaryTree lastNode, Set<String> table, BinaryTree root) {

        if (tree.left != null) {
            calculateExpression(tree.left, tree, table, root);
        }
        if (tree.right != null) {
            calculateExpression(tree.right, tree, table, root);
        }

        if (tree.left == null && tree.right == null) {
            String key = String.valueOf(lastNode.left.value) + lastNode.right.value;
            if (!table.contains(key)) {
                table.add(key);
                if (!lastNode.equals(root)) {
                    lastNode.value = calculateCurrentNode(lastNode);
                }
            }
        }
    }

    public static int calculateCurrentNode(BinaryTree node) {
        int calculation;
        if (node.left == null) return node.value;

        switch (node.value) {
            case -1:
                calculation = node.left.value + node.right.value;
                break;
            case -2:
                calculation = node.left.value - node.right.value;
                break;
            case -3:
                calculation = node.left.value / node.right.value;
                break;
            default:
                calculation = node.left.value * node.right.value;
                break;
        }
        return calculation;
    }

    public static int evaluateExpressionTreeSolutionTwo(BinaryTree tree) {

        BinaryTree lastNodeTree = new BinaryTree(tree.value);

        calculateExpressionTwo(tree, lastNodeTree);

        return calculateCurrentNode(tree);
    }

    public static void calculateExpressionTwo(BinaryTree tree, BinaryTree lastNode) {

        if (tree.left != null && tree.right != null) {
            lastNode = tree;
        }

        if (tree.left != null) {
            calculateExpressionTwo(tree.left, lastNode);
        }
        if (tree.right != null) {
            calculateExpressionTwo(tree.right, lastNode);
        }

        if (tree.left == null) {
            if (tree == lastNode.left || tree == lastNode.right) {
                lastNode.value = calculateCurrentNode(lastNode);
                lastNode.left = null;
                lastNode.right = null;
            }

        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

/*        BinaryTree bst_2_2 = new BinaryTree(2);
        BinaryTree bst_3_1 = new BinaryTree(3);
        BinaryTree bst_minus4 = new BinaryTree(-4);
        bst_minus4.left = bst_2_2;
        bst_minus4.right = bst_3_1;
        BinaryTree bst_2_1 = new BinaryTree(2);

        BinaryTree bst_minus2 = new BinaryTree(-2);
        bst_minus2.left = bst_minus4;
        bst_minus2.right = bst_2_1;

        BinaryTree bst_8 = new BinaryTree(8);
        BinaryTree bst_3_2 = new BinaryTree(3);
        BinaryTree bst_minus3 = new BinaryTree(-3);
        bst_minus3.left = bst_8;
        bst_minus3.right = bst_3_2;

        BinaryTree root = new BinaryTree(-1);
        root.left = bst_minus2;
        root.right = bst_minus3;*/

        BinaryTree bst_2 = new BinaryTree(2);
        BinaryTree bst_3 = new BinaryTree(3);

        BinaryTree root = new BinaryTree(-2);
        root.left = bst_2;
        root.right = bst_3;


        System.out.println(evaluateExpressionTreeSolutionTwo(root));

    }

}
