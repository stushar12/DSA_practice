package Collections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueImplementation {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue= new PriorityQueue<>();        //min-heap by default
        priorityQueue.offer(40);
        priorityQueue.offer(12);
        priorityQueue.offer(24);
        priorityQueue.offer(36);

        System.out.println("Elements in Priority Queue: " + priorityQueue);

        priorityQueue.poll();   //element with the highest priority will go out (here the smallest element)

        System.out.println("Elements in Priority Queue after poll operation: " + priorityQueue);

        System.out.println(priorityQueue.peek());   //element which is next to leave or highest priority




        PriorityQueue<Integer> priorityQueue1= new PriorityQueue<>(Comparator.reverseOrder());   //max-heap by default
        priorityQueue1.offer(40);
        priorityQueue1.offer(12);
        priorityQueue1.offer(24);
        priorityQueue1.offer(36);

        System.out.println("Elements in Priority Queue: " + priorityQueue1);

        priorityQueue1.poll();   //element with the highest priority will go out (here the largest element)

        System.out.println("Elements in Priority Queue after poll operation: " + priorityQueue1);


        System.out.println(priorityQueue.peek());   //element which is next to leave or highest priority
    }
}
