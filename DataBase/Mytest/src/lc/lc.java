package src.lc;

import java.util.List;

/**
 * @author panda
 * @description:
 * @date 2021/3/5 14:17
 */

    class ListNode {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        System.out.println(reverseList(l1));

    }
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        //头插法

        public static ListNode reverseList(ListNode head) {
            ListNode newHead=null;//新链表头节点
            while(head!=null){
                ListNode mid=head;
                head=head.next;
                mid.next =newHead;
                newHead=mid;

            }
            return newHead;
        }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}







