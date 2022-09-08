import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

//test input
//12
//push 4
//pop
//push 3
//push 5
//push 2
//inc 3 1
//pop
//push 1
//inc 2 2
//push 4
//pop
//pop

//test output
//        4
//        EMPTY
//        3
//        5
//        2
//        3
//        6
//        1
//        1
//        4
//        1
//        8


public class SuperStack {

    private static Stack<Integer> mainStack = new Stack<>();

    public static void printStack() {
        if (mainStack.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            System.out.println(mainStack.peek());
        }
    }

    public static void addStack(int val) {
        mainStack.push(val);
        printStack();
    }

    public static void removeStack() {
        mainStack.pop();
        printStack();
    }

    public static void inc(int limit, int valToAdd) {

        Stack<Integer> tempStack = new Stack<>();

        for (int i = 1; i <= mainStack.size() - limit; i++) {
            tempStack.push(mainStack.pop());
        }

        while (!mainStack.isEmpty()) {
            tempStack.push((mainStack.pop() + valToAdd));
        }

        while (!tempStack.isEmpty()) {
            mainStack.push(tempStack.pop());
        }

        printStack();

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = Integer.parseInt(sc.nextLine());
        String[] inputArr = new String[x];

        for (int i = 0; i < x; i++) {
            inputArr[i] = sc.nextLine();
        }

        long start = System.nanoTime();

        for (int i = 0; i < x; i++) {
//            System.out.println("input -> " +inputArr[i]);
            String[] sArr = inputArr[i].split(" ");
//            System.out.println(sArr[0]);

            if (Objects.equals(sArr[0], "push")) {
                addStack(Integer.parseInt(sArr[1]));
            } else if (Objects.equals(sArr[0], "pop")) {
                removeStack();
            } else {
                inc(Integer.parseInt(sArr[1]), Integer.parseInt(sArr[2]));
            }

        }

        long end = System.nanoTime();

        float execution = end - start;
        System.out.println("Execution time: " + execution / 1000000 + " milliseconds");


//        addStack(4);
//        removeStack();
//        addStack(3);
//        addStack(5);
//        addStack(2);
//        inc(3,1);
//        removeStack();
//        addStack(1);
//        inc(2,2);
//        addStack(4);
//        removeStack();
//        removeStack();

    }

}
