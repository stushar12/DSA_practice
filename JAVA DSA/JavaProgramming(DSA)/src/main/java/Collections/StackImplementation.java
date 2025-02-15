package Collections;

import java.util.Stack;

public class StackImplementation {
    public static void main(String[] args) {
        Stack<String> names = new Stack<String>();

        names.push("Tushar");
        names.push("Rahul");
        names.push("Ashish");
        names.push("Dheeraj");

        System.out.println(names);

        System.out.println(names.peek());

        System.out.println(names.empty());

        System.out.println(names.size());

        System.out.println();
    }
}
