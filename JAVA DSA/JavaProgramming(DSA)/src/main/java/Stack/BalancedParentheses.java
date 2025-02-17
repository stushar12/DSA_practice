package Stacks;

import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        isValid("[{}(())]");
    }

    static boolean isValid(String str) {
        int len = str.length();
        if (len % 2 == 1) return false;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (!st.isEmpty()) {
                char topCh = st.peek();
                if ((ch == '}' && topCh == '{')
                        || (ch == ']' && topCh == '[')
                        || (ch == ')' && topCh == '(')) st.pop();
                else return false;
            }
        }

        return st.isEmpty();
    }
}

