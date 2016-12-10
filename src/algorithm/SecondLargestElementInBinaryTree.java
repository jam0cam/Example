package algorithm;

/**
 *
 * Write a function to find the 2nd largest element in a binary search tree
 *
 * Created by Jia on 12/4/16.
 */
public class SecondLargestElementInBinaryTree {

    public static void main(String[] args) {


        test1();
        test2();
        test3();
        test4();
        test5();
    }



    public static void test5() {
        BinaryTreeNode four = new BinaryTreeNode(4);
        BinaryTreeNode eight = new BinaryTreeNode(8);
        BinaryTreeNode six = new BinaryTreeNode(6);

        four.right = eight;
        eight.left = six;

        System.out.println(solve(four));     //answer is 6;
    }

    public static void test4() {
        BinaryTreeNode four = new BinaryTreeNode(4);
        BinaryTreeNode eight = new BinaryTreeNode(8);
        BinaryTreeNode six = new BinaryTreeNode(6);
        BinaryTreeNode seven = new BinaryTreeNode(7);

        four.right = eight;
        eight.left = six;
        six.right = seven;

        System.out.println(solve(four));     //answer is 7;
    }


    public static void test3() {
        BinaryTreeNode six = new BinaryTreeNode(6);
        BinaryTreeNode five = new BinaryTreeNode(5);
        BinaryTreeNode four = new BinaryTreeNode(4);

        six.left = five;
        five.left = four;

        System.out.println(solve(six));     //answer is 5;
    }

    public static void test2() {

        BinaryTreeNode six = new BinaryTreeNode(6);
        BinaryTreeNode three = new BinaryTreeNode(3);
        BinaryTreeNode four = new BinaryTreeNode(4);
        BinaryTreeNode five = new BinaryTreeNode(5);

        six.left = three;
        three.right = four;
        four.right = five;

        System.out.println(solve(six));     //answer is 5;
    }

    public static void test1() {
        BinaryTreeNode four = new BinaryTreeNode(4);
        BinaryTreeNode six = new BinaryTreeNode(6);
        BinaryTreeNode seven = new BinaryTreeNode(7);

        four.right = six;
        six.right = seven;

        System.out.println(solve(four));        //should be six
    }

    public static BinaryTreeNode solve(BinaryTreeNode head) {
        if (head == null) {
            return null;        //there are no items, no solution
        }

        if (head.left == null && head.right == null) {
            return null;        //just one element, so no such thing as second largest
        }

        if (head.right == null) {
            //we already know left is not null, so the largest element on the left subtree is the 2nd largest
            //element in the entire tree.
            return findLargest(head.left);
        } else {
            //the second largest from head
            return find2ndLargest(head);
        }
    }

    private static BinaryTreeNode find2ndLargest(BinaryTreeNode head) {
        BinaryTreeNode previous = null;

        //we know that the first right iteration is not null
        while (head.right != null) {
            previous = head;
            head = head.right;
        }

        //head at this point is the largest element.
        if (head.left != null) {
            return findLargest(head.left);
        } else {
            //head is the largest, and it has no children, so parent must be second largest
            return previous;
        }
    }


    /**
     * We know that the largest element is always in the right most subtree (if such a subtree exists)
     * @param head
     * @return
     */
    private static BinaryTreeNode findLargest(BinaryTreeNode head) {
        if (head == null) {
            return null;
        }

        if (head.right == null) {
            return head;
        } else {
            while (head.right != null) {
                head = head.right;
            }

            return head;
        }
    }

    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

}
