package common.datastructure.list;

import org.w3c.dom.Node;

/**
 * 静态链表
 * @author 高勇01
 * @date 2021/1/27 16:45
 */
public class StaticLinkedList {
    private Node[] elements;

    public StaticLinkedList(Node[] elements) {
        this.elements = elements;
    }

    /**
     * 初始化链表空间。
     * 空间的空间连在一起
     */
    public void init() {
        for (int i = 0; i < elements.length-1; i++) {
            elements[i].cur = i + 1;
        }
    }

    public void visit() {
        Node last = elements[elements.length-1];
        while (last.cur != -1) {
            System.out.println(elements[last.cur].value);
            last = elements[last.cur];
        }
    }


    public void add(Integer value) {
        Integer cur = elements[0].cur;
        elements[0].cur = elements[cur].cur;
        elements[cur].value = value;
        elements[elements.length-1].cur = cur;
    }

    public void delete(int index) {
        elements[index-1].cur = index+1;
    }


    private static class Node {
        private Integer value;
        private Integer cur;


        public Node(Integer value) {
            this.value = value;
            this.cur = -1;
        }
    }

    public static void main(String[] args) {
        StaticLinkedList list = new StaticLinkedList(new Node[]{new Node(null), new Node(null), new Node(null), new Node(null), new Node(null)});
        list.init();
        list.add(1);
        list.add(2);
        list.add(3);
        list.visit();
    }

}
