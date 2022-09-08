package Trees;

import java.util.*;

public class GenericTrees {

    public static class Node {

        int data;
        ArrayList<Node> children = new ArrayList<>();

        public Node(int data) {
            this.data = data;
        }

    }

    public static class pair {
        Node node;
        int state;

        pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }


    public static class GenericTree implements Iterable<Integer> {

        static Node root;

        GenericTree() {
            root = null;
        }

        GenericTree(int[] eulerArray) {
            root = constructTree(eulerArray);
        }

        //====================================================================
        static Stack<Node> st = new Stack<>();

        public static Node constructTree(int[] arr) {

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] == -1) {
                    st.pop();
                } else {
                    Node temp = new Node(arr[i]);
                    if (st.size() > 0) {
                        st.peek().children.add(temp);
                    } else {
                        root = temp;
                    }

                    st.push(temp);

                }
            }

            return root;
        }

        //====================================================================
        private static void display(Node root) {
            String str = root.data + " -> ";

            for (Node child : root.children) {
                str += child.data + ", ";
            }
            str += ".";
            System.out.println(str);

            for (Node child : root.children
            ) {
                display(child);
            }

        }

        //====================================================================
        private static int size(Node root) {

            int size = 1;

            for (Node child :
                    root.children) {
                size += size(child);
            }

            return size;
        }

        //====================================================================
        private static int max(Node root) {

            int max = root.data;

            for (Node child : root.children
            ) {
                max = Math.max(max, max(child));
            }

            return max;
        }


        //====================================================================
        private static int height(Node root) {

            int height = -1;

            for (Node child : root.children
            ) {
                int childHeight = height(child);
                height = Math.max(height, childHeight);
            }

            height += 1;

            return height;
        }

        //====================================================================
        public static void traversal(Node root) {

            System.out.println("Node Pre " + root.data);

            for (Node child : root.children) {
                System.out.println("Edge Pre " + root.data + "--" + child.data);
                traversal(child);
                System.out.println("Edge Post " + root.data + "--" + child.data);
            }

            System.out.println("Node Post " + root.data);

        }

        //==============================================================
        public static void levelOrder(Node node) {
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(node);

            while (queue.size() > 0) {

                node = queue.remove();

                System.out.print(node.data + " ");

                for (Node child : node.children) {
                    queue.add(child);
                }

            }

            System.out.println(".");
        }

        //==============================================================
        public static void levelOrderLineWise(Node node) {
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(node);
            System.out.print(node.data);

            while (queue.size() > 0) {

                node = queue.remove();

//                System.out.print(node.data + " ");
                if (node.children.size() > 0)
                    System.out.println();

                for (Node child : node.children) {
                    queue.add(child);
                    System.out.print(child.data + " ");
                }

            }

            System.out.println();
        }

        //==============================================================
        public static void lineWise(Node node) {

            Queue<Node> mq = new ArrayDeque<>();
            mq.add(root);
            Queue<Node> cq = new ArrayDeque<>();

            while (mq.size() > 0) {

                node = mq.remove();

                System.out.print(node.data + " ");

                for (Node child : node.children) {
                    cq.add(child);
//                    System.out.println(child.data + "------");
                }

                if (mq.size() == 0) {
                    System.out.println();
                    mq = cq;
                    cq = new ArrayDeque<>();
                }


            }


        }

        //==============================================================
        public static void zigzag(Node node) {

            Stack<Node> mq = new Stack<>();
            mq.add(node);
            Stack<Node> cq = new Stack<>();
            int level = 0;

            while (mq.size() > 0) {

                node = mq.pop();

                System.out.print(node.data + " ");

                if (level % 2 == 0) {
                    for (int i = 0; i < node.children.size(); i++) {
                        Node child = node.children.get(i);
                        cq.push(child);
                    }
                } else {
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        Node child = node.children.get(i);
                        cq.push(child);
                    }
                }

                if (mq.size() == 0) {
                    System.out.println();
                    mq = cq;
                    cq = new Stack<>();
                    level++;
                }


            }

        }

        public static void mirror(Node node) {

            for (Node child : node.children
            ) {
                mirror(child);
            }

            Collections.reverse(node.children);

        }


        public static void removeLeaves(Node node) {

            ArrayList<Node> al = new ArrayList<>();

            for (Node child : node.children
            ) {

                if (child.children.size() == 0) {
                    al.add(child);
                }
                removeLeaves(child);
            }

            node.children.removeAll(al);

        }

        private static Node getTail(Node node) {

            while (node.children.size() == 1) {
                node = node.children.get(0);
            }
            return node;
        }

        public static void linearizeTree(Node node) {

            for (Node child : node.children) {
                linearizeTree(child);
            }

            while (node.children.size() > 1) {
                Node lastChild = node.children.remove(node.children.size() - 1);
                Node secondLastChild = node.children.get(node.children.size() - 1);
                Node secondLastChildTail = getTail(secondLastChild);
                secondLastChildTail.children.add(lastChild);
            }

        }

        //optimized approach
        public static Node linearizeTree2(Node node) {

            if (node.children.size() == 0)
                return node;

            Node lastNodeTail = linearizeTree2(node.children.get(node.children.size() - 1));

            while (node.children.size() > 1) {
                Node lastChild = node.children.remove(node.children.size() - 1);
                Node secondLastChild = node.children.get(node.children.size() - 1);
                Node secondLastChildTail = linearizeTree2(secondLastChild);
                secondLastChildTail.children.add(lastChild);
            }
            return lastNodeTail;
        }


        public static boolean find(Node node, int data) {
            if (node.data == data) {
                return true;
            }

            for (Node child : node.children) {
                boolean fic = find(child, data);
                if (fic) {
                    return true;
                }
            }

            return false;
        }

        public static LinkedList<Integer> nodeToRootPath(Node node, int data) {

            if (node.data == data) {
                LinkedList<Integer> ll = new LinkedList<>();
                ll.add(node.data);
                return ll;
            }

            for (Node child : node.children) {
                LinkedList<Integer> ans = nodeToRootPath(child, data);

                if (ans.size() > 0) {
                    ans.addFirst(node.data);
                    return ans;
                }
            }
            return new LinkedList<>();
        }

        public static int lowestCommonAncestor(Node node, int d1, int d2) {

            LinkedList<Integer> p1 = nodeToRootPath(node, d1);
            LinkedList<Integer> p2 = nodeToRootPath(node, d2);

            int ans = 0;

            while (p1.peek() == p2.peek()) {
                ans = p1.pop();
                p2.pop();
            }

            return ans;

        }

        public static int distanceBtwNodes(Node node, int d1, int d2) {

            LinkedList<Integer> p1 = nodeToRootPath(node, d1);
            LinkedList<Integer> p2 = nodeToRootPath(node, d2);

//            Collections.reverse(p1);
//            Collections.reverse(p2);

            int i = 0;
            int j = 0;

            while (p1.get(i) == p2.get(j)) {
                i++;
                j++;
            }

            int ans = (p1.size() - i) + (p2.size() - j);
            return ans;
        }

        public static boolean areSimilar(Node n1, Node n2) {

            if (n1.children.size() != n2.children.size()) {
                return false;
            }

            for (Node child1 : n1.children) {

                for (Node child2 : n2.children) {

                    return areSimilar(child1, child2);

                }

            }
            return true;
        }

        public static boolean areMirror(Node n1, Node n2) {

            if (n1.children.size() != n2.children.size()) {
                return false;
            }

            for (int i = 0, j = n2.children.size() - 1; i < n1.children.size() && j >= 0; i++, j--) {

                Node child1 = n1.children.get(i);
                Node child2 = n2.children.get(j);

                if (areMirror(child1, child2) == false)
                    return false;

            }

            return true;

        }

        public static boolean isSymmetric(Node node) {

            return areMirror(node, node);

        }


        static int size = 0;
        static int height = 0;
        static int min = Integer.MAX_VALUE;
        static int max = Integer.MIN_VALUE;

        public static void multisolver(Node node, int depth) {

            size++;
            min = Math.min(min, node.data);
            max = Math.max(max, node.data);
            height = Math.max(height, depth);
            for (Node child : node.children) {
                multisolver(child, depth + 1);
            }

        }


        static Node pre = new Node(0);
        static Node post = new Node(0);
        static int state = 0;

        public static void prePostOfElement(Node node, int data) {

            if (state == 0) {
                if (node.data == data) {
                    state = 1;
                } else {
                    pre = node;
                }
            } else if (state == 1) {
                post = node;
                state = 2;
            }

            for (Node child : node.children) {
                prePostOfElement(child, data);
            }
        }


        static int ceil;
        static int floor;

        public static void ceilAndFloor(Node node, int data) {
            // Write your code here
            if (node.data > data) {
                ceil = Math.min(ceil, node.data);
            } else if (node.data < data) {
                floor = Math.max(floor, node.data);
            }

            for (Node child : node.children) {
                ceilAndFloor(child, data);
            }

        }


        static HashMap<Integer, Integer> maxSubTreeSum = new HashMap<>();

        public static int maximumSubTreeSum(Node node) {
            int sum = node.data;

            for (Node child : node.children) {
                sum += maximumSubTreeSum(child);
            }
            maxSubTreeSum.put(node.data, sum);

            return sum;
        }

        public static void NodeWithMaxSubTreeSum(Node node) {
            maximumSubTreeSum(node);

            int maxNode = 0;
            int maxSum = Integer.MIN_VALUE;

            for (Map.Entry<Integer, Integer> o : maxSubTreeSum.entrySet()) {

                if (o.getValue() > maxSum) {
                    maxSum = o.getValue();
                    maxNode = o.getKey();
                }

            }

            System.out.println(maxNode + " @ " + maxSum);

        }

        static int diameter = 0;

        static int getDiameter(Node node) {

            int h1 = -1;
            int h2 = -1;

            for (Node child : node.children) {
                int ch = getDiameter(child);

                if (ch > h1) {
                    h2 = h1;
                    h1 = ch;
                } else if (ch > h2) {
                    h2 = ch;
                }

            }

            if ((h1 + 1 + h2 + 1) > diameter) {
                diameter = h1 + 1 + h2 + 1;
            }

            return h1 + 1;

        }

        static void iterativePrePostOrder(Node node) {

            String preOrder = "";
            String postOrder = "";

            Stack<pair> st = new Stack<>();

            st.push(new pair(node, -1));

            while (st.size() > 0) {

                pair element = st.peek();

                if (element.state == -1) {
                    preOrder += element.node.data + " ";
                    element.state++;
                } else if (element.state > -1 && element.state < element.node.children.size()) {
                    st.push(new pair(element.node.children.get(element.state), -1));
                    element.state++;
                } else if (element.state == element.node.children.size()) {
                    postOrder += element.node.data + " ";
                    st.pop();
                }

            }

            System.out.println("PreOrder -> " + preOrder);
            System.out.println("PostOrder -> " + postOrder);

        }

        @Override
        public Iterator<Integer> iterator() {
            Iterator<Integer> obj = new GTPreorderIterator(root);
            return obj;
        }

    }

    public static class GTPreorderIterator implements Iterator<Integer> {
        static Integer nval;
        Stack<pair> st;

        public GTPreorderIterator(Node node) {
//            GenericTree.display(node);
            st = new Stack<>();
            st.push(new pair(node, -1));
            next();
        }

        public boolean hasNext() {
            if (nval == null) {
                return false;

            } else {
                return false;
            }
        }

        //**********************next() function************************
        public Integer next() {
            Integer fr = nval;
            // moves nval forward, if not possible sets it to null
            nval = null;
            while (st.size() > 0) {
                pair top = st.peek();
//                System.out.println("-----"+top.node.data);
                if (top.state == -1) {
                    nval = top.node.data;
                    top.state++;
                    break;
                } else if (top.state >= 0 && top.state < top.node.children.size()) {
                    pair cp = new pair(top.node.children.get(top.state), -1);
                    st.push(cp);
                    top.state++;

                } else {
                    st.pop();
                }
            }
            System.out.println(nval);
            return fr;
        }

    }


    public static void main(String[] args) {

        int[] eulerArray = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        int[] arr = {10, 20, 50, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, -1, 40, 100, -1, -1, -1};
        int[] arr2 = {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1};

        GenericTree gt = new GenericTree(arr);
        Node root = gt.root;

//        System.out.println("---------------Display-------------");
//        gt.display(root);
//
//        System.out.println("-----------------------------------");
//        System.out.println("Size of first tree -> " + gt.size(root));
//        System.out.println("Max element of 1st tree -> " + gt.max(root));
//        System.out.println("Height of 1st tree -> " + gt.height(root));
//
//        System.out.println("------------Traversal--------------");
//        gt.traversal(root);
//
        System.out.println("----------Level Order--------------");
        gt.levelOrder(root);
//
        System.out.println("----------Level Order Line Wise--------------");
        gt.levelOrderLineWise(root);
//
//        System.out.println("----------LineWise Order-----------");
//        gt.lineWise(root);
//
//        System.out.println("-------LineWise Order Zig Zag------");
//        gt.zigzag(root);
//
//        System.out.println("---------------Mirror--------------");
//        gt.mirror(root);
//        gt.display(root);
//
//        System.out.println("----------Remove Leaves------------");
//        gt.removeLeaves(root);
//        gt.display(root);
//
//        System.out.println("----------Linearize Tree------------");
//        gt.linearizeTree2(root);
//        gt.display(root);
//
//        System.out.println("-----------------Find-----------------");
//        System.out.println(gt.find(root, 120));
//
//        System.out.println("----------Node to root path------------");
//        LinkedList<Integer> ans = gt.nodeToRootPath(root, 120);
//        System.out.println(ans);
//
//        System.out.println("-------Lowest common Ancestor----------");
//        System.out.println(gt.lowestCommonAncestor(root, 70, 110));
//
//        System.out.println("-------Distance between 2 nodes----------");
//        System.out.println(gt.distanceBtwNodes(root, 50, 110));
//
//        System.out.println("-------Are 2 nodes similar----------");
//        Node node2 = gt.constructTree(arr2);
//        System.out.println(gt.areSimilar(root, node2));
//
//        System.out.println("-------Is node Symmetric----------");
//        System.out.println(gt.isSymmetric(root));
//
//        System.out.println("-----------MultiSolver--------------");
//        gt.multisolver(root,0);
//        System.out.println(gt.size);
//        System.out.println(gt.max);
//        System.out.println(gt.min);
//        System.out.println(gt.height);
//
//        System.out.println("Predecessor And Successor Of An Element");
//        gt.prePostOfElement(root,80);
//        System.out.println("Predecessor -> "+gt.pre.data);
//        System.out.println("Successor -> "+gt.post.data);
//
//        System.out.println("----Ceil And Floor Of An Element----");
//        gt.ceilAndFloor(root,80);
//        System.out.println("Ceil -> "+gt.ceil);
//        System.out.println("Floor -> "+gt.floor);
//
//        System.out.println("----Node with maximum subtree sum-----");
//        gt.NodeWithMaxSubTreeSum(root);
//
//        System.out.println("-------------Diameter of tree-----------");
//        gt.getDiameter(root);
//        System.out.println(gt.diameter);
//
//        System.out.println("----------Iterative pre post order--------");
//        gt.iterativePrePostOrder(root);
// 
//        for (int val : gt) {
//            System.out.println(val);
//        }

//        Iterator<Integer> gti =  gt.iterator();
//        while(gti.hasNext()){
//            System.out.println(gti.next());
//        }


    }

}
