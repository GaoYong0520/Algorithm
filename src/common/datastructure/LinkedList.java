package common.datastructure;

/**
 * @author 高勇01
 * @date 2021/1/25 18:16
 */
public class LinkedList {
    private Node head;

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.init();
        linkedList.add(new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null))))));
        linkedList.visit();
        Node node = linkedList.theLastNthNode(5);
        // linkedList.reverse();
        // linkedList.visit();
        // linkedList.destroy();
        // linkedList.visit();

        // Node node = linkedList.theNthNode(7);
        System.out.println(node.value);
    }

    public void init() {
        head = new Node(0, null);
    }

    public void visit() {
        Node head = this.head;
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            if (head.next != null) {
                sb.append(head.value).append("->");
            } else {
                sb.append(head.value);
            }
            head = head.next;
        }
        System.out.println(sb.toString());
    }

    public void reverse() {
        if (head == null ) {
            return;
        } else {
            Node pre = null;
            Node temp;
            while (head != null) {
                temp = head.next;
                head.next = pre;
                pre = head;
                head = temp;
            }
            this.head = pre;
        }
    }

    public void add(Node node) {
        Node head = this.head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = node;
    }

    public void destroy() {
        Node temp;
        while (head != null) {
            temp = head.next;
            head.next = null;
            head = temp;
        }
        this.head = null;
    }

    public Node theNthNode(int n) {
        Node head = this.head;
        int index = 1;
        while (head != null && index < n) {
            head = head.next;
            index++;
        }
        return head;
    }

    public Node theLastNthNode(int n) {
        Node head = this.head;
        if (n == 0) return head;
        int index = 0;
        while (head != null && index < n) {
            head = head.next;
            index++;
        }

        // 注意此处临界情况
        if (head == null && index == n-1)  {
            return null;
        }

        Node temp = head;
        head = this.head;
        while (temp != null) {
            temp = temp.next;
            head = head.next;
        }
        return head;
    }

}
