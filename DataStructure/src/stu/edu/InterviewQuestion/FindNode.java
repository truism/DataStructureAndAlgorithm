package stu.edu.InterviewQuestion;

/**
 * 查找链表倒数第k个节点
 */
public class FindNode {

  public static void main(String[] args) {
    ListNode list = createListNode(new int[]{1,2,3,4});
    System.out.println(findNodeIndexOfK(list,3).data);
  }

  public static ListNode findNodeIndexOfK(ListNode head, int k) {
    if(head == null) {
      throw new IllegalArgumentException("Head can't be null.");
    }
    ListNode fast = head;
    ListNode slow = head;
    for (int i = 0; i < k; i++) {
      fast = fast.next;
      if(fast == null) {
        throw new IllegalArgumentException("The index " + k + "has longer than ListNode.");
      }
    }
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }

  static class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
      this.data = data;
    }


  }

  public static ListNode createListNode(int[] nums) {
    ListNode head = new ListNode(nums[0]);
    ListNode cur = head;
    for (int i = 1; i < nums.length; i++) {
      cur.next = new ListNode(nums[i]);
      cur = cur.next;
    }
    return head;
  }



}
