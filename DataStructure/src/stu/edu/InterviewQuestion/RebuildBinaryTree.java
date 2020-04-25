package stu.edu.InterviewQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Admin
 * 重建二叉树
 * 根据二叉树的前序遍历序列和中序遍历序列来实现重建二叉树
 */
public class RebuildBinaryTree {

    public static BinaryTree rebuildBinaryTree(int[] pre, int[] in) {
        if(pre.length != in.length) {
            throw new IllegalArgumentException("参数错误");
        }
        if(pre == null || in == null) {
            return null;
        }
        if(pre.length == 0 || in.length == 0) {
            return null;
        }
        BinaryTree root = new BinaryTree(pre[0]);
        for(int i=0; i<in.length; i++) {
            if(root.data == in[i]) {
                // 找到了根节点 0~i-1为左子树 i+1~in.length 为右子树
                root.left = rebuildBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                root.right = rebuildBinaryTree(Arrays.copyOfRange(pre,i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        BinaryTree root =  rebuildBinaryTree(pre,in);
        System.out.println(root);
    }


    static class BinaryTree {

        int data;

        BinaryTree left;

        BinaryTree right;

        public BinaryTree(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            List<Integer> preResult = new ArrayList<>();
            BinaryTree root = this;
            preResult = preOrder(preResult, root);

            List<Integer> inResult = new ArrayList<>();
            inResult = inOrder(inResult, root);
            return Arrays.toString(preResult.toArray()) + " " + Arrays.toString(inResult.toArray());
        }

        /**
         * 前序遍历
         * @param root
         * @return
         */
        public List<Integer> preOrder(List<Integer> result ,BinaryTree root) {
            if(root == null) {
                return result;
            }
            result.add(root.data);
            result = preOrder(result, root.left);
            result = preOrder(result, root.right);
            return result;
        }

        /**
         * 中序遍历
         * @param root
         * @return
         */
        public List<Integer> inOrder(List<Integer> result ,BinaryTree root) {
            if(root == null) {
                return result;
            }
            result = inOrder(result, root.left);
            result.add(root.data);
            result = inOrder(result, root.right);
            return result;
        }
    }

}
