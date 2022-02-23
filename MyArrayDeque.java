import java.util.ArrayDeque;

class MyDeque<E>{

    public static class Node<E>{
        E data;
        Node<E> next, prev;

        Node(E data){
            this.data = data;
            next = prev = null;
        }
    }

    public Node<E> head = null;
    public Node<E> tail = null;

    public Boolean isEmpty(){
        return head == null;
    }

    public void addFirst(E data){
        Node<E> toAdd = new Node<>(data);

        if(isEmpty()){
            head = tail = toAdd;
            return;
        }

        toAdd.next = head;
        head.prev = toAdd;
        head = toAdd;

    }

    public void addLast(E data){
        Node<E> toAdd = new Node<>(data);

        if(isEmpty()){
            head = tail = toAdd;
            return;
        }

        tail.next = toAdd;
        toAdd.prev = tail;
        tail = toAdd;

    }

    public E removeFirst(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }

        Node<E> toRemove = head;

        head = head.next;
        head.prev = null;

        return toRemove.data;

    }

    public E removeLast(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }

        Node<E> toRemove = tail;

        tail = tail.prev;
        tail.next = null;

        if(tail == null){
            head = null;
        }
        return toRemove.data;

    }

    public E peekFirst(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }

        return head.data;
    }

    public E peekLast(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }

        return tail.data;
    }

}


public class MyArrayDeque {


    public static void main(String[] args){
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.push(1);
        ad.push(2);
        ad.push(3);
        ad.push(4);

        System.out.println(ad);
        System.out.println(ad.pop());

        System.out.println();

        MyDeque<Integer> myad = new MyDeque<>();
        myad.addFirst(1);
        myad.addFirst(2);
        myad.addFirst(3);
        System.out.println(myad.removeFirst());
        System.out.println(myad.removeLast());

    }
}
