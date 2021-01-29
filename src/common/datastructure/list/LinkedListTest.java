package common.datastructure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    @org.junit.jupiter.api.Test
    void hasCycle() {
        LinkedList list = new LinkedList();

        ListNode node = new ListNode(3, null);
        ListNode node1 = new ListNode(2, null);
        ListNode node2 = new ListNode(0, null);
        ListNode node3 = new ListNode(-4, null);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        Assertions.assertTrue(list.hasCycle(node));
    }


    @Test
    void detectCycle2() {
        LinkedList list = new LinkedList();
        ListNode node = new ListNode(3, null);
        ListNode node1 = new ListNode(2, null);
        ListNode node2 = new ListNode(0, null);
        ListNode node3 = new ListNode(-4, null);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        Assertions.assertEquals(node1, list.detectCycle2(node));
    }
}