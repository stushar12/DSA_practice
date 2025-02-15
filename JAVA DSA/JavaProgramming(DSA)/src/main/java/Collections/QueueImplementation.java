package Collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImplementation {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();   // linkedlist class is implementing Queue interface

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println("Peek element is " + queue.peek());

        System.out.println("Before poll operation "+queue);
        queue.poll();
        System.out.println("After poll operation "+queue);

    }
}
