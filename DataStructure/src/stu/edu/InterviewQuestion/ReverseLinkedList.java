package stu.edu.InterviewQuestion;

import java.util.Stack;

/**
 * @author Admin
 * 反转链表
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        Node target = createNode(nums);
        System.out.println(target);
        Node result = reverseLinkedListRecursive(target);
        System.out.println(result);
    }

    /**
     * 递归实现
     * @param node
     * @return
     */
    public static Node reverseLinkedListRecursive(Node node) {
        if(node ==  null) {
            return null;
        }else if(node.next == null){
            return node;
        }else {
            Node result = reverseLinkedListRecursive(node.next);
            node.next.next = node;
            node.next = null;
            return result;
        }
    }

    /**
     * 反转链表 基于栈实现
     * @param head
     * @return
     */
    public static Node reverseLinkedList(Node head) {
        Stack<Node> stack = new Stack<>();
        if(head == null) {
            return null;
        }
        while (head != null) {
            Node cur = new Node(head.val);
            stack.push(cur);
            head = head.next;
        }

        Node result = stack.pop();
        Node cur = result;
        while (!stack.empty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        return result;
    }

    public static Node createNode(int[] nums) {
        Node head = new Node(nums[0]);
        Node temp = head;
        for (int i = 1; i < nums.length; i++) {
            temp.next = new Node(nums[i]);
            temp = temp.next;
        }
        return head;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node head = this;
            if(head == null) {
                return "";
            }
            while (head.next != null) {
                sb.append(head.val + " => ");
                head = head.next;
            }
            sb.append(head.val);
            return sb.toString();
        }
    }

}
