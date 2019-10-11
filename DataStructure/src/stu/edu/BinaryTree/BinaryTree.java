package stu.edu.BinaryTree;

import java.util.*;

public class BinaryTree<K extends Comparable<K>,V> {

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            //结点默认添加为叶子结点，故高度为1
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    public BinaryTree() {
        root = null;
        size = 0;
    }

    //获取二叉树树中结点个数
    public int getSize() {
        return size;
    }

    //判空
    public boolean isEmpty() {
        return size == 0;
    }

    //获得结点的高度
    public int getHeight(Node node) {
        if(node == null){
            return 0;
        }
        return node.height;
    }

//    //判断以node为根的树是否平衡
//    //平衡因子为-1、0、1代表该树平衡
//    public boolean isBalance(Node node) {
//        int balanceFactor = getBalanceFactor(node);
//        if(Math.abs(balanceFactor) > 1){
//            return false;
//        }
//        return isBalance(node.left) && isBalance(node.right);
//    }

//    //获取node为根的树的平衡因子
//    private int getBalanceFactor(Node node) {
//        int l = getHeight(node.left);
//        int r = getHeight(node.right);
//        return l - r;
//    }

    //先序遍历,将遍历的结点上的value保存在List中
    public List<V> preOrder() {
        List<Node> nodeList = new LinkedList<>();
        List<V> valueList = new LinkedList<>();
        preOrder2(root,nodeList);
        for(Node node : nodeList) {
            valueList.add(node.value);
        }
        return valueList;
    }
    private void preOrder(Node node, List<Node> nodeList) {
        if(node == null) {
            return;
        }
        nodeList.add(node);
        preOrder(node.left, nodeList);
        preOrder(node.right, nodeList);
    }
    //借用栈实现非递归先序遍历
    private void preOrder2(Node node, List<Node> nodeList) {
        Stack<Node> stack = new Stack<>();
        while(node != null || !stack.isEmpty()) {
            if(node != null) {
                //访问该结点并入栈
                nodeList.add(node);
                stack.push(node);
                //访问其左子树
                node = node.left;
            }else{
                //左子树为null或右子树为null，将栈顶元素出栈
                node = stack.pop();
                //访问栈顶元素右子树
                node = node.right;
            }
        }
    }



    //中序遍历，将遍历的结点保存在List中
    public List<V> inOrder() {
        List<V> valueList = new LinkedList<>();
        List<Node> nodeList = new LinkedList<>();
        inOrder2(root, nodeList);
        for(Node node : nodeList) {
            valueList.add(node.value);
        }
        return valueList;
    }
    private void inOrder(Node node, List<Node> nodeList) {
        if(node == null) {
            return;
        }
        inOrder(node.left, nodeList);
        nodeList.add(node);
        inOrder(node.right, nodeList);
    }
    //非递归方式实现中序遍历
    private void inOrder2(Node node,List<Node> nodeList) {
        Stack<Node> stack = new Stack<>();
        while(node != null || stack.size()!=0) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                nodeList.add(node);
                node = node.right;
            }
        }
    }

    //后序遍历,将遍历的结点保存在List中
    public List<V> postOrder() {
        List<V> valueList = new LinkedList<>();
        List<Node> nodeList = new LinkedList<>();
        postOrder2(root, nodeList);
        for(Node node : nodeList) {
            valueList.add(node.value);
        }
        return valueList;
    }
    private void postOrder(Node node, List<Node> nodeList) {
        if(node == null){
            return;
        }
        postOrder(node.left, nodeList);
        postOrder(node.right, nodeList);
        nodeList.add(node);
    }
    //后序遍历的非递归实现
    public void postOrder2(Node node, List<Node> nodeList) {
        Stack<Node> stack = new Stack<>();
        Node prev = root; //记录前面访问过的一个结点
        while(node != null || stack.size()!=0) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            }else {
                node = stack.peek().right;
                //没有右子树或之前访问过
                if(node == null || node == prev) {
                    node = stack.pop();
                    nodeList.add(node);
                    prev = node;
                    node = null;
                }
            }
        }
    }

    //层序遍历,,将遍历的结点保存在List中
    public List<V> levelOrder() {
        List<V> valueList  = new LinkedList<>();
        List<Node> nodeList = new LinkedList<>();
        levelOrder(root, nodeList);
        for(Node node : nodeList) {
            valueList.add(node.value);
        }
        return valueList;
    }
    private void levelOrder(Node node, List<Node> nodeList) {
        Queue<Node> nodes = new ArrayDeque<>();
        while(node != null) {
            nodeList.add(node);
            if(node.left != null){
                nodes.add(node.left);

            }
            if(node.right != null){
                nodes.add(node.right);
            }
            //队列的头部元素出队
            if(nodes.size() > 0){
                node = nodes.remove();
            }else{
                node = null;
            }
        }
    }

    //在以node为根的树上寻找key的结点
    private Node findNode(Node node, K key) {
        if(node == null){
            return null;
        }
        if(node.key.compareTo(key) == 0) {
            return node;
        }else if(node.key.compareTo(key) > 0) {
            return findNode(node.left, key);
        }else{
            return findNode(node.right, key);
        }
    }

    //是否包含某个键值
    public boolean contains(K key) {
        return findNode(root, key) != null;
    }

    //获取key的结点的value
    public V get(K key) {
        Node node = findNode(root, key);
        if(node != null){
            return node.value;
        }
        return null;
    }

    //是否包含某个V

    public boolean containsValue(V value) {
        List<V> valueList = inOrder();
        for(V v : valueList) {
            if(v.equals(value)) {
                return true;
            }
        }
        return false;
    }

    //获取以node为根，key为键的树上的结点
    private Node getNode(Node node, K key) {
        return findNode(node, key);
    }

    //设置key的结点的值
    public void set(K key, V value) {
        Node node = findNode(root, key);
        if(node != null) {
            node.value = value;
        }else{
            throw new IllegalStateException("Node doesn't exist.");
        }
    }

    //找到以node为根结点的树上的最大结点
    private Node findMax(Node node) {
        if(node == null) {
            return null;
        }
        while(node.right != null) {
            node = node.right;
        }
        return node;
    }

    //找到以node为根结点的树上的最小结点
    private Node findMin(Node node) {
        if(node == null){
            return null;
        }
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    //删除以node为根的树上的最小结点,返回该树的根结点
    public Node removeMin(Node node){
        if(node.left == null) {
            //此时node为最小结点
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //添加结点
    public void add(K key, V value) {
        root = add(root, key, value);
    }
    private Node add(Node node, K key, V value) {
        if(node == null) { //找到了合适的位置，直接添加
            node = new Node(key,value);
            size ++;
            //维护结点的高度
            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
        if(node.key.compareTo(key) > 0) {
            //比当前根结点小，递归添加到其左子树上
            node.left = add(node.left, key, value);
        }else if(node.key.compareTo(key) < 0){
            //比当前结点大，递归添加到其右子树上
            node.right = add(node.right, key, value);
        }else {
            node.value = value;
        }
        return node;
    }


    //删除指定的结点
    public V remove(K key) {
        Node node = getNode(root, key);
        if(node != null) {
            return node.value;
        }
        return null;
    }
    private Node remove(Node node, K key) {
        if(node == null) {
            return null;
        }
        if(node.key.compareTo(key) > 0) {
            node.left = remove(node.left, key);
            return node;
        }else if(node.key.compareTo(key) < 0) {
            node.right = remove(node.right, key);
            return node;
        }else { //找到了要删除的结点
            if(node.left == null) { //没有左孩子或者没有孩子结点
                Node rightNode = node.right;
                size --;
                node.right = null;
                return rightNode;
            }else if(node.right == null) { //没有右孩子
                Node leftNode = node.left;
                size --;
                node.left = null;
                return leftNode;
            }else {
                Node successor = findMin(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;
                return successor;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer,Integer> binaryTree = new BinaryTree<>();
        Random random = new Random();
        Integer[] keys = new Integer[10];
        for(int i=0;i<10;i++){
            keys[i] = random.nextInt(25);
            binaryTree.add(keys[i],random.nextInt(100));
        }

        List<Integer> list = binaryTree.levelOrder();
        for(Integer i : list) {
            System.out.print(i+" ");
        }
    }
}
