package stu.edu.InterviewQuestion;

public class DelListNode {

  public static void main(String[] args) {

  }

  public static ListNode delListNode(ListNode head, ListNode targetNode) {
    if(head == null) {
      return null;
    }
    if(targetNode == null) {
      return head;
    }
    if(targetNode == head) {
      ListNode newHead = head.next;
      head = null;
      return newHead;
    }
    if(targetNode.next == null) {
      ListNode point = head;
      while (point.next.next != null) {
        point = point.next;
      }
      point.next = null;
    }else {
      targetNode.data = targetNode.next.data;
      targetNode.next = targetNode.next.next;
    }
    return head;
  }

  static class ListNode<T> {
    T data;
    ListNode next;
  }
}
