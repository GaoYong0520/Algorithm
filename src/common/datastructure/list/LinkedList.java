package common.datastructure.list;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 高勇01
 * @date 2021/1/25 18:16
 */
public class LinkedList {
    private ListNode head;

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.init();
        linkedList.add(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))));
        linkedList.visit();
        ListNode listNode = linkedList.theLastNthNode(5);
        // linkedList.reverse();
        // linkedList.visit();
        // linkedList.destroy();
        // linkedList.visit();

        // Node node = linkedList.theNthNode(7);
        System.out.println(listNode.value);
    }

    public void init() {
        head = new ListNode(0, null);
    }

    public void visit() {
        ListNode head = this.head;
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
            ListNode pre = null;
            ListNode temp;
            while (head != null) {
                temp = head.next;
                head.next = pre;
                pre = head;
                head = temp;
            }
            this.head = pre;
        }
    }

    public void add(ListNode listNode) {
        ListNode head = this.head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = listNode;
    }

    public void destroy() {
        ListNode temp;
        while (head != null) {
            temp = head.next;
            head.next = null;
            head = temp;
        }
        this.head = null;
    }

    public ListNode theNthNode(int n) {
        ListNode head = this.head;
        int index = 1;
        while (head != null && index < n) {
            head = head.next;
            index++;
        }
        return head;
    }

    public ListNode theLastNthNode(int n) {
        ListNode head = this.head;
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

        ListNode temp = head;
        head = this.head;
        while (temp != null) {
            temp = temp.next;
            head = head.next;
        }
        return head;
    }

    /**
     * 141-环形链表
     * Hash表
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        Set<ListNode> set = new HashSet<>();

        ListNode n = head;
        while (n != null) {
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
            n = n.next;
        }

        return false;
    }

    /**
     * 141-环形链表1
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null) return false;

        ListNode l = head,r = head.next;

        // 注意判断条件
        while (l != null && r != null && r.next != null) {
            if (l == r) {
                return true;
            }
            l = l.next;
            r = r.next.next;
        }

        return false;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        Set<ListNode> set = new HashSet<>();

        ListNode n = head;
        while (n != null) {
            if (set.contains(n)) {
                return n;
            }
            set.add(n);
            n = n.next;
        }

        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null && fast.next != null) {
            System.out.print("slow=" + slow.value + ";");
            System.out.println("fast=" + fast.value);
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;

        }

        return null;
    }



}
