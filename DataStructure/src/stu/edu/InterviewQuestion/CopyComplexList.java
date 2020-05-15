package stu.edu.InterviewQuestion;

public class CopyComplexList {

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.range = new Node(3);
    Node res = copyNode(head);
    System.out.println(res);
    System.out.println(res.rangeString());
  }

  public static Node copyNode(Node pHead) {
    if(pHead == null) {
      return null;
    }
    Node head = new Node(pHead.data);
    Node temp = head;
    while (pHead.next != null) {
      temp.next = new Node(pHead.next.data);
      if(pHead.range != null) {
        temp.range = new Node(pHead.range.data);
      }
      pHead = pHead.next;
      temp = temp.next;
    }
    return head;

  }


  // 复杂链表类
  static class Node {
    int data;
    Node next;
    Node range;

    public Node() {
    }

    public Node(int data) {
      this.data = data;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      Node head = this;
      sb.append(head.data);
      while (head.next != null) {
        head = head.next;
        sb.append("->").append(head.data);
      }
      return sb.toString();
    }

    public String rangeString() {
      StringBuilder sb = new StringBuilder();
      Node head = this;
      sb.append(head.data);
      while (head.range != null) {
        head = head.range;
        sb.append("->").append(head.data);
      }
      return sb.toString();
    }
  }

}
