package stu.edu.InterviewQuestion;

import stu.edu.BinaryTree.BinaryTree;

/**
 * 判断一个二叉树是否包含一个子二叉树
 */
public class ContainsSubTree {

  public static void main(String[] args) {
    Tree source = new Tree(10);
    source.left = new Tree(8);
    source.right = new Tree(11);
    System.out.println(hasSubTree(source,source));
  }

  public static boolean hasSubTree(Tree source, Tree target) {
    if(source == null || target == null) {
      return false;
    }
    if(dose2TreeEqual(source,target)) {
      return true;
    }
    return hasSubTree(source.left, target) || hasSubTree(source.right, target);
  }

  public static  boolean dose2TreeEqual(Tree source, Tree target) {
    if(target == null && source == null) {
      return true;
    }
    if(target == null || source == null) {
      return false;
    }
    if(target.data != source.data) {
      return false;
    }
    return dose2TreeEqual(source.left, target.left) && dose2TreeEqual(source.right, target.right);
  }

  static class Tree {
    int data;
    Tree left;
    Tree right;

    public Tree(int data) {
      this.data = data;
    }
  }

}
