class MyLinkedList<E> {

    Node head;
    private int sizeList;

    MyLinkedList() {
        sizeList = 0;
    }

    public class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
            next = null;
//            sizeList++;
        }
    }

    Boolean isEmpty() {
        return (head == null);
    }

    void addFirst(E data) {
        Node toAdd = new Node(data);

        sizeList++;
        toAdd.next = head;
        head = toAdd;

    }

    void addLast(E data) {
        Node toAdd = new Node(data);

        if (isEmpty()) {
            sizeList++;
            head = toAdd;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        sizeList++;
        current.next = toAdd;

    }

    void removeFirst() {
        if (isEmpty()) {
            return;
        }

        head = head.next;
        sizeList--;
    }

    void removeLast() {
        if (isEmpty()) {
            return;
        }

        Node lastSecond = head;
        Node last = head.next;

        sizeList--;

        if (last == null) {
            head = null;
            return;
        }

        while (last.next != null) {

            lastSecond = last;
            last = last.next;
        }

        lastSecond.next = null;


    }

    Node deleteFromEnd( Node head, int n){
        if(head == null || head.next==null){
            return null;
        }

        int listSize = 0;
        Node startNode = head;
        while(startNode !=null){
            listSize++;
            startNode = startNode.next;
        }
        System.out.println("Size of the list is --> " + listSize);

        if(listSize == n){
            return head.next;
        }

        int nodeDelete = listSize - n ; //2
        System.out.println("Prev Node to delete from starting (" + listSize + " - " + n + ") --> " + nodeDelete);

        Node currNode = head;
        int i=1;

        while(nodeDelete > i){
            currNode = currNode.next;
            i++;
        }

        currNode.next = currNode.next.next;

        return head;

    }

    int listSize() {
        return sizeList;
    }

    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    //Reverse a linkedList Interativly
    void reverseInterative() {
        if (isEmpty() || (head.next == null)) {
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;

        while (currNode != null) {
            Node nextNode = currNode.next;

            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;

    }

    //Reverse LinkedList recursively
    public Node reverseRecursive(Node head) {

        if (isEmpty() || head.next == null) {
            return head;
        }

        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public Node reverseBetween(Node head, int left, int right) {

        if(left == right || head.next == null || head==null){
            return head;
        }

        Node currNode = head;

        int i=1;
        while(currNode != null){

            if(left == i){
                Node prevNode = currNode;

                Node part = reverse(prevNode, right - left + 1);

                currNode.next = part;

                return currNode;

            }

            currNode = currNode.next;
            i++;
        }

        return currNode;


    }

    Node reverse(Node startNode, int end){

        if (startNode==null || (startNode.next == null)) {
            return startNode;
        }
        Node prevNode = startNode;
        Node currNode = startNode.next;

        int i = 1;
        while (i<end) {
            Node nextNode = currNode.next;

            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            i++;
        }

        startNode = prevNode;
        return startNode;


    }



    public static void main(String[] Args) {

        MyLinkedList<Integer> ll = new MyLinkedList<>();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.printList();
        System.out.println(" --> size of list = " + ll.listSize());

        ll.head = ll.reverseRecursive(ll.head);
        ll.printList();
//
//        System.out.println();
//
//        ll.addLast(1);
//        ll.addLast(2);
//        ll.addLast(3);
//        ll.addLast(4);
//        ll.addLast(5);

//        ll.printList();
//        System.out.println(" --> size of list = " + ll.listSize());
//        System.out.println();
//
//        ll.removeFirst();
//        ll.removeLast();
//
//        ll.printList();
//        System.out.println(" --> size of list = " + ll.listSize());
//        System.out.println();

//        ll.head = ll.deleteFromEnd(ll.head, 2);
//        ll.printList();

//        ll.reverseBetween(ll.head, 2,4);
//        ll.printList();

    }

}
