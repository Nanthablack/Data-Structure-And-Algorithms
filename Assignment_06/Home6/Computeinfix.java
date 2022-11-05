import java.util.*;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Computeinfix {

    static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostFix(String expression) {

        String result = "";
        MyQueueString Queue = new MyQueueString();

        // Stack<Character> stack = new Stack<>();
        MyStackChar StackOperator = new MyStackChar();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // check if char is operator
            if (precedence(c) > 0) {
                while (StackOperator.isEmpty() == false && precedence(StackOperator.top()) >= precedence(c)) {
                    result += StackOperator.pop() + " ";
                    Queue.enqueue(result);
                }
                StackOperator.push(c);

            } else if (c == ')') {
                char x = StackOperator.pop();
                while (x != '(') {
                    result += x + " ";
                    Queue.enqueue(result);
                    x = StackOperator.pop();
                }
            } else if (c == '(') {
                StackOperator.push(c);
            } else {
                // character is neither operator nor (
                result += c;
                Queue.enqueue(result);
            }
        }
        while (!StackOperator.isEmpty()) {
            result += StackOperator.pop() + " ";
            Queue.enqueue(result);
        }
        // System.out.print(Queue);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        System.out.println("Postfix : " + infixToPostFix(exp));
        result(infixToPostFix(exp));
    }

    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public static void result(String rpn) {

        MyStackA stack = new MyStackA();
        StringTokenizer st = new StringTokenizer(rpn);

        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            // System.out.println(t);
            if (isNumeric(t))
                stack.push(Double.parseDouble(t));
            else {
                if (t.equals("-")) {

                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a - b);

                } else if (t.equals("+")) {

                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a + b);

                } else if (t.equals("*")) {

                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a * b);

                } else if (t.equals("/")) {

                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a / b);
                }
            }
        }
        System.out.print("result: " + stack.pop());
    }
}

// ____________________________________________________________________________________________________________________________________
class MyQueueString {
    // ____________________________________________________________________________________________________________________________________
    int MAX_SIZE = 100;
    String queue[] = new String[MAX_SIZE];
    int head = 0, tail = 0;

    public void enqueue(String d) {

        queue[tail] = d;
        tail = (tail + 1) % MAX_SIZE;
    }

    public String dequeue() {

        String d = queue[head];
        tail = (tail - 1) % MAX_SIZE;
        for (int i = 0; i < tail; i++) {
            queue[i] = queue[i + 1];
        }
        return d;
    }

    public String front() {

        return queue[0];
    }

    public boolean isFull() {

        return ((tail + 1) % MAX_SIZE) == head;
    }

    public boolean isEmpty() {

        return head == tail;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < tail - 1; i++) {
            sb.append(queue[i]);
            sb.append(",");
        }
        if (tail > 0)
            sb.append(queue[tail - 1]);
        sb.append("]");
        return sb.toString();
    }
    // ____________________________________________________________________________________________________________________________________
}

// ____________________________________________________________________________________________________________________________________
class MyStackA {
    // ____________________________________________________________________________________________________________________________________
    int MAX_SIZE = 100;
    double stack[] = new double[MAX_SIZE];
    int top = 0;

    public void push(double d) {
        stack[top++] = d;
    }

    public double pop() {
        return stack[--top];
    }

    public double top() {
        return stack[top - 1];
    }

    public boolean isFull() {
        return top == MAX_SIZE;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < top - 1; i++) {
            sb.append(stack[i]);
            sb.append(",");
        }
        if (top > 0)
            sb.append(stack[top - 1]);
        sb.append("]");
        return sb.toString();
    }
    // ____________________________________________________________________________________________________________________________________
}

// ____________________________________________________________________________________________________________________________________
class MyStackChar {
    // ____________________________________________________________________________________________________________________________________
    int MAX_SIZE = 100;
    char stack[] = new char[MAX_SIZE];
    int top = 0;

    public void push(char d) {
        stack[top++] = d;
    }

    public char pop() {
        return stack[--top];
    }

    public char top() {
        return stack[top - 1];
    }

    public boolean isFull() {
        return top == MAX_SIZE;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < top - 1; i++) {
            sb.append(stack[i]);
            sb.append(",");
        }
        if (top > 0)
            sb.append(stack[top - 1]);
        sb.append("]");
        return sb.toString();
    }
    // ____________________________________________________________________________________________________________________________________
}
