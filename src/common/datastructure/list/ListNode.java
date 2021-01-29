package common.datastructure.list;

/**
 * @author 高勇01
 * @date 2021/1/25 18:14
 */
public class ListNode {
    public Integer value;
    public ListNode next;
    public ListNode pre;

    public ListNode(Integer value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public ListNode(Integer value, ListNode next, ListNode pre) {
        this.value = value;
        this.next = next;
        this.pre = pre;
    }
}
