import java.util.*;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ComputerRPN {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public static void main(String[] args) {
        MyStackA stack = new MyStackA();
        Scanner in = new Scanner(System.in);
        String rpn = in.nextLine();
        StringTokenizer st = new StringTokenizer(rpn);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            // System.out.println(t);
            System.out.println(t + " is a number -> " + isNumeric(t));
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
        in.close();
    }
}