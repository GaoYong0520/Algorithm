package tree;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int value;
    public List<Node> children;

    public Node(int value) {

        this.value = value;
        this.children = new ArrayList<>();
    }
}
