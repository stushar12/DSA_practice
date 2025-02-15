package Collections;

import java.util.ArrayDeque;

public class ArrayDeQueImplementation {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.offer(24);
        deque.offerFirst(12);
        deque.offerLast(36);

        System.out.println(deque);

        System.out.println("Peek results: ");
        System.out.println(deque.peek());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());


        System.out.println("Poll results: ");
        System.out.println(deque.poll());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());

        System.out.println("Deque size: " +deque.size());

    }
}
