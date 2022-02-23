import java.util.ArrayList;
import java.util.Stack;

public class MyStack {

    //Node class
    static class Node<E> {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
            next = null;
        }

    }

    //Stack implementation in LinkedList
    static class StackAsLinkedList<E> {

        Node<E> head;

        public Boolean isEmpty() {
            return (head == null);
        }

        public void push(E data) {
            Node<E> toPush = new Node<>(data);

            if (isEmpty()) {
                head = toPush;
                return;
            }

            toPush.next = head;
            head = toPush;
        }

        public E pop() {

            if (isEmpty()) {
                return null;
            }
            E top = head.data;
            head = head.next;
            return top;

        }

        public E peek() {

            if (isEmpty()) {
                return null;
            }

            return head.data;

        }


    }

    static class StackAsArrayList<E> {
        ArrayList<E> list = new ArrayList<>();

        public Boolean isEmpty() {
            return (list.size() == 0);
        }

        public void push(E data) {
            list.add(data);
        }

        public E pop() {
            if (isEmpty()) {
                return null;
            }
            return list.remove(list.size() - 1);
        }

        public E peek() {
            if (isEmpty()) {
                return null;
            }
            return list.get(list.size() - 1);

        }

    }

    public static void main(String[] Args) {

        System.out.println("<---- Stack as LinkedList ---->");
        StackAsLinkedList<Integer> stack1 = new StackAsLinkedList<>();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);

        while (!stack1.isEmpty()) {
            System.out.println(stack1.peek());
            stack1.pop();
        }

        System.out.println();
        System.out.println("<---- Stack as ArrayList ---->");

        StackAsArrayList<String> stack2 = new StackAsArrayList<>();

        stack2.push("This");
        stack2.push("is");
        stack2.push("ArrayList");
        stack2.push("Stack");

        while (!stack2.isEmpty()) {
            System.out.println(stack2.peek());
            stack2.pop();
        }

        System.out.println();
        System.out.println("<---- Stack as Collection FrameWork ---->");

        Stack<Character> stack3 = new Stack<>();

        stack3.push('S');
        stack3.push('T');
        stack3.push('A');
        stack3.push('C');
        stack3.push('k');

        while (!stack3.isEmpty()) {
            System.out.println(stack3.peek());
            stack3.pop();
        }



    }


}
