package algoexpert.easy;

public class FindClosestValueInBst {

/*    public static int findClosestValueInBstSolutionOne(BST tree, int target) {

        int nearestValue = tree.value;

        while (tree.left != null || tree.right != null) {

            int targetMinusNearestValue = Math.abs(target - nearestValue);

            if (tree.left != null && (Math.abs((target - tree.left.value)) < targetMinusNearestValue)) {
                tree = tree.left;
                nearestValue = tree.value;
            } else if (tree.right != null) {
                if (Math.abs((target - tree.right.value)) < targetMinusNearestValue) {
                    tree = tree.right;
                    nearestValue = tree.value;
                } else if (tree.right.value > nearestValue) {
                    tree = tree.right;
                }
            }
        }

        return nearestValue;
    }*/

/*    public static int findClosestValueInBstSolutionTwo(BST tree, int target) {

        int nearestValue = tree.value;

        while (tree.left != null || tree.right != null) {

            int difference = Math.abs(target - nearestValue);

            if (tree.left != null && (tree.left.value - target) > 0) {
                if ((tree.left.value - target) < difference) {
                    nearestValue = tree.left.value;
                }

                tree = tree.left;
            } else if (tree.right != null && (tree.right.value - target) > 0) {
                if ((tree.right.value - target) < difference) {
                    nearestValue = tree.right.value;
                }
                tree = tree.right;
            }

        }

        return nearestValue;
    }*/


    public static int findClosestValueInBstSolutionOne(BST tree, int target) {

        int nearestValue = 1000000000;

        while (tree != null) {

            int bestDifferenceToTarget = Math.abs(nearestValue - target);

            if (Math.abs(tree.value - target) < bestDifferenceToTarget) {
                nearestValue = tree.value;
            }

            if (tree.value < target) {
                tree = tree.right;
            } else {
                tree = tree.left;
            }

        }

        return nearestValue;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        BST bst1 = new BST(1);
        BST bst2 = new BST(2);
        bst2.left = bst1;
        BST bst5_1 = new BST(5);
        BST bst5_2 = new BST(5);
        bst5_2.left = bst2;
        bst5_2.right = bst5_1;

        BST bst14 = new BST(14);
        BST bst13 = new BST(13);
        bst13.right = bst14;
        BST bst22 = new BST(22);
        BST bst15 = new BST(15);
        bst15.left = bst13;
        bst15.right = bst22;

        BST bstTop = new BST(10);
        bstTop.left = bst5_2;
        bstTop.right = bst15;

        System.out.println(findClosestValueInBstSolutionOne(bstTop, 12));

    }

}
