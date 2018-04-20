package tree;

import java.util.*;

public class Tree {
    Node root;

    public Tree() {
        root = new Node(5);
        Node n1 = new Node(4);
        Node n2 = new Node(14);
        Node n3 = new Node(40);
        Node n4 = new Node(2);
        Node n5 = new Node(4);
        Node n6 = new Node(100);
        root.children.add(n1);
        root.children.add(n2);

        root.children.get(0).children.add(n3);
        root.children.get(0).children.add(n4);
        root.children.get(1).children.add(n5);
        root.children.get(1).children.get(0).children.add(n6);
    }
    public static int  getMaxValue(Node root) {
        int maxValue = root.value;
        ArrayDeque<Node> first = new ArrayDeque<>();
        ArrayDeque<Node> second = new ArrayDeque<>();
        int count = 0;
        for (Node node :
                root.children) {
            second.push(node);
        }

        int level = 2;
        while (!second.isEmpty()) {
            for (Node node :
                    second) {
                first.add(node);
                System.out.print(level + "-" + node.value + " ");
            }
            System.out.println();
            second.clear();
            while (!first.isEmpty()) {
                Node node = first.pop();
                count += node.value;
                for (Node temp :
                        node.children) {
                    second.push(temp);
                }
            }
            if (maxValue < count) {
                maxValue = count;
            }
            count = 0;
            level++;
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        int result = getMaxValue(tree.root);
        System.out.println(result);
    }
}
