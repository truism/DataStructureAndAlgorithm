package stu.edu.InterviewQuestion;

import java.util.Arrays;
import java.util.Objects;

/**
 * 题目描述：
 * 合并两个有序链表，要求同时使用递归和非递归法实现
 */
public class MergeLinkedList {

  public static void main(String[] args) {
    int[] nums1 = {0,1,3,5,7,9,11};
    int[] nums2 = {2,4,6,8,10};

    Node result = mergeLinkedList2(createListNode(nums1),createListNode(nums2));
    System.out.println(result);
  }

  private static class Node<Integer> {
    int val;
    Node next;

    public Node() {
    }

    public Node(int val) {
      this.val = val;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      Node head = this;
      while (head.next != null) {
        sb.append(head.val + " -> ");
        head = head.next;
      }
      sb.append(head.val);
      return sb.toString();
    }
  }

  /**
   * 负责构建有序链表
   * @param nums
   * @return
   */
  public static Node createListNode(int[] nums) {
    Arrays.sort(nums);
    Node<Integer> head = new Node<>(nums[0]);
    Node listNode = head;
    for (int i = 1; i < nums.length; i++) {
      head.next = new Node(nums[i]);
      head = head.next;
    }
    return listNode;
  }

  /**
   * 递归法实现合并有序链表
   * @param head1
   * @param head2
   * @return
   */
    public static Node mergeLinkedList(Node head1, Node head2) {
      // 首先考虑递归结束条件
      if(head1 == null && head2 == null) {
        return null;
      }
      if(Objects.isNull(head1)) {
        return head2;
      }
      if(Objects.isNull(head2)) {
        return head1;
      }
      Node head = head1.val < head2.val ? head1 : head2;
      if(head == head1) {
        head.next = mergeLinkedList(head1.next, head2);
      }else {
        head.next = mergeLinkedList(head1, head2.next);
      }
      return head;
    }

    /**
     * 非递归式实现合并链表
     * @param head1
     * @param head2
     * @return
     */
    public static Node mergeLinkedList2(Node head1, Node head2) {
      if(Objects.isNull(head1)) {
        return head2;
      }
      if(Objects.isNull(head2)) {
        return head1;
      }

      Node head = head1.val < head2.val ? head1 : head2;

      Node prev = head;
      Node cur1 = head.next;
      Node cur2 = head == head1 ? head2 : head1;
      Node next = cur2.next;

      while (!Objects.isNull(cur1) && !Objects.isNull(cur2)) {
        if(cur1.val < cur2.val) {
          prev = cur1;
          cur1 = cur1.next;
        }else {
          prev.next = cur2;
          cur2.next = cur1;
          prev = cur2;
          cur2 = next;
          if(cur2 != null) {
            next = cur2.next;
          }
        }
      }
      prev.next = cur1 == null ? cur2 :cur1;
      return head;
    }
}
