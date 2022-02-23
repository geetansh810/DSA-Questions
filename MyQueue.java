import java.util.Stack;

public class MyQueue {

    static class QueueAsArray {

        static int[] arr;
        static int size;
        static int rear;

        QueueAsArray(int n) {
            size = n;
            arr = new int[n];
            rear = -1;
        }

        public static Boolean isEmpty() {
            return (rear == -1);
        }

        public static Boolean isFull() {
            return (rear == size - 1);
        }

        //enqueue
        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }

            rear++;
            arr[rear] = data;
        }

        //dequeue
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;

        }

        //peek
        public int peek() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return arr[0];

        }

    }

    static class QueueAsLinkedList<E> {

        static class Node<E> {
            E data;
            Node<E> next;

            Node(E data) {
                this.data = data;
                next = null;
            }
        }

        Node<E> head;
        Node<E> tail;

        public Boolean isEmpty() {
            return (head == null && tail == null);
        }

        //enqueue
        public void add(E data) {

            Node<E> toAdd = new Node<>(data);

            //add of first element
            if (isEmpty()) {
                head = tail = toAdd;
                return;
            }

            tail.next = toAdd;
            tail = toAdd;

        }

        //dequeue
        public E remove() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return null;
            }

            Node<E> toRemove = head;
            //single element in the queue
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }

            return toRemove.data;

        }

        //peek
        public E peek() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return null;
            }

            return (E) head.data;

        }


    }

    static class CircularQueueAsArray {

        static int[] arr;
        static int size;
        static int rear = -1;
        static int front = -1;

        CircularQueueAsArray(int n) {
            arr = new int[n];
            size = n;
        }

        public Boolean isEmpty() {
            return (rear == -1 && front == -1);
        }

        public Boolean isFull() {
            return ((rear + 1)%size == front);
        }

        public void add(int data) {

            if (isEmpty()) {
                front =0;
                rear = (rear+1) % size;
                arr[rear] = data;
            } else if (isFull()) {
                System.out.println("Queue is full");
            } else {
                rear = (rear + 1) % size;
                arr[rear] = data;
            }

        }

        public int remove() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int temp = arr[front];

            //if only one element is present
            if(front == rear){
                front = rear = -1;
            }else{
                front = (front + 1) % size;
            }
                return temp;
        }

        public int peek() {
            return arr[front];
        }

    }

    static class QueueUsing2Stack {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public Boolean isEmpty() {
            return s1.isEmpty();
        }

        public void add(int data) {
            if (isEmpty()) {
                s1.push(data);
            } else {

                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }

                s1.push(data);

                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }

            }
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }

    }

    public static void main(String[] args) {

        System.out.println("<-- Queue implementation using array -->");
        System.out.println();
        QueueAsArray que = new QueueAsArray(4);
        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);

        while (!QueueAsArray.isEmpty()) {
            System.out.println(que.peek());
            que.remove();
        }

        que.remove();

        System.out.println();
        System.out.println("<-- Queue implementation using LinkedList -->");
        System.out.println();

        QueueAsLinkedList<Integer> q1 = new QueueAsLinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);

        while (!q1.isEmpty()) {
            System.out.println(q1.peek());
            q1.remove();
        }

        q1.remove();

        System.out.println();
        System.out.println("<-- Circular Queue implementation using array -->");
        System.out.println();
        CircularQueueAsArray queCircular = new CircularQueueAsArray(4);
        queCircular.add(1);
        queCircular.add(2);
        queCircular.add(3);
        queCircular.add(4);

        System.out.println(queCircular.remove());
        System.out.println(queCircular.remove());
        queCircular.add(5);
        queCircular.add(6);

        while (!queCircular.isEmpty()) {
            System.out.println(queCircular.peek());
            queCircular.remove();
        }


        System.out.println();
        System.out.println("<-- Queue implementation using 2 stacks -->");
        System.out.println();
        QueueUsing2Stack q2 = new QueueUsing2Stack();

        q2.add(1);
        q2.add(2);
        q2.add(3);
        q2.add(4);

        while (!q2.isEmpty()) {
            System.out.println(q2.peek());
            q2.remove();
        }


    }

}
