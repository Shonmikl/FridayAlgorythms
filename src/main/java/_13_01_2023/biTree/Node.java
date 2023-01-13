package _13_01_2023.biTree;


public class Node {
    public Integer value;
    public Node left;
    public Node right;

    private static boolean isNodeExist(Node node) {
        return node != null && node.value != null;
    }

    private static void createNode(Node node, int value) {
        node.left = new Node();
        node.right = new Node();
        node.value = value;
    }

    private static void insert(Node node, int value) {
        if(!isNodeExist(node)) {
            createNode(node, value);
        } else if(value < node.value) {
            insert(node.left, value);
        } else if(value > node.value) {
            insert(node.right, value);
        }
    }

    private static Node search(Node node, int value) {
        if(!isNodeExist(node)) {
            return null;
        }
        if(node.value == value) {
            return node;
        }
        if(value < node.value) {
            return search(node.left, value);
        }
        return search(node.right, value);
    }

    private static Node getMin(Node node) {
        if(!isNodeExist(node)) {
            return null;
        }
        if (!isNodeExist(node.left)) {
            return node;
        }
        return getMin(node.left);
    }

    private static Node getMax(Node node) {
        return null;
    }

    private static void inOrderTraversal(Node node) {
        if(!isNodeExist(node)) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println("[ " + node.value + " ]");
        inOrderTraversal(node.right);
    }

    private static void postOrderTraversal(Node node) {
    }

    private static void directOrderTraversal(Node node) {
    }

    private static void moveNode(Node toNode, Node fromNode) {
    }

    private static int getChildrenCount(Node node) {
        return 0;
    }

    private static Node getChildOrNull(Node node) {
        return null;
    }

    private static void removeNodeWithOneOrZeroChild(Node nodeToDelete) {
    }

    private static boolean remove(Node root, int value) {
        return true;
    }

    @Override
    public String toString() {
        return "Node:" +
                "value=" + value;
    }

    public static void main(String[] args) {
        //todo
        Integer[] digit = {9, 9, 9, 2, 5, 13, 6, 10, 14, 7, 33, 44, 3};
        Node node = new Node();
        createNode(node, 9);
        for (int i = 1; i < digit.length; i++) {
            insert(node, digit[i]);
        }
        inOrderTraversal(node);
        System.out.println(getMin(node));

//        remove(node, 10);
//        System.out.println();
//        inOrderTraversal(node);
    }
}