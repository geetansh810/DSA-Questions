package Trees;

import java.util.*;

public class BinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node() {

        }

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {

        Node root = new Node(arr[0]);

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        int i = 1;

        while (stack.size() > 0 && i < arr.length) {

            Pair element = stack.peek();

            if (element.state == 1) {
                element.state++;

                if (arr[i] != null) {
                    element.node.left = new Node(arr[i]);
                    stack.push(new Pair(element.node.left, 1));
                }

                i++;

            } else if (element.state == 2) {
                element.state++;
                if (arr[i] != null) {
                    element.node.right = new Node(arr[i]);
                    stack.push(new Pair(element.node.right, 1));
                }
                i++;
            } else if (element.state == 3) {
                stack.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {

        if (node == null)
            return;

        String str = " <- " + node.data + " -> ";

        String left = (node.left == null) ? " ." : "" + node.left.data;

        String right = (node.right == null) ? " ." : "" + node.right.data;

        str = left + str + right;

        System.out.println(str);

        display(node.left);
        display(node.right);

    }

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int height = 0;
    static int size = 0;

    public static void multisolver(Node node, int depth) {
        if (node == null)
            return;

        max = Math.max(node.data, max);
        min = Math.min(node.data, min);
        size += 1;
        height = Math.max(depth, height);
        multisolver(node.left, depth + 1);
        multisolver(node.right, depth + 1);
    }

    public static int size(Node node) {
        if (node == null)
            return 0;

        return 1 + size(node.left) + size(node.right);
    }

    public static int sum(Node node) {
        if (node == null)
            return 0;

        return node.data + sum(node.left) + sum(node.right);
    }

    public static int max(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;

        return Math.max(node.data, Math.max(max(node.left), max(node.right)));
    }

    public static int height(Node node, int depth) {
        if (node == null)
            return -1;

        int height = -1;

        height = Math.max(height, Math.max(height(node.left, depth + 1), height(node.right, depth + 1)));

        height++;

        return height;
    }


    public static void iterativePrePostInTraversal(Node node) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(node, 1));

        String pre = "";
        String in = "";
        String post = "";

        while (stack.size() > 0) {

            Pair top = stack.peek();

            if (top.state == 1) {

                top.state++;
                pre += top.node.data + " ";

                if (top.node.left != null)
                    stack.push(new Pair(top.node.left, 1));


            } else if (top.state == 2) {

                top.state++;
                in += top.node.data + " ";

                if (top.node.right != null)
                    stack.push(new Pair(top.node.right, 1));

            } else {

                post += top.node.data + " ";
                stack.pop();

            }

        }

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);

    }

    public static boolean find(Node node, int data) {
        if (node == null)
            return false;

        if (node.data == data) {
            return true;
        }

        return find(node.left, data) || find(node.right, data);

    }


    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> path = new ArrayList<Integer>();
            path.add(node.data);
            return path;
        }

        if (node.left != null) {
            ArrayList<Integer> left = nodeToRootPath(node.left, data);
            if (left.size() > 0) {
                left.add(node.data);
                return left;
            }
        }

        if (node.right != null) {
            ArrayList<Integer> right = nodeToRootPath(node.right, data);
            if (right.size() > 0) {
                right.add(node.data);
                return right;
            }
        }

        return new ArrayList<>();
    }

    public static void printKLevelsDown(Node node, int k) {
        if (node == null)
            return;

        if (k == 0) {
            System.out.println(node.data);
            return;
        }

        printKLevelsDown(node.left, k - 1);
        printKLevelsDown(node.right, k - 1);

    }

    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi){
        // write your code here
        if(node == null)
            return;

        if(node.left == null && node.right == null){
            sum += node.data;
            if(sum >= lo && sum<=hi){
                System.out.println(path + node.data);
            }
            return;
        }

        pathToLeafFromRoot(node.left  , path + node.data + " ", sum + node.data, lo, hi);
        pathToLeafFromRoot(node.right , path + node.data + " ", sum + node.data, lo, hi);

    }

    public static void printSingleChildNodes(Node node, Node parent){
        if(node == null)
            return;

        if(parent != null){
            if((parent.left == null && parent.right != null) || (parent.left != null && parent.right == null)){
                System.out.println(node.data);
            }
        }

        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }

    public static Node removeLeaves(Node node){
        if(node == null)
            return null;

        if(node.left == null && node.right == null)
            return null;

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;
    }

    static int diameter = 0;

    public static int diameter1(Node node) {
        if(node == null)
            return -1;

        int leftHeight = diameter1(node.left);
        int rightHeight = diameter1(node.right);

        diameter = Math.max(diameter, (leftHeight+rightHeight+2));
        return Math.max(leftHeight, rightHeight)+1;
    }

    static int tilt = 0;
    public static int tilt(Node node){
        if(node == null)
            return 0;

        int leftSum = tilt(node.left);
        int rightSum = tilt(node.right);
        int totalSum = leftSum + rightSum + node.data;

        tilt += Math.abs(leftSum - rightSum);
        return totalSum;
    }


    public static class BSTPair{
        int max, min;
        boolean isBST;
    }

    public static BSTPair isBinarySearchTree(Node node){

        if(node == null){
            BSTPair temp = new BSTPair();
            temp.min = Integer.MAX_VALUE;
            temp.max = Integer.MIN_VALUE;
            temp.isBST = true;
            return temp;
        }

        BSTPair left = isBinarySearchTree(node.left);
        BSTPair right = isBinarySearchTree(node.right);

        BSTPair mid = new BSTPair();
        mid.min = Math.min(node.data, Math.min(left.min, right.min));
        mid.max = Math.max(node.data, Math.max(left.max, right.max));
        mid.isBST = left.isBST && right.isBST && (node.data > left.max) && (node.data < right.min);
        return mid;

    }

    public static boolean isBinary(Node node){
        BSTPair isBinarySearchTree = isBinarySearchTree(node);
        return isBinarySearchTree.isBST;
    }


    public static class BSTPair2{

        int max, min, size;
        boolean isBST;
        Node root;

    }

    public static BSTPair2 largetsBinarySearchTree(Node node){

        if(node == null){
            BSTPair2 temp = new BSTPair2();
            temp.min = Integer.MAX_VALUE;
            temp.max = Integer.MIN_VALUE;
            temp.isBST = true;
            temp.root = null;
            temp.size = 0;
            return temp;
        }

        BSTPair2 left = largetsBinarySearchTree(node.left);
        BSTPair2 right = largetsBinarySearchTree(node.right);

        BSTPair2 mid = new BSTPair2();
        mid.min = Math.min(node.data, Math.min(left.min, right.min));
        mid.max = Math.max(node.data, Math.max(left.max, right.max));
        mid.isBST = left.isBST && right.isBST && (node.data > left.max) && (node.data < right.min);
        if(mid.isBST){
            mid.root = node;
            mid.size = left.size + right.size + 1;
        }
        else if (left.size > right.size) {
            mid.root = left.root;
            mid.size = left.size;
        } else {
            mid.root = right.root;
            mid.size = right.size;
        }
        return mid;
    }

    public static void largetBinary(Node node){

        BSTPair2 largestBST = largetsBinarySearchTree(node);
        System.out.println(largestBST.root.data + "@" + largestBST.size);

    }

    public static class BSTPair3{
        int size;
        boolean isBalancedBST;
    }

    public static BSTPair3 balancedBinarySearchTree(Node node){

        if(node == null){
            BSTPair3 temp = new BSTPair3();
            temp.isBalancedBST = true;
            temp.size = 0;
            return temp;
        }

        BSTPair3 left = balancedBinarySearchTree(node.left);
        BSTPair3 right = balancedBinarySearchTree(node.right);

        BSTPair3 mid = new BSTPair3();
        mid.isBalancedBST = left.isBalancedBST && right.isBalancedBST && Math.abs(right.size - left.size) <= 1;
        mid.size = Math.max(left.size, right.size) + 1;
        return mid;
    }

    public static void balancedBinary(Node node){

        BSTPair3 balancedBST = balancedBinarySearchTree(node);
        System.out.println(balancedBST.isBalancedBST);

    }

    public static Node createLeftCloneTree(Node node){
        // write your code here
        if(node == null)
            return null;

        Node left = createLeftCloneTree(node.left);
        Node right = createLeftCloneTree(node.right);

        node.left = new Node(node.data, left, null);
        node.right = right;
        return node;
    }

    public static Node transBackFromLeftClonedTree(Node node) {
        if (node == null)
            return null;

        node.left = transBackFromLeftClonedTree(node.left.left);
        node.right = transBackFromLeftClonedTree(node.right);
        return node;
    }


    //==============================================================
    public static void levelOrderLineWise(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        Queue<Node> cq = new ArrayDeque<>();
        System.out.println(node.data);

        while (queue.size() > 0) {

            Node root = queue.remove();

            if(root.left != null){
                cq.add(root.left);
            }
            if(root.right != null){
                cq.add(root.right);
            }

            if(queue.size() == 0){
                queue.addAll(cq);
                while(cq.size() > 0){
                    System.out.print(cq.remove().data + " ");
                }
                System.out.println();
            }

        }
    }


    public static ArrayList <Integer> verticalOrder(Node root)
    {
        Queue<Pair> que = new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        que.add(new Pair(root, 0));

        while(que.size() > 0){
            Pair curr = que.poll();

            if(map.containsKey(curr.state)){
                map.get(curr.state).add(curr.node.data);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(curr.node.data);
                map.put(curr.state, list);
            }

            if(curr.node.left != null){
                que.add(new Pair(curr.node.left, curr.state-1));
            }

            if(curr.node.right != null){
                que.add(new Pair(curr.node.right, curr.state+1));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer> > entry : map.entrySet()){
            ans.addAll(entry.getValue());
        }

        return ans;
    }

    //**************** FIND FUNCTION ******************
    static ArrayList< Node> path2 = new ArrayList<>();
    public static boolean find2(Node node, int data) {
        if (node == null)
            return false;

        if (node.data == data) {
            path2.add(node);
            return true;
        }

        boolean filc = find2(node.left, data);
        if (filc) {
            path2.add(node);
            return true;
        }
        boolean firc = find2(node.right, data);
        if (firc) {
            path2.add(node);
            return true;
        }
        return filc || firc;
    }
    //****************PRINT K LEVELS DOWN****************
    public static void printKLevelsDown(Node node, int k, Node blocker) {
        if (node == null || k < 0 || node == blocker)
            return;
        if (k == 0)
            System.out.println(node.data);

        printKLevelsDown(node.left, k - 1, blocker);
        printKLevelsDown(node.right, k - 1, blocker);

    }

    // *******************PRINT K NODES FAR******************
    public static void printKNodesFar(Node node, int data, int k) {
        find2(node, data);

        for (int i = 0; i < path2.size(); i++) { //2
            printKLevelsDown(path2.get(i), k - i, i == 0 ? null : path2.get(i - 1)); //3
        }
    }



    public static void main(String[] args) {

        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Integer[] arr2 = {4, 1, 5, null, 3, null, 8, 2, null, 6};
        Integer[] arr3 = {50, 25, 12, null, null, 37, null, null, 75, 62, null, null, 87, null, null};
        Node root = construct(arr);
        display(root);

        System.out.println("-----------------------");

//        multisolver(root, 0);
//        System.out.println("Max -> " + max);
//        System.out.println("Min -> " + min);
//        System.out.println("Size -> " + size);
//        System.out.println("Height ->" + height);

//        boolean isBST = isBinary(root);
//        System.out.println(isBST);

//        levelOrderLineWise(root);
            printKNodesFar(root, 37, 2);

    }

}
