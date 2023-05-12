package algoexpert.easy;

import java.util.*;

public class NodeDepths {

    public static int nodeDepthsSolutionOne(BinaryTree root) {

        List<Integer> depths = new ArrayList<>();
        HashMap<String, Integer> binaryTreeMap = new HashMap<>();

        calculateDepths(root, -1, binaryTreeMap, depths);

        System.out.println(depths);
        System.out.println(binaryTreeMap);
        return 1;
    }

    public static void calculateDepths(BinaryTree root, int level, HashMap<String, Integer> binaryTreeMap, List<Integer> depths) {

        level++;

        String currentKey = level + String.valueOf(root.value);

        depths.add(level);

        if (root.left == null && root.right == null) {
            binaryTreeMap.put(currentKey, level);
        }

        if (root.left != null) {
            if (!binaryTreeMap.containsKey(currentKey)) {
                binaryTreeMap.put(currentKey, level);
            }
            calculateDepths(root.left, level, binaryTreeMap, depths);
        }
        if (root.right != null) {
            if (!binaryTreeMap.containsKey(currentKey)) {
                binaryTreeMap.put(currentKey, level);
            }
            calculateDepths(root.right, level, binaryTreeMap, depths);
        }
    }

    public static int nodeDepthsSolutionTwo(BinaryTree root) {

        List<Integer> depths = new ArrayList<>();

        calculateDepthsTwo(root, 0, depths);

        return depths.stream().reduce(Integer::sum).get();
    }

    public static void calculateDepthsTwo(BinaryTree root, int level, List<Integer> depths) {

        depths.add(level++);

        if (root.left != null) {
            calculateDepthsTwo(root.left, level, depths);
        }
        if (root.right != null) {
            calculateDepthsTwo(root.right, level, depths);
        }

    }

    private static int depthSum = 0;

    public static int nodeDepthsSolutionThree(BinaryTree root) {

        calculateDepthsThree(root, 0);

        return depthSum;
    }

    public static void calculateDepthsThree(BinaryTree root, int level) {

        depthSum += level;
        level++;

        if (root.left != null) {
            calculateDepthsThree(root.left, level);
        }
        if (root.right != null) {
            calculateDepthsThree(root.right, level);
        }

    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }

    }

    public static void main(String[] args) {

        BinaryTree bst_8 = new BinaryTree(8);
        BinaryTree bst_9 = new BinaryTree(9);
        BinaryTree bst_4 = new BinaryTree(4);
        bst_4.left = bst_8;
        bst_4.right = bst_9;
        BinaryTree bst_5 = new BinaryTree(5);

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

        System.out.println(nodeDepthsSolutionThree(root));

    }

}
