package algoexpert.easy;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {

    public static List<Integer> branchSumsSolutionOne(BinaryTree root) {

        BinaryTree lastTwoWays = new BinaryTree(Integer.MAX_VALUE);
        List<Integer> sums = new ArrayList<>();

        BinaryTree rootCompleted = root;

        while (rootCompleted != null) {

            if (rootCompleted.left == lastTwoWays) {
                rootCompleted = rootCompleted.right;
            } else {
                if (rootCompleted.left != null && rootCompleted.right != null) {
                    rootCompleted = rootCompleted.left;
                } else {
                    lastTwoWays = rootCompleted;
                    rootCompleted = root;
                }

            }

        }

        return new ArrayList<Integer>();
    }

    public static List<Integer> branchSumsSolutionTwo(BinaryTree root) {

        List<Integer> branchesSum = new ArrayList<>();
        sumBranch(root, 0, branchesSum);

        return branchesSum;
    }

    public static void sumBranch(BinaryTree tree, int sum, List<Integer> branchSumList) {
        if (tree == null) {
            return;
        }

        sum += tree.value;

        if (tree.left == null && tree.right == null) {
            branchSumList.add(sum);
            return;
        }
        sumBranch(tree.left, sum, branchSumList);
        sumBranch(tree.right, sum, branchSumList);
    }

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }

    public static void main(String[] args) {

        BinaryTree bst_8 = new BinaryTree(8);
        BinaryTree bst_9 = new BinaryTree(9);
        BinaryTree bst_4 = new BinaryTree(4);
        bst_4.left = bst_8;
        bst_4.right = bst_9;
        BinaryTree bst_10 = new BinaryTree(10);
        BinaryTree bst_5 = new BinaryTree(5);
        bst_5.left = bst_10;

        BinaryTree bst_2 = new BinaryTree(2);
        bst_2.left = bst_4;
        bst_2.right = bst_5;

        BinaryTree bst_6 = new BinaryTree(6);
        BinaryTree bst_7 = new BinaryTree(7);
        BinaryTree bst_3 = new BinaryTree(3);
        bst_3.left = bst_6;
        bst_3.right = bst_7;

        BinaryTree root = new BinaryTree(1);
        root.left = bst_2;
        root.right = bst_3;

        System.out.println(branchSumsSolutionTwo(root));

    }

}
